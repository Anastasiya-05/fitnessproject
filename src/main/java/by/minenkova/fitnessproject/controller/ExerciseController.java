package by.minenkova.fitnessproject.controller;

import by.minenkova.fitnessproject.dto.ExerciseDto;
import by.minenkova.fitnessproject.entity.Exercise;
import by.minenkova.fitnessproject.entity.Training;
import by.minenkova.fitnessproject.exceptions.NoSuchEntityException;
import by.minenkova.fitnessproject.service.ExerciseService;
import by.minenkova.fitnessproject.service.TrainingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping
public class ExerciseController {
    private ExerciseService exerciseService;

    private TrainingService trainingService;

    @Autowired
    public ExerciseController(ExerciseService exerciseService, TrainingService trainingService) {
        this.exerciseService = exerciseService;
        this.trainingService = trainingService;
    }

    @GetMapping(value={"/exerciseList"})
    public ModelAndView exerciseList(Model model){
        List<Exercise> exercises = exerciseService.getAllExercise();
        log.info("exerciseList"+exercises);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("exerciseList");
        model.addAttribute("exercises", exercises);
        model.addAttribute("trainingID", 0);
        log.info("/exerciseList was called");
        return modelAndView;
    }
    @GetMapping(value={"/exerciseList/{id}"})
    public ModelAndView exerciseList(@PathVariable("id") Long id, Model model){
        Training training = trainingService.getById(id).get();
        List<Exercise> exercises = training.getExercises();
        log.info("exerciseList"+exercises);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("exerciseList");
        model.addAttribute("exercises", exercises);
        model.addAttribute("trainingID", id);
        log.info("/exerciseList was called");
        return modelAndView;
    }
    @GetMapping(value = {"/addExercise"})
    public ModelAndView showAddExercisePage(Model model) {
        ModelAndView modelAndView = new ModelAndView("addExercise");
        ExerciseDto exerciseForm = new ExerciseDto();
        model.addAttribute("exerciseForm", exerciseForm);
        log.info("/addExercise - GET was called" + exerciseForm);
        return modelAndView;
    }

    @PostMapping(value = {"/addExercise"})
    public ModelAndView saveExercise(Model model, @ModelAttribute("exerciseForm") ExerciseDto exerciseDto) {
        ModelAndView modelAndView = new ModelAndView();
        log.info("/addExercise - POST was called" + exerciseDto);
        modelAndView.setViewName("exerciseList");
        Long id = exerciseDto.getId();
        String exerciseNumber = exerciseDto.getExerciseNumber();
        String exerciseName = exerciseDto.getExerciseName();
        String approaches = exerciseDto.getApproaches();
        String numOfReps = exerciseDto.getNumOfReps();
        Training training = exerciseDto.getTraining();

        Exercise newExercise = new Exercise(id, exerciseNumber, exerciseName, approaches, numOfReps, training);
        exerciseService.addNewExercise(newExercise);
        model.addAttribute("exercises", exerciseService.getAllExercise());
        log.info("/addExercises - POST was called!");
        return modelAndView;
    }
    @GetMapping(value = {"/addExercise/{id}"})
    public ModelAndView saveExercise(@PathVariable("id") Long id, Model model, @ModelAttribute("exerciseForm") ExerciseDto exerciseDto) {
        ModelAndView modelAndView = new ModelAndView("addExercise");
        ExerciseDto exerciseForm = new ExerciseDto();
        model.addAttribute("exerciseForm", exerciseForm);
        model.addAttribute("trainingID", id);
        log.info("/addExercise - GET was called" + exerciseForm);
        return modelAndView;
    }

    @PostMapping(value = {"/addExercise/{id}"})
    public ModelAndView saveExerciseToTraining(@PathVariable("id") Long trainingID, Model model, @ModelAttribute("exerciseForm") ExerciseDto exerciseDto) {
        log.info("/addExercise for training id " + trainingID + " - POST was called" + exerciseDto);
        ModelAndView modelAndView = new ModelAndView("redirect:/exerciseList/" + trainingID); //после добавления упражнения готовим редирект на список всех упражнений этой тренировки

        //формируем Exercise Entity (Long id = null для того что бы он савтогенерировался(как у в Entity и задекларировано для него)
        Long id = null;
        String exerciseNumber = exerciseDto.getExerciseNumber();
        String exerciseName = exerciseDto.getExerciseName();
        String approaches = exerciseDto.getApproaches();
        String numOfReps = exerciseDto.getNumOfReps();

        //достаем тренировку (можно в одну строку сделать)
        Optional<Training> trainingOptional = trainingService.getById(trainingID);
        Training training = trainingOptional.get();

        //сохраняем Exercise Entity
        Exercise newExercise = new Exercise(id, exerciseNumber, exerciseName, approaches, numOfReps, training);
        exerciseService.addNewExercise(newExercise);


        //далее обновляем лист Exercises для тренировки
        //проверяем, что он не пустой сначала, если не пустой, то записываем
        if(training.getExercises() != null) {
            training.getExercises().add(newExercise);
        } else {
            //иначе создаем новый лист, записываем в него упражнение и сохраняем все в training Entity
            List<Exercise> trainingExerciceList = new ArrayList<Exercise>();
            trainingExerciceList.add(newExercise);
            training.setExercises(trainingExerciceList);
        }
        trainingService.editTraining(training); //обновляем trainingEntity в базу

        log.info("/addExercise for training id " + trainingID + " - POST was called!");

        return modelAndView;
    }
    @RequestMapping(value = {"/editExercise/{id}"}, method = RequestMethod.GET)
    public ModelAndView editPage(@PathVariable("id") Long id) throws NoSuchEntityException{
        Exercise exercise = exerciseService.getById(id).orElseThrow(() -> new NoSuchEntityException("Exercise not found"));
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editExercise");
        modelAndView.addObject("exercise", exercise);
        return modelAndView;
    }
    @RequestMapping(value = {"/editExercise/{id}"}, method = RequestMethod.POST)
    public ModelAndView editExercise(@Valid@ModelAttribute("exercise")Exercise exercise, Errors errors){
        log.info("/editExercise - POST was called" + exercise);
        exerciseService.addNewExercise(exercise);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/exerciseList/{id}");
        return modelAndView;
    }
    @RequestMapping(value = "/deleteExercise/{id}", method = RequestMethod.GET)
    public ModelAndView deleteExercise(@PathVariable("id") Long id) throws NoSuchEntityException {
        Exercise exercise = exerciseService.getById(id).orElseThrow(() -> new NoSuchEntityException("Exercise not found"));
        exerciseService.deleteExercise(exercise);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/exerciseList");
        return modelAndView;
    }
}



package by.minenkova.fitnessproject.controller;

import by.minenkova.fitnessproject.dto.ExerciseDto;
import by.minenkova.fitnessproject.dto.NewPersonDto;
import by.minenkova.fitnessproject.dto.TrainingDto;
import by.minenkova.fitnessproject.entity.Exercise;
import by.minenkova.fitnessproject.entity.Person;
import by.minenkova.fitnessproject.entity.Training;
import by.minenkova.fitnessproject.exceptions.NoSuchEntityException;
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

@Slf4j
@RestController
@RequestMapping
public class TrainingController {

    private final TrainingService trainingService;

    @Autowired
    public TrainingController(TrainingService trainingService) {this.trainingService = trainingService;}

    @GetMapping(value={"/trainingList"})
    public ModelAndView trainingList(Model model){
        List<Training> trainings = trainingService.getAllTraining();
        log.info("training List"+trainings);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("trainingList");
        model.addAttribute("trainings", trainings);
        log.info("/trainingList was called");
        return modelAndView;
    }
    @GetMapping(value={"/addTraining"})
    public ModelAndView showAddTrainingPage(Model model){
        ModelAndView modelAndView  =new ModelAndView("addTraining");
        TrainingDto trainingForm = new TrainingDto();
        model.addAttribute("trainingForm", trainingForm);
        log.info("/addTraining - GET was called" + trainingForm);
        return modelAndView;
    }
    @PostMapping(value = {"/addTraining"})
    public ModelAndView saveTraining(Model model, @Valid @ModelAttribute("trainingForm") TrainingDto trainingDto, Errors errors) {
        ModelAndView modelAndView = new ModelAndView();
        log.info("/addTraining - POST was called" + trainingDto);
        if (errors.hasErrors()) {
            modelAndView.setViewName("addTraining");
        } else {
            modelAndView.setViewName("trainingList");
            Long id = trainingDto.getId();
            String trainingName = trainingDto.getTrainingName();
            String dayWeek = trainingDto.getDayWeek();
            List<Exercise> exercises = trainingDto.getExercises();


            Training newTraining = new Training(id, trainingName, dayWeek, exercises);
            trainingService.addNewTraining(newTraining);
            model.addAttribute("trainings", trainingService.getAllTraining());
            log.info("/addTraining - POST was called!");
            return modelAndView;
        }
        return modelAndView;
    }
    @RequestMapping(value = "/deleteTraining/{id}", method = RequestMethod.GET)
    public ModelAndView deleteTraining(@PathVariable("id") Long id) throws NoSuchEntityException {
        Training training = trainingService.getById(id).orElseThrow(() -> new NoSuchEntityException("Training not found"));
        trainingService.deleteTraining(training);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/trainingList");
        return modelAndView;
    }



    }


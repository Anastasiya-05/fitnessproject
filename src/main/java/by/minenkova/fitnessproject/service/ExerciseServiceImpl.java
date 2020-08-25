package by.minenkova.fitnessproject.service;

import by.minenkova.fitnessproject.entity.Exercise;
import by.minenkova.fitnessproject.entity.Training;
import by.minenkova.fitnessproject.repository.ExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ExerciseServiceImpl implements ExerciseService {

    private final ExerciseRepository exerciseRepository;

    @Autowired
    public ExerciseServiceImpl(ExerciseRepository exerciseRepository) {this.exerciseRepository = exerciseRepository;}

    @Override
    public List<Exercise> getAllExercise() {
        return exerciseRepository.findAll();
    }

    @Override
    public void addNewExercise(Exercise exercise) {
        exerciseRepository.save(exercise);
    }

    @Override
    public void deleteExercise(Exercise exercise) {
        exerciseRepository.delete(exercise);
    }

    @Override
    public void editExercise(Exercise exercise) {
        exerciseRepository.save(exercise);
    }

    @Override
    public Optional<Exercise> getById(long id) {
        return exerciseRepository.findAllById(id);
    }

    @Override
    public List<Exercise> findExercisesByTraining(Training getTrainingId){
        return exerciseRepository.findAll();
    }
}

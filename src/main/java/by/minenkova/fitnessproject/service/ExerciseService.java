package by.minenkova.fitnessproject.service;

import by.minenkova.fitnessproject.entity.Exercise;
import by.minenkova.fitnessproject.entity.Training;

import java.util.List;
import java.util.Optional;

public interface ExerciseService {
    List<Exercise> getAllExercise();
    void addNewExercise(Exercise exercise);
    void deleteExercise(Exercise exercise);
    void editExercise(Exercise exercise);
    Optional<Exercise> getById(long id);
    List<Exercise> findExercisesByTraining(Training getTrainingById);
}

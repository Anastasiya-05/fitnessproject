package by.minenkova.fitnessproject.service;

import by.minenkova.fitnessproject.entity.Exercise;
import by.minenkova.fitnessproject.entity.Training;

import java.util.List;
import java.util.Optional;

public interface TrainingService {
    List<Training> getAllTraining();
    void addNewTraining(Training training);
    void deleteTraining(Training training);
    void editTraining(Training training);
    Optional<Training> getById(long id);
}

package by.minenkova.fitnessproject.service;

import by.minenkova.fitnessproject.entity.Exercise;
import by.minenkova.fitnessproject.entity.Training;
import by.minenkova.fitnessproject.repository.TrainingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TrainingServiceImpl implements TrainingService {

    private final TrainingRepository trainingRepository;

    @Autowired
    public TrainingServiceImpl(TrainingRepository trainingRepository) {
        this.trainingRepository = trainingRepository;
    }

    public List<Training> getAllTraining() {
        return trainingRepository.findAll();
    }

    public void addNewTraining(Training training) {
        trainingRepository.save(training);
    }

    public void deleteTraining(Training training) {
        trainingRepository.delete(training);
    }

    public void editTraining(Training training) {
        trainingRepository.save(training);
    }

    public Optional<Training> getById(long id) {
        return trainingRepository.findAllById(id);
    }
}

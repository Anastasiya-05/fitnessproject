package by.minenkova.fitnessproject.repository;

import by.minenkova.fitnessproject.entity.Training;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TrainingRepository extends CrudRepository<Training, Long> {
    List<Training> findAll();
    Optional<Training> findAllById(Long id);
}

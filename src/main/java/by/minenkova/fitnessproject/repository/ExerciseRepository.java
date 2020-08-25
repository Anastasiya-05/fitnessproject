package by.minenkova.fitnessproject.repository;

import by.minenkova.fitnessproject.entity.Exercise;
import by.minenkova.fitnessproject.entity.Training;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

@Repository
public interface ExerciseRepository extends CrudRepository<Exercise, Long> {
    List<Exercise> findAll();
    Optional<Exercise> findAllById(Long id);
}

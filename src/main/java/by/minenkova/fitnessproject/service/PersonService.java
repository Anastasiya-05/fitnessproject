package by.minenkova.fitnessproject.service;

import by.minenkova.fitnessproject.entity.Person;

import java.util.List;
import java.util.Optional;

public interface PersonService {
    List<Person> getAllPerson();
    void addNewPerson(Person person);
    void deletePerson(Person person);
    void editPerson(Person person);
    Optional<Person> getById(int id);
}

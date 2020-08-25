package by.minenkova.fitnessproject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.dao.DataAccessException;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    private String firstName;
    private String lastName;
    private String street;
    private String city;
    private String email;
    private Integer age;
    private String phone;

    //public Person(String firstName, String lastName, String street, String city, String zip, String email, Integer age, String phone) {}
    //public Person() {}
}

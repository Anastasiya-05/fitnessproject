package by.minenkova.fitnessproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonDto {
    private Integer personId;
    private String firstName;
    private String lastName;
    private String street;
    private String city;
    private String email;
    private Integer age;
    private String phone;
}

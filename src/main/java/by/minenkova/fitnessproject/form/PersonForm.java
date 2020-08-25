package by.minenkova.fitnessproject.form;

import by.minenkova.fitnessproject.validator.CellPhone;
import by.minenkova.fitnessproject.validator.PersonAgeConstraint;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonForm {
    @NotBlank(message = "{valid.firstname.notBlank}")
    @Size(min=3, message = "{valid.firstname.size.min3}")
    private String firstName;
    @NotBlank(message = "{valid.lastname.notBlank}")
    private String lastName;
    @NotBlank(message = "{valid.street.notBlank}")
    private String street;
    @NotBlank(message = "{valid.city.notBlank}")
    private String city;
    @NotBlank(message = "{valid.email.notBlank}")
    @Email(message = "{valid.email.email}")
    private String email;
    @Digits(integer = 3, fraction = 0, message = "{valid.age.digits}")
    @PersonAgeConstraint(message = "{valid.age.personageconstraint}")
    private Integer age;
    //@Pattern(regexp="^(0?[1-9]|[12][0-9]|3[01])[\\/\\-](0?[1-9]|1[012])[\\/\\-]\\d{4}$", message="Must be formatted DD/MM/YYYY")
    //ISO 8601 date format (yyyy-MM-dd)
    //@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    //@Past(message = "{valid.birthday.past}")
    //private Date birthday;
    @CellPhone(message = "{valid.phone.cellphone}")
    private String phone;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() { return age; }

    public void setAge(Integer age) { this.age = age; }

    public String getPhone() { return phone; }

    public void setPhone(String phone) { this.phone = phone; }
}




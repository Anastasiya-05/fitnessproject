package by.minenkova.fitnessproject.dto;

import by.minenkova.fitnessproject.validator.CellPhone;
import by.minenkova.fitnessproject.validator.PersonAgeConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewPersonDto {
    private Integer personId;
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

    public Integer getPersonId() {
        return personId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getEmail() {
        return email;
    }

    public Integer getAge() {
        return age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}



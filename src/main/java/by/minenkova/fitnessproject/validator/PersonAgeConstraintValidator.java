package by.minenkova.fitnessproject.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PersonAgeConstraintValidator implements ConstraintValidator<PersonAgeConstraint, Integer> {

    @Override
    public void initialize(PersonAgeConstraint paramB){
    }

    @Override
    public boolean isValid(Integer ageNom, ConstraintValidatorContext ctx){
        if(ageNom==null || ageNom<0){
            return false;
        }
        else return true;
    }
}

package by.minenkova.fitnessproject.form;

import by.minenkova.fitnessproject.entity.Training;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExerciseForm {
    @NotBlank
    private String exerciseNumber;
    @NotBlank
    private String exerciseName;
    private String approaches; //кол-во подходов
    private String numOfReps; //кол-во повторений
    private Training training;

    public Training getTraining() {
        return training;
    }

    public void setTraining(Training training) {
        this.training = training;
    }

    public String getExerciseNumber() {
        return exerciseNumber;
    }

    public void setExerciseNumber(String exerciseNumber) {
        this.exerciseNumber = exerciseNumber;
    }

    public String getExerciseName() {
        return exerciseName;
    }

    public void setExerciseName(String exerciseName) {
        this.exerciseName = exerciseName;
    }

    public String getApproaches() {
        return approaches;
    }

    public void setApproaches(String approaches) {
        this.approaches = approaches;
    }

    public String getNumOfReps() {
        return numOfReps;
    }

    public void setNumOfReps(String numOfReps) {
        this.numOfReps = numOfReps;
    }


}

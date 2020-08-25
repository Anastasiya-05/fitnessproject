package by.minenkova.fitnessproject.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "exercise")
@AllArgsConstructor
public class Exercise {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    private Long id;
    @Basic
    @Column(name = "exercise_num")
    private String exerciseNumber;
    @Column(name = "exercise_name")
    private String exerciseName;
    @Column(name = "approaches")
    private String approaches; //кол-во подходов
    @Column(name = "num_of_reps")
    private String numOfReps; //кол-во повторений
    @ManyToOne
    @JoinColumn (name="training_id")
    private Training training;

    public Training getTraining() {
        return training;
    }

    public void setTraining(Training training) {
        this.training = training;
    }

    public Exercise() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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



   public String toString() {
        return "Exercise {id = " + String.valueOf(id) +
                ", Название упражнения = " + exerciseName +
                ", Номер упражнения = " + exerciseNumber +
                ", Количество подходов = " + approaches +
                ", Количество повторений = " + numOfReps +
                //", training_id = " + getTraining().getId() +
                "}";
    }
}

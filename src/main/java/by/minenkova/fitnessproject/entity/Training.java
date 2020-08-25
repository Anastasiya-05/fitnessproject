package by.minenkova.fitnessproject.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "training")
@AllArgsConstructor
public class Training {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "training_name")
    private String trainingName;
    @Column(name = "day_week")
    private String dayWeek;

    //fetch=FetchType.LAZY,
    //@Column(name = "exercises")
    @OneToMany (mappedBy="training", cascade=CascadeType.ALL, orphanRemoval = true)
    private List<Exercise> exercises;

    public List<Exercise> getExercises() {
        return exercises;
    }

    public void setExercises(List<Exercise> exercises) {
        this.exercises = exercises;
    }

    public Training() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTrainingName() {
        return trainingName;
    }

    public void setTrainingName(String trainingName) {
        this.trainingName = trainingName;
    }

    public String getDayWeek() {
        return dayWeek;
    }

    public void setDayWeek(String dayWeek) {
        this.dayWeek = dayWeek;
    }

   /* @Override
    public String toString() {
        String exers = "";
        if((exercises !=null) && (exercises.size() >0)){
            for (int i=0; i<exercises.size(); i++){
                if (i>0)
                    exers += ",";
                exers += exercises.get(i).toString();
            }
        }
        return "Exercise {id = " + String.valueOf(id) +
                ", Название тренировки = " + trainingName +
                ", День недели = " + dayWeek +
                ", Упражнения = [" + exers + "]}";
    }*/
}


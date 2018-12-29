package REST.entities.students;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Data
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private String grade;

    private Long courseId;

    public Student(String name, String grade) {
        this.name = name;
        this.grade = grade;
    }

    public Student(String name, String grade, Long courseId) {
        this.name = name;
        this.grade = grade;
        this.courseId = courseId;
    }



}

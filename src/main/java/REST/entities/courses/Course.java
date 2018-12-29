package REST.entities.courses;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Course {

    @Id
    @GeneratedValue
    private Long id;
    private String title;

    public Course(String title) {
        this.title = title;
    }
}

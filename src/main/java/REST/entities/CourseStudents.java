package REST.entities;

import REST.entities.students.Student;
import lombok.Data;

import java.util.List;

@Data
public class CourseStudents {

    private Long id;
    private String title;
    private List<Student> students;

    public CourseStudents(Long id, String title, List<Student> students) {
        this.id = id;
        this.title = title;
        this.students = students;
    }
}

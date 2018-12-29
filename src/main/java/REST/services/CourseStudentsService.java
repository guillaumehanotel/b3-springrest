package REST.services;

import REST.entities.CourseStudents;
import REST.entities.courses.Course;
import REST.entities.students.Student;
import REST.exceptions.CourseNotFoundException;
import REST.repositories.CourseRepository;
import REST.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseStudentsService {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private CourseRepository courseRepository;

    public CourseStudents getCourseWithStudents(Long id){
        Course course = courseRepository.findById(id).orElseThrow(() -> new CourseNotFoundException(id));
        List<Student> studentList = studentRepository.findAllByCourseId(id);
        return new CourseStudents(id, course.getTitle(), studentList);
    }

}

package REST.controllers;

import REST.entities.courses.Course;
import REST.entities.students.Student;
import REST.exceptions.CourseNotFoundException;
import REST.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    private CourseRepository courseRepository;

    @RequestMapping(value = "/courses", method = RequestMethod.GET)
    List<Course> getAll(){
        return courseRepository.findAll();
    }

    @RequestMapping(value = "/courses", method = RequestMethod.POST)
    Course create(@RequestBody Course course){
        return courseRepository.save(course);
    }

    @RequestMapping(value = "/courses/{id}", method = RequestMethod.GET)
    Course getOne(@PathVariable Long id){
        return courseRepository.findById(id).orElseThrow(() -> new CourseNotFoundException(id));
    }

    @RequestMapping(value = "/courses/{id}", method = RequestMethod.PUT)
    Course update(@RequestBody Course newCourse, @PathVariable Long id){
        return courseRepository.findById(id)
                .map(course -> {
                    course.setTitle(newCourse.getTitle());
                    return courseRepository.save(course);
                }).orElseGet(() -> {
                    newCourse.setId(id);
                    return courseRepository.save(newCourse);
                });
    }

    @RequestMapping(value = "/courses/{id}", method = RequestMethod.DELETE)
    void delete(@PathVariable Long id){
        courseRepository.deleteById(id);
    }


}

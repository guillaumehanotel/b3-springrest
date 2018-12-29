package REST.controllers;

import REST.entities.CourseStudents;
import REST.services.CourseStudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseStudentsController {

    @Autowired
    private CourseStudentsService courseStudentsService;

    @RequestMapping(value = "/courseStudents/{id}", method = RequestMethod.GET)
    CourseStudents getCourseWithStudents(@PathVariable Long id){
        return courseStudentsService.getCourseWithStudents(id);
    }


}

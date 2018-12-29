package REST.controllers;

import REST.entities.students.Student;
import REST.exceptions.StudentNotFoundException;
import REST.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @RequestMapping(value = "/students", method = RequestMethod.GET)
    List<Student> getAll(){
        return studentRepository.findAll();
    }

    @RequestMapping(value = "/students", method = RequestMethod.POST)
    Student create(@RequestBody Student student){
        return studentRepository.save(student);
    }

    @RequestMapping(value = "/students/{id}", method = RequestMethod.GET)
    Student getOne(@PathVariable Long id){
        return studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException(id) );
    }

    @RequestMapping(value = "/students/{id}", method = RequestMethod.PUT)
    Student update(@RequestBody Student newStudent, @PathVariable Long id){
        return studentRepository.findById(id)
                .map(student -> {
                    student.setName(newStudent.getName());
                    student.setGrade(newStudent.getGrade());
                    return studentRepository.save(student);
                }).orElseGet(() -> {
                    newStudent.setId(id);
                    return studentRepository.save(newStudent);
                });
    }

    @RequestMapping(value = "/students/{id}", method = RequestMethod.DELETE)
    void delete(@PathVariable Long id){
        studentRepository.deleteById(id);
    }


}

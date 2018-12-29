package REST.configurations;

import REST.entities.courses.Course;
import REST.entities.students.Student;
import REST.repositories.CourseRepository;
import REST.repositories.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class InitDatabase {


    @Bean
    CommandLineRunner seedDatabase(StudentRepository studentRepository, CourseRepository courseRepository){
        return args -> {
          log.info("Database initialisation with : " + courseRepository.save(new Course("Java")));
          log.info("Database initialisation with : " + courseRepository.save(new Course("NodeJS")));
          log.info("Database initialisation with : " + courseRepository.save(new Course("React")));
          log.info("Database initialisation with : " + studentRepository.save(new Student("Tintin", "Bachelor 3", 1L)));
          log.info("Database initialisation with : " + studentRepository.save(new Student("Billy", "Master 1", 1L)));
          log.info("Database initialisation with : " + studentRepository.save(new Student("Toto", "Bachelor 1", 2L)));
          log.info("Database initialisation with : " + studentRepository.save(new Student("Tata", "Bachelor 1", 2L)));
        };
    }


}

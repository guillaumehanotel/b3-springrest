package REST.repositories;

import REST.entities.students.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    //List<Student> findByGradeContainsAndName(String gradeContains, String name);

    List<Student> findAllByCourseId(Long courseId);


}

package ir.mobin.studentspringboot.repository;

import ir.mobin.studentspringboot.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends UserRepository<Student> {

    Optional<Student> findByStdNumber(Long stdNumber);

    Optional<Student> findByStdNumberAndIdNot(Long stdNumber, Long id);

}

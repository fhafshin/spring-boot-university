package ir.mobin.studentspringboot.repository;

import ir.mobin.studentspringboot.entity.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfessorRepository extends UserRepository<Professor> {

    Optional<Professor> findByCode(int code);

    Optional<Professor> findByCodeAndIdNot(int code, Long id);

}

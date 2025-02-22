package ir.mobin.studentspringboot.service;

import ir.mobin.studentspringboot.entity.Course;
import ir.mobin.studentspringboot.entity.Professor;

import java.util.List;

public interface ProfessorService {

    Professor save(Professor professor);



    Professor findById(Long id);

    Professor update(Professor professor);

    void delete(Long id) ;

    List<Professor> findAll();
}

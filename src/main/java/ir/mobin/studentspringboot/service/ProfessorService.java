package ir.mobin.studentspringboot.service;

import ir.mobin.studentspringboot.dto.professor.AddProfessorDto;
import ir.mobin.studentspringboot.dto.professor.UpdateProfessorDto;
import ir.mobin.studentspringboot.dto.professor.ViewProfessorDto;
import ir.mobin.studentspringboot.entity.Course;
import ir.mobin.studentspringboot.entity.Professor;

import java.util.List;

public interface ProfessorService {

    ViewProfessorDto save(AddProfessorDto professor);



    ViewProfessorDto findById(Long id);

    ViewProfessorDto update(UpdateProfessorDto professor);

    void delete(Long id) ;

    List<ViewProfessorDto> findAll();
}

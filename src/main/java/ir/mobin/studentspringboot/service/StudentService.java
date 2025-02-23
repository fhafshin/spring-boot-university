package ir.mobin.studentspringboot.service;

import ir.mobin.studentspringboot.dto.student.AddStudentDto;
import ir.mobin.studentspringboot.dto.student.UpdateStudentDto;
import ir.mobin.studentspringboot.dto.student.ViewStudentDto;
import ir.mobin.studentspringboot.entity.Course;
import ir.mobin.studentspringboot.entity.Student;

import java.util.List;

public interface StudentService {

    ViewStudentDto save(AddStudentDto student);

   Student findByStdNumber(Long stdNumber);

    ViewStudentDto findById(Long id);

    ViewStudentDto update(UpdateStudentDto student);

    void delete(Long id) ;

    List<ViewStudentDto> findAll();

    UpdateStudentDto toUpdateStudentDto(Student student);
}

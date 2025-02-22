package ir.mobin.studentspringboot.service;

import ir.mobin.studentspringboot.entity.Course;
import ir.mobin.studentspringboot.entity.Student;

import java.util.List;

public interface StudentService {

    Student save(Student student);



    Student findById(Long id);

    Student update(Student student);

    void delete(Long id) ;

    List<Student> findAll();
}

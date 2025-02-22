package ir.mobin.studentspringboot.service;

import ir.mobin.studentspringboot.entity.Course;
import ir.mobin.studentspringboot.exception.ConflictException;
import ir.mobin.studentspringboot.exception.NotFoundException;

import java.util.List;
import java.util.Optional;

public interface CourseService {

    Course save(Course course);



     Course findById(Long id);

     Course update(Course course);

     void delete(Long id) ;

     List<Course> findAll();
}

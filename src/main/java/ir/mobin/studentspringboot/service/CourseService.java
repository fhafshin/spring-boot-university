package ir.mobin.studentspringboot.service;

import ir.mobin.studentspringboot.dto.course.AddCourseDto;
import ir.mobin.studentspringboot.dto.course.UpdateCourseDto;
import ir.mobin.studentspringboot.dto.course.ViewCourseDto;
import ir.mobin.studentspringboot.dto.student.UpdateStudentDto;
import ir.mobin.studentspringboot.entity.Course;
import ir.mobin.studentspringboot.exception.ConflictException;
import ir.mobin.studentspringboot.exception.NotFoundException;

import java.util.List;
import java.util.Optional;

public interface CourseService {

    ViewCourseDto save(AddCourseDto course);

    UpdateCourseDto toUpdateCourseDto(Course course);

     ViewCourseDto findById(Long id);

     ViewCourseDto update(UpdateCourseDto course);

     void delete(Long id) ;

     List<ViewCourseDto> findAll();
}

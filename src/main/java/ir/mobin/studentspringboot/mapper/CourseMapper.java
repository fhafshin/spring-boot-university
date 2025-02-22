package ir.mobin.studentspringboot.mapper;

import ir.mobin.studentspringboot.dto.course.AddCourseDto;
import ir.mobin.studentspringboot.dto.course.UpdateCourseDto;
import ir.mobin.studentspringboot.entity.Course;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CourseMapper {

    private final ModelMapper modelMapper;

    public Course toEntity(AddCourseDto addCourseDto) {return modelMapper.map(addCourseDto, Course.class);}
    public Course toEntity(UpdateCourseDto updateCourseDto) {return modelMapper.map(updateCourseDto, Course.class);}
}

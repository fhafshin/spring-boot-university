package ir.mobin.studentspringboot.mapper;

import ir.mobin.studentspringboot.dto.course.AddCourseDto;
import ir.mobin.studentspringboot.dto.course.UpdateCourseDto;
import ir.mobin.studentspringboot.dto.course.ViewCourseDto;
import ir.mobin.studentspringboot.dto.student.UpdateStudentDto;
import ir.mobin.studentspringboot.entity.Course;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class CourseMapper {

    private final ModelMapper modelMapper;

    public Course toEntity(AddCourseDto addCourseDto) {return modelMapper.map(addCourseDto, Course.class);}
    public Course toEntity(UpdateCourseDto updateCourseDto) {return modelMapper.map(updateCourseDto, Course.class);}
    public ViewCourseDto toViewDto(Course course) {

        ViewCourseDto viewCourseDto= modelMapper.map(course, ViewCourseDto.class);

        List<String> studentsNames=course.getStudents().stream().map(s->s.getName()).collect(Collectors.toList());
        viewCourseDto.setStudentsNames(studentsNames);

        return viewCourseDto;
    }

    public UpdateCourseDto toUpdateCourseDto(Course course) {
        return modelMapper.map(course,UpdateCourseDto.class);
    }
}

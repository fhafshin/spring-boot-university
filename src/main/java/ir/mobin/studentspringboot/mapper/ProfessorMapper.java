package ir.mobin.studentspringboot.mapper;

import ir.mobin.studentspringboot.dto.course.AddCourseDto;
import ir.mobin.studentspringboot.dto.course.UpdateCourseDto;
import ir.mobin.studentspringboot.dto.course.ViewCourseDto;
import ir.mobin.studentspringboot.dto.professor.AddProfessorDto;
import ir.mobin.studentspringboot.dto.professor.UpdateProfessorDto;
import ir.mobin.studentspringboot.dto.professor.ViewProfessorDto;
import ir.mobin.studentspringboot.entity.Course;
import ir.mobin.studentspringboot.entity.Professor;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class ProfessorMapper {
    private final ModelMapper modelMapper;


    public Professor toEntity(AddProfessorDto addProfessorDto) {return modelMapper.map(addProfessorDto, Professor.class);}
    public Professor toEntity(UpdateProfessorDto updateProfessorDto) {return modelMapper.map(updateProfessorDto, Professor.class);}
    public ViewProfessorDto toViewDto(Professor professor) {

        ViewProfessorDto viewCourseDto= modelMapper.map(professor, ViewProfessorDto.class);

       //add details and map ....

        return viewCourseDto;
    }

}

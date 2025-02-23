package ir.mobin.studentspringboot.mapper;

import ir.mobin.studentspringboot.dto.professor.AddProfessorDto;
import ir.mobin.studentspringboot.dto.professor.UpdateProfessorDto;
import ir.mobin.studentspringboot.dto.professor.ViewProfessorDto;
import ir.mobin.studentspringboot.dto.student.AddStudentDto;
import ir.mobin.studentspringboot.dto.student.UpdateStudentDto;
import ir.mobin.studentspringboot.dto.student.ViewStudentDto;
import ir.mobin.studentspringboot.entity.Professor;
import ir.mobin.studentspringboot.entity.Student;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class StudentMapper {

    private final ModelMapper modelMapper;
    public Student toEntity(AddStudentDto addStudentDto) {return modelMapper.map(addStudentDto, Student.class);}
    public Student toEntity(UpdateStudentDto updateStudentDto) {return modelMapper.map(updateStudentDto, Student.class);}
    public ViewStudentDto toViewDto(Student student) {

        ViewStudentDto viewCourseDto= modelMapper.map(student, ViewStudentDto.class);

        //add details and map ....

        return viewCourseDto;
    }

    public UpdateStudentDto toUpdateStudent(Student student) {

        return modelMapper.map(student, UpdateStudentDto.class);
    }
}

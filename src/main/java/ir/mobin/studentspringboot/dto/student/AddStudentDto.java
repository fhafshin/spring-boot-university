package ir.mobin.studentspringboot.dto.student;

import ir.mobin.studentspringboot.dto.user.AddUserDto;
import ir.mobin.studentspringboot.enums.AcademicLevel;
import jakarta.validation.constraints.NotNull;

public class AddStudentDto extends AddUserDto {
@NotNull
    private AcademicLevel academicLevel;
}

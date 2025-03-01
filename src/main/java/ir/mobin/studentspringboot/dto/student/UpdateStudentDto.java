package ir.mobin.studentspringboot.dto.student;

import ir.mobin.studentspringboot.dto.user.UpdateUserDto;
import ir.mobin.studentspringboot.enums.AcademicLevel;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UpdateStudentDto extends UpdateUserDto {

    private AcademicLevel academicLevel;
}

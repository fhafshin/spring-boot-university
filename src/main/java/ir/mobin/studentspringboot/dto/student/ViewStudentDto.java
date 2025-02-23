package ir.mobin.studentspringboot.dto.student;

import ir.mobin.studentspringboot.dto.user.ViewUserDto;
import ir.mobin.studentspringboot.enums.AcademicLevel;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ViewStudentDto extends ViewUserDto {
    private Long stdNumber;
    private AcademicLevel academicLevel;
}

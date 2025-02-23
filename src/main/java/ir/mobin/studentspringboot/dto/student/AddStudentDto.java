package ir.mobin.studentspringboot.dto.student;

import ir.mobin.studentspringboot.dto.user.AddUserDto;
import ir.mobin.studentspringboot.enums.AcademicLevel;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AddStudentDto extends AddUserDto {
    @NotNull
    private Long stdNumber;
    @NotNull
    private AcademicLevel academicLevel;
}

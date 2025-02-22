package ir.mobin.studentspringboot.dto.professor;

import ir.mobin.studentspringboot.dto.user.AddUserDto;
import ir.mobin.studentspringboot.enums.AcademicRank;
import jakarta.validation.constraints.NotNull;

public class AddProfessorDto extends AddUserDto {
    @NotNull
    private AcademicRank academicRank;
}

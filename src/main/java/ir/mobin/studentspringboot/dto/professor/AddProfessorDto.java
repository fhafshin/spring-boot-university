package ir.mobin.studentspringboot.dto.professor;

import ir.mobin.studentspringboot.dto.user.AddUserDto;
import ir.mobin.studentspringboot.enums.AcademicRank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AddProfessorDto extends AddUserDto {
    @NotNull
    private int code;
    @NotNull
    private AcademicRank academicRank;
}

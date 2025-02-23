package ir.mobin.studentspringboot.dto.professor;

import ir.mobin.studentspringboot.dto.user.UpdateUserDto;
import ir.mobin.studentspringboot.enums.AcademicRank;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UpdateProfessorDto extends UpdateUserDto {
    private int code;
    private AcademicRank academicRank;
}

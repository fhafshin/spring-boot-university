package ir.mobin.studentspringboot.dto.professor;

import ir.mobin.studentspringboot.dto.user.UpdateUserDto;
import ir.mobin.studentspringboot.enums.AcademicRank;

public class UpdateProfessorDto extends UpdateUserDto {

    private AcademicRank academicRank;
}

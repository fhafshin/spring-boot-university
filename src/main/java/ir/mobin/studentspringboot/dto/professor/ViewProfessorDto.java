package ir.mobin.studentspringboot.dto.professor;

import ir.mobin.studentspringboot.dto.user.ViewUserDto;
import ir.mobin.studentspringboot.enums.AcademicRank;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ViewProfessorDto extends ViewUserDto {

    private AcademicRank academicRank;
}

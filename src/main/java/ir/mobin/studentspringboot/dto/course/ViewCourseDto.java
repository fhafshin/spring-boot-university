package ir.mobin.studentspringboot.dto.course;

import ir.mobin.studentspringboot.entity.Student;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class ViewCourseDto {

    private Long id;

    private int code;


    private String title;


    private int units;

    private List<String> studentsNames;

    private String professorName;


}

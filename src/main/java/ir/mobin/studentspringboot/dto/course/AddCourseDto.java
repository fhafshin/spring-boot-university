package ir.mobin.studentspringboot.dto.course;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;

public class AddCourseDto {

   @NotNull
    private int code;

    @NotNull
    private String title;

    @NotNull
    private int units;
}

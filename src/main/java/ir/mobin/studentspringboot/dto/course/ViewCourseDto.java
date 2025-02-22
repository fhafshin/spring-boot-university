package ir.mobin.studentspringboot.dto.course;

import jakarta.validation.constraints.NotNull;

public class ViewCourseDto {
    @NotNull
    private Long id;
    @NotNull
    private int code;

    @NotNull
    private String title;

    @NotNull
    private int units;
}

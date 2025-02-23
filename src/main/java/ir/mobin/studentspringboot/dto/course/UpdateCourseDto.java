package ir.mobin.studentspringboot.dto.course;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UpdateCourseDto {
    @NotNull
    private Long id;
    private int code;


    private String title;

    private int units;
}

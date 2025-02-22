package ir.mobin.studentspringboot.dto.user;

import ir.mobin.studentspringboot.enums.Gender;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public class UpdateUserDto {
@NotNull
private Long id;
    private String name;


    private String family;


    private Long nationalCode;


    private Gender gender;


    private Date birthDay;


}

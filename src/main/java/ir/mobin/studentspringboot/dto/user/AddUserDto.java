package ir.mobin.studentspringboot.dto.user;

import ir.mobin.studentspringboot.enums.Gender;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public class AddUserDto {

    @NotNull
    private String name;

    @NotNull
    private String family;

    @NotNull
    private Long nationalCode;

    @NotNull
    private Gender gender;

    @NotNull
    private Date birthDay;

    @NotNull
    private String username;

    @NotNull
    private String password;


}

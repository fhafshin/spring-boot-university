package ir.mobin.studentspringboot.dto.user;

import ir.mobin.studentspringboot.enums.Gender;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public class ViewUserDto {


    private String name;


    private String family;


    private Long nationalCode;


    private Gender gender;


    private Date birthDay;


    private String username;


}

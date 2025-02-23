package ir.mobin.studentspringboot.dto.user;

import ir.mobin.studentspringboot.enums.Gender;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Setter
@Getter
public class UpdateUserDto {
@NotNull
private Long id;
    private String name;


    private String family;


    private Long nationalCode;


    private Gender gender;


    private Date birthDay;


}

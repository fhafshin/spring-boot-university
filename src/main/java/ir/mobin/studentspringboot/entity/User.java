package ir.mobin.studentspringboot.entity;

import com.fasterxml.jackson.databind.ser.Serializers;
import ir.mobin.studentspringboot.enums.Gender;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@MappedSuperclass
@Setter
@Getter


public class User extends BaseEntity {
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String family;

    @Column(unique = true,nullable = false)
    private Long nationalCode;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Gender gender;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date birthDay;

    @Column(nullable = false,unique = true,updatable = false)
    private String username;

    @Column(nullable = false)
    private String password;



}

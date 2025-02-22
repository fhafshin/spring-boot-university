package ir.mobin.studentspringboot.entity;

import ir.mobin.studentspringboot.enums.AcademicRank;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Professor extends User {

    @Column(unique = true, nullable = false, updatable = false)
    private int code;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AcademicRank academicRank;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "professor")
    private Set<Course> courses = new HashSet<>();

}

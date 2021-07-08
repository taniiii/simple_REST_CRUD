package com.amogoscode.amigoscode.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

//@Slf4j  - for LOGGER
//@Data - for constructor+getters+setters+toString+hashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity //for Hibernate
@Table //for DB
public class Student {
    @Id
    @SequenceGenerator(name = "student_sequence", //связывается с @GeneratedValue
                       sequenceName = "student_sequence", //определяется генератор последовательности
                       allocationSize = 1) //analog of auto_increment in MySQL
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private Long id;
    private String name;
    private String email;
    @Transient
    private Integer age;
    private LocalDate dateOfBirth;


    public Student(String name, String email, LocalDate dateOfBirth) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.dateOfBirth = dateOfBirth;
    }

    public Integer getAge(){
        return Period.between(this.dateOfBirth, LocalDate.now()).getYears();
    }
}

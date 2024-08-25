package com.example.jparelationi.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "name can not be null")
    @Column(columnDefinition = "varchar(20) not null")
    private String name;

    @Column(columnDefinition = "int not null")
    @NotNull(message = "age can not be null")
    private Integer age;

    @Email(message = "must be valid email ")
    @NotEmpty(message = "email can not be null")
    @Column(columnDefinition = "varchar(20) not null unique")
    private String email;

    @Column(columnDefinition = "DOUBLE not null")
    @NotNull(message = "salary can not be null")
    private Double salary;

    @OneToOne(cascade =CascadeType.ALL,mappedBy = "teacher")
    @PrimaryKeyJoinColumn
   private Address address;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "teacher")
    private Set<Course> courses;

}

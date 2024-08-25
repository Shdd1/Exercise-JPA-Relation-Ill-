package com.example.jparelationi.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Student {
    @Id
    @GeneratedValue
    private Integer id;

    @NotEmpty(message = "can not be empty")
    @Column(columnDefinition = "varchar(20) not null")
    private String name;

    @Column(columnDefinition = "int not null")
    @NotNull(message = "age can not be null")
    private Integer age;

    @NotEmpty(message = "can not be empty")
    @Column(columnDefinition = "varchar(20) not null")
    private String major;
    //Many to many
    @ManyToMany(mappedBy = "students")
    private Set<Course>courses;

}

package com.example.jparelationi.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
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
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "can not be empty")
    @Column(columnDefinition = "varchar(20) not null")
    private String name;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "Teacher_id", referencedColumnName = "id")
    private Teacher teacher;

    //many to many
    @ManyToMany
    @JsonIgnore
    private Set<Student> students;
}

package com.example.jparelationi.Repository;

import com.example.jparelationi.Model.Student;
import jdk.jfr.Registered;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {
    Student findStudentById(Integer stuId);
    List<Student> findStudentByCoursesId(Integer courId);
}

package com.example.jparelationi.Service;

import com.example.jparelationi.ApiExption.ApiExaption;
import com.example.jparelationi.Model.Course;
import com.example.jparelationi.Model.Teacher;
import com.example.jparelationi.Repository.CourseRepository;
import com.example.jparelationi.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {
    private final TeacherRepository teacherRepository;
    private final CourseRepository courseRepository;
    public List<Teacher> getAllTeacher(){
        return teacherRepository.findAll();
    }
    public void addTeacher(Teacher teacher){
         teacherRepository.save(teacher);

    }
    public void updateTeacher(Integer id,Teacher teacher){
        Teacher teacher1=teacherRepository.findTeacherById(id);
        if(teacher1==null){
            throw new ApiExaption("Teacher not found");
        }
       teacher1.setSalary(teacher.getSalary());
        teacher1.setName(teacher.getName());
        teacher1.setEmail(teacher.getEmail());
        teacher1.setAge(teacher.getAge());
        teacherRepository.save(teacher1);

    }
    public void deleteTeacher(Integer id){
        Teacher teacher=teacherRepository.findTeacherById(id);
        if(teacher==null){
            throw new ApiExaption("Teacher not found");
        }
        teacherRepository.save(teacher);
    }
    public Teacher getTeacherById(Integer id){
        Teacher teacher=teacherRepository.findTeacherById(id);
        if(teacher==null){
            throw new ApiExaption("Teacher not found");
        }
        return teacher;

    }

//
    public String getTeacherNameByCou(Integer course){
        Teacher teacher=teacherRepository.findTeacherByCoursesId(course);
        if(teacher==null){
            throw new ApiExaption("Course or teacher not found");
        }
      return teacher.getName();

    }




}

package com.example.jparelationi.Service;

import com.example.jparelationi.ApiExption.ApiExaption;
import com.example.jparelationi.Model.Course;
import com.example.jparelationi.Model.Student;
import com.example.jparelationi.Repository.CourseRepository;
import com.example.jparelationi.Repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;
    public List<Student> getAllStudent(){
        return studentRepository.findAll();
    }
    public void addStudent(Student student){
        studentRepository.save(student);
    }

    public void updateStudent(Integer id, Student student){
        Student student1=studentRepository.findStudentById(id);
        if(student1==null){
            throw new ApiExaption("student not found");
        }
        student1.setName(student.getName());
        student1.setAge(student.getAge());
        student1.setMajor(student.getMajor());
        student1.setCourses(student.getCourses());

        studentRepository.save(student1);
    }

    public void deleteStudent(Integer id){
        Student student=studentRepository.findStudentById(id);
        if(student==null){
            throw new ApiExaption("product not found");
        }
        studentRepository.delete(student);
    }
    // assign course to student
    public void assign(Integer stuId,Integer courId){
        Student student=studentRepository.findStudentById(stuId);
        Course course=courseRepository.findCourseById(courId);
        if(student==null||course==null){
            throw new ApiExaption("not found");

        }
        student.getCourses().add(course);
        course.getStudents().add(student);
        studentRepository.save(student);
        courseRepository.save(course);

    }

    //Create endpoint that takes class id and return the student list
    public List<Student> getStudentByCourseId(Integer courseId) {
        List<Student> students = studentRepository.findStudentByCoursesId(courseId);
        if (students.isEmpty()) {
            throw new ApiExaption("not found");
        }
        return students;

    }
}

package com.example.jparelationi.Service;

import com.example.jparelationi.ApiExption.ApiExaption;
import com.example.jparelationi.Model.Course;
import com.example.jparelationi.Model.Student;
import com.example.jparelationi.Model.Teacher;
import com.example.jparelationi.Repository.CourseRepository;
import com.example.jparelationi.Repository.StudentRepository;
import com.example.jparelationi.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;
    private final TeacherRepository teacherRepository;
    private final StudentRepository studentRepository;

    public List<Course> getAllCourse(){
        return courseRepository.findAll();
    }
    public void addCourse(Course course){

        courseRepository.save(course);
    }

    public void updateCourse(Integer id, Course course){
        Course course1=courseRepository.findCourseById(id);
        if(course1==null){
            throw new ApiExaption("Course not found");
        }
      course1.setName(course.getName());
        courseRepository.save(course1);
    }

    public void deleteCourse(Integer id){
        Course c=courseRepository.findCourseById(id);
        if(c==null){
            throw new ApiExaption("product not found");
        }
        courseRepository.delete(c);
    }
//Assign Course to teacher
        public void courseAssignToTeacher(Integer course,Integer teacher){
       Course course1=courseRepository.findCourseById(course);
        Teacher teacher1=teacherRepository.findTeacherById(teacher);
        if(course1==null||teacher1==null){
            throw new ApiExaption("Course or teacher not found");
        }
        course1.setTeacher(teacher1);
        courseRepository.save(course1);


    }
//change Major and drop courses that the student attended to
    public void changeMajor(Integer stuID,String newMajor){
        Student student=studentRepository.findStudentById(stuID);

        if(student==null){
            throw new ApiExaption("not found");
        }
        student.setMajor(newMajor);

        for(Course course:student.getCourses()){
            course.getStudents().remove(student);
            courseRepository.save(course);
        }
        student.setCourses(null);
        studentRepository.save(student);
    }



}

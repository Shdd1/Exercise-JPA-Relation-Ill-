package com.example.jparelationi.Controller;

import com.example.jparelationi.Model.Course;
import com.example.jparelationi.Service.CourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/v1/course")
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;
    @GetMapping("/get")
    public ResponseEntity getAllCorse(){
        return ResponseEntity.status(200).body(courseService.getAllCourse());
    }
    @PostMapping("/add")
    public ResponseEntity addPro(@Valid @RequestBody Course course){

        courseService.addCourse(course);
        return ResponseEntity.status(200).body("is added");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateCorse(@PathVariable Integer id,@Valid@RequestBody Course course){

        courseService.updateCourse(id,course);
        return ResponseEntity.status(200).body("is Updated");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCorse(@PathVariable Integer id){
        courseService.deleteCourse(id);
        return ResponseEntity.status(200).body("is deleted");
    }
    @PutMapping("/assign/{courseId}/{teacherId}")
    public ResponseEntity assignMerchant(@PathVariable Integer courseId,@PathVariable Integer teacherId){
        courseService.courseAssignToTeacher(courseId,teacherId);
        return ResponseEntity.status(200).body("is updated");
    }
    @PutMapping("/stu/{stuId}/major/{newMajor}")
    public ResponseEntity changeMajor(@PathVariable Integer stuId,@PathVariable String newMajor){
        courseService.changeMajor(stuId,newMajor);
        return ResponseEntity.status(200).body("Is updated");
    }
}

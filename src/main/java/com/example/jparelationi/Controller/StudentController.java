package com.example.jparelationi.Controller;

import com.example.jparelationi.Model.Student;
import com.example.jparelationi.Service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/v1/student")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping("/get")
    public ResponseEntity getAllStudent() {
        return ResponseEntity.status(200).body(studentService.getAllStudent());
    }

    @PostMapping("/add")
    public ResponseEntity addStudent(@Valid @RequestBody Student student) {

        studentService.addStudent(student);
        return ResponseEntity.status(200).body("is added");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateStudent(@PathVariable Integer id, @Valid @RequestBody Student student) {

        studentService.updateStudent(id, student);
        return ResponseEntity.status(200).body("is Updated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteStudent(@PathVariable Integer id) {
        studentService.deleteStudent(id);
        return ResponseEntity.status(200).body("is deleted");
    }
    //many to many
    @PutMapping ("/assign/{stuId}/{courId}")
    public ResponseEntity manyToMany(@PathVariable Integer stuId,@PathVariable Integer courId){
        studentService.assign(stuId,courId);
        return ResponseEntity.status(200).body("done");

    }
    //List student
    @GetMapping("/list/{courseId}")
    public ResponseEntity listStudent(@PathVariable Integer courseId){
        return ResponseEntity.status(200).body(studentService.getStudentByCourseId(courseId));
    }

}

package com.example.jparelationi.Controller;

import com.example.jparelationi.ApiResponse.ApiResponse;
import com.example.jparelationi.Model.Teacher;
import com.example.jparelationi.Service.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/teacher")
@RequiredArgsConstructor
public class TeacherController {
    private final TeacherService teacherService;
@GetMapping("/get")
    public ResponseEntity getTeacher(){
        return ResponseEntity.status(200).body(teacherService.getAllTeacher());
    }
    @PostMapping("/add")
    public ResponseEntity addTeacher(@Valid @RequestBody Teacher teacher){

        teacherService.addTeacher(teacher);
        return ResponseEntity.status(200).body(new ApiResponse("is added"));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateTeacher(@PathVariable Integer id,@Valid@RequestBody Teacher teacher){

        teacherService.updateTeacher(id,teacher);
        return ResponseEntity.status(200).body(new ApiResponse("is updated"));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteTeacher(@PathVariable Integer id){
        teacherService.deleteTeacher(id);
        return ResponseEntity.status(200).body(new ApiResponse("is deleted"));
    }
    @GetMapping("/det/{id}")
    public ResponseEntity getTeacherById(@PathVariable Integer id){
    return ResponseEntity.status(200).body(teacherService.getTeacherById(id));

    }
    @GetMapping("/te/{course}")
    public ResponseEntity getTeacherByCourse(@PathVariable Integer course){
        return ResponseEntity.status(200).body(teacherService.getTeacherNameByCou(course));

    }



}
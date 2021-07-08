package com.amogoscode.amigoscode.controller;

import com.amogoscode.amigoscode.model.Student;
import com.amogoscode.amigoscode.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {

    @Autowired   //or constructor injection
    private final StudentService studentService;

    @GetMapping
    public List<Student> getStudents(){
        return studentService.getStudentList();
    }

    @PostMapping
    public void addNewStudent(@RequestBody Student st){
        studentService.addStudent(st);
    }

    @DeleteMapping(path = "{id}")
    public void deleteStudent(@PathVariable("id") Long id){
            studentService.delete(id);
    }
}

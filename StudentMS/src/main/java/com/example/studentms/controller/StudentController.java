package com.example.studentms.controller;

import com.example.studentms.StudentService;
import com.example.studentms.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/students")
@AllArgsConstructor
@Data
public class StudentController {
    private final StudentService studentService;


    @GetMapping
    public List<Student> getStudents(){
        return studentService.getStudents();
    }
    @GetMapping("/loadData")
    public String loadData(){
        return studentService.loadData();
    }
}

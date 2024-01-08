package com.example.studentms.model;

import com.example.studentms.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentResponse {
    private Student student;
    private List<Map<String,Object>> courses;
}

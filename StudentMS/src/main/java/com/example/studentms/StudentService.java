package com.example.studentms;

import com.example.studentms.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Data
public class StudentService {
    private final StudentRepository studentRepository;

    public List<Student> getStudents(){
        return studentRepository.findAll();
    }
    public String loadData(){
        Student s1 = new Student(null,"Hamza","Elgarai","G133365030","GI5");
        Student s2 = new Student(null,"Mohamed","Hamdani","R20369502","GI5");
        Student s3 = new Student(null,"Ismail","Kaou","G00325820","GI5");
        studentRepository.saveAllAndFlush(List.of(s1,s2,s3));
        return "SUCCESS";
    }
}

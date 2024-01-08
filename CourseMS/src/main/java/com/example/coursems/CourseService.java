package com.example.coursems;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Data
public class CourseService {
    private final CourseRepository courseRepository;

    public String loadData(){
        Course c1 = new Course(null,"Microservices","GI");
        Course c2 = new Course(null,"Intelligence Artificielle","GI");
        Course c3 = new Course(null,"Systèmes industriels","GIL");
        courseRepository.saveAllAndFlush(List.of(c1,c2,c3));
        return "SUCCESS";
    }
    public List<Course> getCourses(){
        return courseRepository.findAll();
    }
}

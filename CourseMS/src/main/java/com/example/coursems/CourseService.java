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
    private final StudentCourseRepository studentCourseRepository;

    public String loadData(){
        Course c1 = new Course(2000L,"Microservices","GI");
        Course c2 = new Course(2001L,"Intelligence Artificielle","GI");
        Course c3 = new Course(2002L,"Systèmes industriels","GIL");
        courseRepository.saveAllAndFlush(List.of(c1,c2,c3));
        StudentCourse sc1 = new StudentCourse(null,1000L,2000L);
        StudentCourse sc2 = new StudentCourse(null,1000L,2001L);
        StudentCourse sc3 = new StudentCourse(null,1001L,2000L);
        studentCourseRepository.saveAllAndFlush(List.of(sc1,sc2,sc3));
        return "SUCCESS";
    }
    public List<Course> getCourses(){
        return courseRepository.findAll();
    }
}

package com.example.studentms;

import com.example.studentms.entity.Student;
import com.example.studentms.entity.StudentCourse;
import com.example.studentms.model.StudentResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Data
public class StudentService {
    private final StudentRepository studentRepository;
    private final StudentCourseRepository studentCourseRepository;

    public List<StudentResponse> getStudents(){
        List<Student> students = studentRepository.findAll();
        List<StudentCourse> studentCourses = studentCourseRepository.findAll();
        List<Map<String, Object>> courses = new RestTemplate().getForObject("http://localhost:8112/courses", List.class);
        System.out.println(courses);

        List<StudentResponse> responses = new ArrayList<>();
        for (Student student : students) {
            List<StudentCourse> studentCoursesForStudent = studentCourses.stream()
                    .filter(sc -> sc.getStudentId().equals(student.getId()))
                    .toList();

            StudentResponse studentResponse = new StudentResponse();
            studentResponse.setStudent(student);

            List<Map<String, Object>> studentCoursesData = courses.stream()
                    .filter(o -> studentCoursesForStudent.stream()
                            .anyMatch(sc -> o.get("id").equals(sc.getCourseId())))
                    .toList();

            studentResponse.setCourses(studentCoursesData);
            responses.add(studentResponse);
        }
        return responses;

    }
    public String loadData(){
        Student s1 = new Student(1000L,"Hamza","Elgarai","G133365030","GI5");
        Student s2 = new Student(1001L,"Mohamed","Hamdani","R20369502","GI5");
        Student s3 = new Student(1002L,"Ismail","Kaou","G00325820","GI5");

        studentRepository.saveAllAndFlush(List.of(s1,s2,s3));
        StudentCourse sc1 = new StudentCourse(null,1000L,2000L);
        StudentCourse sc2 = new StudentCourse(null,1000L,2001L);
        StudentCourse sc3 = new StudentCourse(null,1001L,2000L);
        studentCourseRepository.saveAllAndFlush(List.of(sc1,sc2,sc3));
        return "SUCCESS";
    }
}

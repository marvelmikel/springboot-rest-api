package net.javaguide.springbootrestapi.controller;

import net.javaguide.springbootrestapi.bean.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {


   // http://localhost:8080/student
    @GetMapping("student")

    public Student getStudent(){
        Student student = new Student(
                1,
                "Ramesh",
                 "Fadatar"
        );

        return student;
    }

    // http://localhost:8080/list-students

    @GetMapping("list-students")
    public List<Student> getStudents(){
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Rmesh", "Fadaere"));
        students.add(new Student(2, "Rmesh", "Fadaere"));
        students.add(new Student(3, "Rmesh", "Fadaere"));
        students.add(new Student(4, "Rmesh", "Fadaere"));
        return students;

    }
}

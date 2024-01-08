package net.javaguide.springbootrestapi.controller;

import net.javaguide.springbootrestapi.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {


   // http://localhost:8080/student
    @GetMapping("student")

    public Student getStudent(){

        return new Student(
                1,
                "Ramesh",
                 "Fadatar"
        );
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

    // Sprint Boot REST API WITH Path Variable
    // {id} - URI Template variable
    // http://localhost:8080/students/1

    @GetMapping("students/{id}")
    public Student studentPathVariable(@PathVariable("id") int studentId){
        return new Student (studentId, "remesh", "fadhere");
    }

    // Sprint Boot REST API WITH Request Param aka Query parameter
    // http://localhost:8080/students/query?id=1
    @GetMapping("students/query")
    public Student studentRequestVariable(int id){
        return new Student(id, "ramesh", "fatheder");
    }

    // Sprint Boot REST API that handles HTTP POST Request
    // @PostMapping and @requestBody

    @PostMapping("students/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Student createStudent(@RequestBody  Student student){
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return student;
    }

}

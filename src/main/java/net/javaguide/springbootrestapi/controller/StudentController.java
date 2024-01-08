package net.javaguide.springbootrestapi.controller;

import net.javaguide.springbootrestapi.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {


   // http://localhost:8080/student
    @GetMapping("student")

    public ResponseEntity<Student> getStudent(){
        Student student = new Student (
                1,
                "Ramesh",
                 "Fadatar"
        );
       // return new ResponseEntity<>(student, HttpStatus.OK);
        return ResponseEntity.ok().header("customer-header", "ejeh")
                .body(student);
    }

    // http://localhost:8080/list-students

    @GetMapping("list-students")
    public ResponseEntity <List <Student>> getStudents(){
        List<Student>students = new ArrayList<>();
        students.add(new Student(1, "Rmesh", "Fadaere"));
        students.add(new Student(2, "Rmesh", "Fadaere"));
        students.add(new Student(3, "Rmesh", "Fadaere"));
        students.add(new Student(4, "Rmesh", "Fadaere"));
        return ResponseEntity.ok(students);
    }

    // Sprint Boot REST API WITH Path Variable
    // {id} - URI Template variable
    // http://localhost:8080/students/1

    @GetMapping("students/{id}/{first-name}/{last-name}")
    public ResponseEntity<Student> studentPathVariable
            (@PathVariable("id") int studentId,
             @PathVariable("first-name") String firstName,
             @PathVariable("last-name") String lastName){
        Student student = new Student(studentId, firstName, lastName);
        return ResponseEntity.ok(student);
    }


    // Sprint Boot REST API WITH Request Param aka Query parameter
    // http://localhost:8080/students/query?id=1
    @GetMapping("students/query")
    public ResponseEntity <Student> studentRequestVariable(
            @RequestParam int id,
            @RequestParam String firstName,
            @RequestParam String lastName){
       Student student = new Student(id, firstName, lastName);
       return ResponseEntity.ok(student);
    }

    // Sprint Boot REST API that handles HTTP POST Request -creating new resource
    // @PostMapping and @requestBody

    @PostMapping("students/create")
    //@ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity <Student> createStudent(@RequestBody  Student student){
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

    // Sprint Boot REST API that handles HTTP PUT Request -updating existing resource
    // @PutMapping and @requestBody

    @PutMapping("students/{id}/update")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity <Student>
    updateStudent(@RequestBody Student student, @PathVariable("id") int studentId){
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return ResponseEntity.ok(student);

    }

    // Sprint Boot REST API that handles HTTP DELETE Request -delete existing resource
    // @DeleteMapping and @requestBody

    @DeleteMapping("students/{id}/delete")
    public ResponseEntity <String> deleteStudent( @PathVariable("id") int studentId){
        System.out.println(studentId);
        return ResponseEntity.ok("Student Deleted Successfully!");
    }



}

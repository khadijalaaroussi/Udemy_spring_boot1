package com.luv2code.demo.rest;

import com.luv2code.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")

public class StudentRestController {

    private List<Student> theStudents;

    //define @PostConstruct to load student data only once
    @PostConstruct
    public void loadData(){
        theStudents = new ArrayList<Student>();
        theStudents.add(new Student("poornima","patal"));
        theStudents.add(new Student("mario","rossi"));
        theStudents.add(new Student("mary","smith"));
    }
    @GetMapping("/students")
    public List<Student> getStudents() {
        return theStudents;
    }

    // define endpoint or "/students/{studentId}" return student at index

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {

        if((studentId>=theStudents.size())||(studentId<0)){
            throw new StudentNotFoundException("Student id is not found -"+studentId);
        }
        return theStudents.get(studentId);
    }



}

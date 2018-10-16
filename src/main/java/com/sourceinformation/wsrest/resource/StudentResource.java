package com.sourceinformation.wsrest.resource;

import com.sourceinformation.wsrest.model.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/students")
public class StudentResource {

    private Map<Integer, Student> students;

    public StudentResource() {
        students = new HashMap<>();

        Student s1 = new Student(1L, "Evandro", 22);
        Student s2 = new Student(1L, "João", 28);
        Student s3 = new Student(1L, "Maria", 32);

        students.put(1, s1);
        students.put(2, s2);
        students.put(3, s3);
    }

    @GetMapping
    public ResponseEntity<List<Student>> list() {
        return new ResponseEntity<List<Student>>(new ArrayList<Student>(students.values()), HttpStatus.OK);
    }
}

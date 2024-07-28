package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import com.example.demo.entities.Student;
import com.example.demo.service.IStudentService;



@RestController
@RequestMapping("/student")
public class IStudentController {
    @Autowired
    private IStudentService service;

    @GetMapping
    public List<Student> list() {
        return service.listAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> get(@PathVariable Long id) {
    	Student user = service.get(id);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user);
    }

    @PostMapping
    public void add(@RequestBody Student user) {
        service.save(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Student user, @PathVariable Long id) {
    	Student existingUser = service.get(id);
        if (existingUser == null) {
            return ResponseEntity.notFound().build();
        }
        existingUser.setName(user.getName());
        existingUser.setQualification(user.getQualification());
        existingUser.setCertificate(user.getCertificate());
        existingUser.setCollege(user.getCollege());
        existingUser.setCourse(user.getCourse());
        existingUser.setHallTicketNo(user.getHallTicketNo());
        existingUser.setRoll(user.getRoll());
        existingUser.setYear(user.getYear());
        service.save(existingUser);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}

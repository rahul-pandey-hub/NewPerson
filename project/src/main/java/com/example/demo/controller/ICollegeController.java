package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entities.Colleges;
import com.example.demo.service.ICollageServicce;


@RestController
@RequestMapping("/colleges")
public class ICollegeController {
    @Autowired
    private ICollageServicce service;

    @GetMapping
    public List<Colleges> list() {
        return service.listAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Colleges> get(@PathVariable Long id) {
        Colleges college = service.get(id);
        if (college == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(college);
    }

    @PostMapping
    public void add(@RequestBody Colleges college) {
        service.save(college);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Colleges college, @PathVariable Long id) {
        Colleges existingCollege = service.get(id);
        if (existingCollege == null) {
            return ResponseEntity.notFound().build();
        }
        existingCollege.setCollegeAdmin(college.getCollegeAdmin());
        existingCollege.setCollegeName(college.getCollegeName());
        existingCollege.setLocation(college.getLocation());
        service.save(existingCollege);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}

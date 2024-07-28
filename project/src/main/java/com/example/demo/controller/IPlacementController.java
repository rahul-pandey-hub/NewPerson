package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import com.example.demo.entities.Placement;
import com.example.demo.service.IPlacementService;




@RestController
@RequestMapping("/placement")
public class IPlacementController {
    @Autowired
    private IPlacementService service;

    @GetMapping
    public List<Placement> list() {
        return service.listAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Placement> get(@PathVariable Long id) {
    	Placement user = service.get(id);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user);
    }

    @PostMapping
    public void add(@RequestBody Placement user) {
        service.save(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Placement user, @PathVariable Long id) {
    	Placement existingUser = service.get(id);
        if (existingUser == null) {
            return ResponseEntity.notFound().build();
        }
        existingUser.setName(user.getName());
        existingUser.setCollege(user.getCollege());
        existingUser.setQualification(user.getQualification());
        existingUser.setDate(user.getDate());
        existingUser.setYear(user.getYear());
        service.save(existingUser);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}

package com.example.demo.controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entities.Certificate;
import com.example.demo.service.ICertificatService;


@RestController
@RequestMapping("/certificates")
public class ICertifcatController {
    @Autowired
    private ICertificatService service;

    @GetMapping
    public List<Certificate> list() {
        return service.listAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Certificate> get(@PathVariable Long id) {
        Certificate certificate = service.get(id);
        if (certificate == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(certificate);
    }

    @PostMapping
    public void add(@RequestBody Certificate certificate) {
        service.save(certificate);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Certificate certificate, @PathVariable Long id) {
        Certificate existingCertificate = service.get(id);
        if (existingCertificate == null) {
            return ResponseEntity.notFound().build();
        }
        existingCertificate.setYear(certificate.getYear());
        existingCertificate.setCollege(certificate.getCollege());
        service.save(existingCertificate);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}

package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Certificate;
import com.example.demo.repositories.ICertificateRepository;


@Service
public class ICertificatService {

    @Autowired
    private ICertificateRepository certificateRepository;

    public List<Certificate> listAll() {
        return certificateRepository.findAll();
    }

    public Certificate get(Long id) {
        return certificateRepository.findById(id).orElse(null);
    }

    public void save(Certificate certificate) {
        certificateRepository.save(certificate);
    }

    public void delete(Long id) {
        certificateRepository.deleteById(id);
    }
}

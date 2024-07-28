package com.example.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Student;
import com.example.demo.repositories.IStudentRepository;



@Service
public class IStudentService  {
    @Autowired
    private IStudentRepository repository;

   
    public List<Student> listAll() {
        return repository.findAll();
    }

   
    public Student get(Long id) {
        return repository.findById(id).orElse(null);
    }

  
    public void save(Student user) {
        repository.save(user);
    }

   
    public void delete(Long id) {
        repository.deleteById(id);
    }
}

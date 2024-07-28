package com.example.demo.service;
import java.util.List;	
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entities.Colleges;
import com.example.demo.repositories.ICollegeRepository;


@Service
public class ICollageServicce  {
    @Autowired
    private ICollegeRepository repository;

   
    public List<Colleges> listAll() {
        return repository.findAll();
    }

   
    public Colleges get(Long id) {
        return repository.findById(id).orElse(null);
    }

  
    public void save(Colleges college) {
        repository.save(college);
    }

   
    public void delete(Long id) {
        repository.deleteById(id);
    }
}

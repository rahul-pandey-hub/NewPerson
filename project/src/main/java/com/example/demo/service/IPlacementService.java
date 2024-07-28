package com.example.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entities.Placement;
import com.example.demo.repositories.IPlacementRepository;


@Service
public class IPlacementService  {
    @Autowired
    private IPlacementRepository repository;

   
    public List<Placement> listAll() {
        return repository.findAll();
    }

   
    public Placement get(Long id) {
        return repository.findById(id).orElse(null);
    }

  
    public void save(Placement college) {
        repository.save(college);
    }

   
    public void delete(Long id) {
        repository.deleteById(id);
    }
}

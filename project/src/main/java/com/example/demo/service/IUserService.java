package com.example.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.User;
import com.example.demo.repositories.IUserRepository;


@Service
public class IUserService  {
    @Autowired
    private IUserRepository repository;

   
    public List<User> listAll() {
        return repository.findAll();
    }

   
    public User get(Long id) {
        return repository.findById(id).orElse(null);
    }

  
    public void save(User user) {
        repository.save(user);
    }

   
    public void delete(Long id) {
        repository.deleteById(id);
    }
}

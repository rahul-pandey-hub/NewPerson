package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.demo.entities.Admin;
import com.example.demo.repositories.IAdminRepository;


@Service
public class IAdminService {

	@Autowired
    private IAdminRepository adminRepository;

    public List<Admin> listAll() {
        return adminRepository.findAll();
    }

    public Admin get(Integer id) {
        return adminRepository.findById(id).orElse(null);
    }

    public void save(Admin admin) {
        adminRepository.save(admin);
    }

    public void delete(Integer id) {
        adminRepository.deleteById(id);
    }
}

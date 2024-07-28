package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.entities.Admin;

@Repository
public interface IAdminRepository extends JpaRepository<Admin, Integer> {
    // Define any custom query methods if needed
}

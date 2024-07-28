package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Colleges;


@Repository
public interface ICollegeRepository extends JpaRepository<Colleges, Long> {
}

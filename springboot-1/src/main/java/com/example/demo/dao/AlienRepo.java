package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.modal.Alien;

public interface AlienRepo extends JpaRepository<Alien, Integer> {

}

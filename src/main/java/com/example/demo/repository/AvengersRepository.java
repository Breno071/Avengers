package com.example.demo.repository;

import com.example.demo.model.Avenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvengersRepository extends JpaRepository<Avenger, Long> {
}

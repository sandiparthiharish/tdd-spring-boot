package com.harish.repository;

import com.harish.model.Bike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BikeRepository extends JpaRepository<Bike, String> {

    Bike findByName(String name);
}
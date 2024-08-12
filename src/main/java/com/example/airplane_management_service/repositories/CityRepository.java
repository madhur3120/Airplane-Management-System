package com.example.airplane_management_service.repositories;

import com.example.airplane_management_service.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Long> {

}

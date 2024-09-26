package com.example.airplane_management_service.repositories;

import com.example.airplane_management_service.entity.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirportRespository extends JpaRepository<Airport, Long> {
}

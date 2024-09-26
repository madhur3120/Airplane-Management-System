package com.example.airplane_management_service.service.interfaces;
import com.example.airplane_management_service.entity.Airport;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface AirportService {
    public List<Airport> getAirports();
    public ResponseEntity<Airport> getAirport(Long id);
    public ResponseEntity<Airport>createAirport(Airport airport);

    public ResponseEntity<Void>deleteAirport(Long id);
}

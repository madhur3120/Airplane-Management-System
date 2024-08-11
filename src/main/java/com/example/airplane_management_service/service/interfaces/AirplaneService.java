package com.example.airplane_management_service.service.interfaces;

import com.example.airplane_management_service.entity.Airplane;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface AirplaneService {
    public List<Airplane> getAirplanes();
    public ResponseEntity<Airplane> getAirplane(Long id);
    public ResponseEntity<Airplane>createAirplane(Airplane airplane);
    public  ResponseEntity<Airplane>updateAirplane(Long id, Airplane airplane);
    public ResponseEntity<Void>deleteAirplane(Long id);
}

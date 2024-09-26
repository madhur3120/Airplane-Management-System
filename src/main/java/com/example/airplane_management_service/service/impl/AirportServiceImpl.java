package com.example.airplane_management_service.service.impl;

import com.example.airplane_management_service.entity.Airport;
import com.example.airplane_management_service.repositories.AirportRespository;
import com.example.airplane_management_service.service.interfaces.AirportService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AirportServiceImpl implements AirportService {

    AirportRespository airportRespository;
    public AirportServiceImpl(AirportRespository airportRespository){
        this.airportRespository=airportRespository;
    }
    @Override
    public List<Airport> getAirports() {
        return airportRespository.findAll();
    }

    @Override
    public ResponseEntity<Airport> getAirport(Long id) {
        Optional<Airport> airport = airportRespository.findById(id);
        return airport.map(value -> new ResponseEntity<>(value, HttpStatus.FOUND)).orElseGet(()-> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Override
    public ResponseEntity<Airport> createAirport(Airport airport) {
        try{
            Airport savedAirport= airportRespository.save(airport);
            return new ResponseEntity<>(savedAirport, HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @Override
    public ResponseEntity<Void> deleteAirport(Long id) {
        try {
            if (airportRespository.existsById(id)) {
                airportRespository.deleteById(id);
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

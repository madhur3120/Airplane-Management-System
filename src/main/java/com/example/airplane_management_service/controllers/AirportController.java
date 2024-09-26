package com.example.airplane_management_service.controllers;


import com.example.airplane_management_service.entity.Airport;

import com.example.airplane_management_service.service.interfaces.AirportService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/airport")
public class AirportController {
    AirportService airportService;
    public AirportController(AirportService airportService){
        this.airportService=airportService;
    }

    @GetMapping()
    public List<Airport> getAirports(){
        return airportService.getAirports();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Airport> getAirport(@PathVariable Long id){

        return airportService.getAirport(id);
    }

    @PostMapping()
    public ResponseEntity<Airport> createAirport(@RequestBody Airport airport){
        return airportService.createAirport(airport);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAirplane(@PathVariable("id") Long id) {
        return airportService.deleteAirport(id);
    }
}

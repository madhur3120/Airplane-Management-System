package com.example.airplane_management_service.controllers;

import com.example.airplane_management_service.entity.Airplane;
import com.example.airplane_management_service.service.interfaces.AirplaneService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/airplane")
public class AirplaneController {

    AirplaneService airplaneService;
    public AirplaneController(AirplaneService airplaneService){
        this.airplaneService=airplaneService;
    }

    @GetMapping()
    public List<Airplane> getAirplanes(){
        return airplaneService.getAirplanes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Airplane> getAirplane(@PathVariable Long id){

        return airplaneService.getAirplane(id);
    }

   @PostMapping()
    public ResponseEntity<Airplane> createAirplane(@RequestBody Airplane airplane){
        return airplaneService.createAirplane(airplane);
   }

    @PutMapping("/{id}")
    public ResponseEntity<Airplane> updateAirplane(@PathVariable("id") Long id, @RequestBody Airplane airplaneDetails) {
        return airplaneService.updateAirplane(id, airplaneDetails);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAirplane(@PathVariable("id") Long id) {
        return airplaneService.deleteAirplane(id);
    }
}

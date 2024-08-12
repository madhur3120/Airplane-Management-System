package com.example.airplane_management_service.controllers;


import com.example.airplane_management_service.entity.Airplane;
import com.example.airplane_management_service.entity.City;
import com.example.airplane_management_service.service.interfaces.CityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/city")
public class CityController {

    CityService cityService;
    public CityController(CityService cityService){
        this.cityService=cityService;
    }
    @GetMapping()
    public List<City> getCities(){
        return cityService.getCities();
    }

    @GetMapping("/{id}")
    public ResponseEntity<City> getCity(@PathVariable Long id){

        return cityService.getCity(id);
    }

    @PostMapping()
    public ResponseEntity<City> createCity(@RequestBody City city){
        return cityService.createCity(city);
    }

    @PutMapping("/{id}")
    public ResponseEntity<City> updateCity(@PathVariable("id") Long id, @RequestBody City cityDetails) {
        return cityService.updateCity(id, cityDetails);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCity(@PathVariable("id") Long id) {
        return cityService.deleteCity(id);
    }
}

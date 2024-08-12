package com.example.airplane_management_service.service.interfaces;

import com.example.airplane_management_service.entity.City;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CityService {
    public List<City> getCities();
    public ResponseEntity<City> getCity(Long id);
    public ResponseEntity<City>createCity(City city);
    public ResponseEntity<City>updateCity(Long id, City cityDetails);
    public ResponseEntity<Void>deleteCity(Long id);
}

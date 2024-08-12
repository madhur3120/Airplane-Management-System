package com.example.airplane_management_service.service.impl;

import com.example.airplane_management_service.entity.City;
import com.example.airplane_management_service.repositories.CityRepository;
import com.example.airplane_management_service.service.interfaces.CityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CityServiceImpl implements CityService {
    CityRepository cityRepository;
    public CityServiceImpl(CityRepository cityRepository){
        this.cityRepository=cityRepository;
    }
    @Override
    public List<City> getCities() {
        return cityRepository.findAll();
    }

    @Override
    public ResponseEntity<City> getCity(Long id) {
        Optional<City> city=cityRepository.findById(id);
            return city.map(value -> new ResponseEntity<>(value, HttpStatus.FOUND)).orElseGet(()->new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Override
    public ResponseEntity<City> createCity(City city) {
        try{
            City savedCity=cityRepository.save(city);
            return new ResponseEntity<>(savedCity, HttpStatus.CREATED);
        }
        catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<City> updateCity(Long id, City cityDetails) {
        Optional<City> cityData=cityRepository.findById(id);
        if(cityData.isPresent()){
            City city=cityData.get();
            city.setName(cityDetails.getName());
            city.setModifiedAt(LocalDateTime.now());
            City updatedCity=cityRepository.save(city);
            return new ResponseEntity<>(updatedCity, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<Void> deleteCity(Long id) {
        try {
            if (cityRepository.existsById(id)) {
                cityRepository.deleteById(id);
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}

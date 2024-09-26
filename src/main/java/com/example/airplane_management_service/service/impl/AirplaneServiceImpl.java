package com.example.airplane_management_service.service.impl;

import com.example.airplane_management_service.entity.Airplane;
import com.example.airplane_management_service.repositories.AirplaneRepository;
import com.example.airplane_management_service.service.interfaces.AirplaneService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class AirplaneServiceImpl implements AirplaneService {

    AirplaneRepository airplaneRepository;

    public AirplaneServiceImpl(AirplaneRepository airplaneRepository){
        this.airplaneRepository=airplaneRepository;
    }

    @Override
    public List<Airplane> getAirplanes() {
        return airplaneRepository.findAll();
    }

    @Override
    public ResponseEntity<Airplane> getAirplane(Long id) {
        Optional<Airplane> airplane=airplaneRepository.findById(id);
        return airplane.map(value -> new ResponseEntity<>(value, HttpStatus.FOUND)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Override
    public ResponseEntity<Airplane> createAirplane(Airplane airplane) {
        try{
            Airplane savedAirplane = airplaneRepository.save(airplane);
            return new ResponseEntity<>(savedAirplane, HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Airplane> updateAirplane(Long id, Airplane airplaneDetails) {
        Optional<Airplane> airplaneData = airplaneRepository.findById(id);

        if (airplaneData.isPresent()) {
            Airplane airplane = airplaneData.get();

            airplane.setModelNumber(airplaneDetails.getModelNumber());
            airplane.setCapacity(airplaneDetails.getCapacity());
            airplane.setModifiedAt(LocalDateTime.now());

            Airplane updatedAirplane = airplaneRepository.save(airplane);
            return new ResponseEntity<>(updatedAirplane, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<Void> deleteAirplane(Long id) {
        try {
            if (airplaneRepository.existsById(id)) {
                airplaneRepository.deleteById(id);
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

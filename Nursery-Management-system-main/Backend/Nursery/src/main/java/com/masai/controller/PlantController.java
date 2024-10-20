package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.PlantException;
import com.masai.model.Plant;
import com.masai.service.PlantServiceImpl;
import com.masai.service.PlanterServiceImpl;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*")
public class PlantController {

    @Autowired
    private PlantServiceImpl plantService;

    // Method to add a new plant
    @PostMapping("/plants")
    public ResponseEntity<Plant> addNewPlant(@Valid @RequestBody Plant plant) throws PlantException {
        // Call the service to add a new plant
        Plant newPlant = plantService.addPlant(plant);
        // Return the new plant with HTTP status 201 (Created)
        return new ResponseEntity<Plant>(newPlant, HttpStatus.CREATED);
    }

    // Method to update an existing plant by ID
    @PutMapping("/plants/{plantId}")
    public ResponseEntity<Plant> updatePlant(@Valid @PathVariable Integer plantId, @RequestBody Plant plant)
            throws PlantException {
        // Call the service to update an existing plant
        Plant existingPlant = plantService.updatePlant(plantId, plant);
        // Return the updated plant with HTTP status 200 (OK)
        return new ResponseEntity<Plant>(existingPlant, HttpStatus.OK);
    }

    // Method to delete a plant by ID
    @DeleteMapping("/plants/{id}")
    public ResponseEntity<Plant> deletePlant(@PathVariable("id") Integer plantId) throws PlantException {
        // Call the service to delete a plant
        Plant existingPlant = plantService.deletePlant(plantId);
        // Return the deleted plant with HTTP status 200 (OK)
        return new ResponseEntity<Plant>(existingPlant, HttpStatus.OK);
    }

    // Method to get a plant by ID
    @GetMapping("/plants/{plantId}")
    public ResponseEntity<Plant> getPlantById(@PathVariable Integer plantId) throws PlantException {
        // Call the service to view a specific plant by ID
        Plant existingPlant = plantService.viewPlant(plantId);
        // Return the plant with HTTP status 302 (Found)
        return new ResponseEntity<Plant>(existingPlant, HttpStatus.FOUND);
    }

    // Method to find all plants
    @GetMapping("/plants")
    public ResponseEntity<List<Plant>> findAllPlants() throws PlantException {
        // Call the service to view all plants
        List<Plant> plantList = plantService.viewAllPlants();
        // Return the list of plants with HTTP status 302 (Found)
        return new ResponseEntity<List<Plant>>(plantList, HttpStatus.FOUND);
    }

    // Method to find plants by common name
    @GetMapping("/plantByCommonName/{commonName}")
    public ResponseEntity<List<Plant>> findSeedByCommonName(@PathVariable String commonName) throws PlantException {
        // Call the service to view plants by common name
        List<Plant> plantList = plantService.viewPlant(commonName);
        // Return the list of plants with HTTP status 302 (Found)
        return new ResponseEntity<List<Plant>>(plantList, HttpStatus.FOUND);
    }

    // Method to find plants by type of plant
    @GetMapping("/plantsByTypeOfPlant/{typeOfPlant}")
    public ResponseEntity<List<Plant>> findSeedByTypeOfPlant(@PathVariable String typeOfPlant) throws PlantException {
        // Call the service to view plants by type of plant
        List<Plant> plantList = plantService.viewAllPlants(typeOfPlant);
        // Return the list of plants with HTTP status 302 (Found)
        return new ResponseEntity<List<Plant>>(plantList, HttpStatus.FOUND);
    }
}

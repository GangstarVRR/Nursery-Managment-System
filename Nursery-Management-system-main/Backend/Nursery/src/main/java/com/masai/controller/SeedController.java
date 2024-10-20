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

import com.masai.exception.SeedException;
import com.masai.model.Seed;
import com.masai.service.SeedService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*")
public class SeedController {

    @Autowired
    private SeedService seedService;

    // Method to add a new seed
    @PostMapping("/seeds")
    public ResponseEntity<Seed> addNewSeed(@Valid @RequestBody Seed seed) throws SeedException {
        // Call the service to add a new seed
        Seed seed2 = seedService.addSeed(seed);
        // Return the added seed with HTTP status 201 (Created)
        return new ResponseEntity<Seed>(seed2, HttpStatus.CREATED);
    }

    // Method to update an existing seed by ID
    @PutMapping("/seeds/{seedId}")
    public ResponseEntity<Seed> updateSeed(@PathVariable Integer seedId, @RequestBody Seed seed) throws SeedException {
        // Call the service to update an existing seed
        Seed seed2 = seedService.updateSeed(seedId, seed);
        // Return the updated seed with HTTP status 200 (OK)
        return new ResponseEntity<Seed>(seed2, HttpStatus.OK);
    }

    // Method to delete a seed by ID
    @DeleteMapping("/seeds/{seedId}")
    public ResponseEntity<Seed> deleteSeed(@PathVariable Integer seedId) throws SeedException {
        // Call the service to delete a seed
        Seed seed2 = seedService.deleteSeed(seedId);
        // Return the deleted seed with HTTP status 200 (OK)
        return new ResponseEntity<Seed>(seed2, HttpStatus.OK);
    }

    // Method to find a seed by ID
    @GetMapping("/seedsById/{seedId}")
    public ResponseEntity<Seed> findSeedById(@PathVariable Integer seedId) throws SeedException {
        // Call the service to view a specific seed by ID
        Seed seed2 = seedService.viewSeed(seedId);
        // Return the seed with HTTP status 302 (Found)
        return new ResponseEntity<Seed>(seed2, HttpStatus.FOUND);
    }

    // Method to find all seeds
    @GetMapping("/seeds")
    public ResponseEntity<List<Seed>> findAllSeeds() throws SeedException {
        // Call the service to view all seeds
        List<Seed> seedList = seedService.viewAllSeeds();
        // Return the list of seeds with HTTP status 302 (Found)
        return new ResponseEntity<List<Seed>>(seedList, HttpStatus.FOUND);
    }

    // Method to find seeds by common name
    @GetMapping("/seedsByCommonName/{commonName}")
    public ResponseEntity<List<Seed>> findSeedByCommonName(@PathVariable String commonName) throws SeedException {
        // Call the service to view seeds by common name
        List<Seed> seedList = seedService.viewSeed(commonName);
        // Return the list of seeds with HTTP status 302 (Found)
        return new ResponseEntity<List<Seed>>(seedList, HttpStatus.FOUND);
    }

    // Method to find seeds by type of seeds
    @GetMapping("/seedsByTypeOfSeeds/{typeOfSeeds}")
    public ResponseEntity<List<Seed>> findSeedByTypeOfSeeds(@PathVariable String typeOfSeeds) throws SeedException {
        // Call the service to view seeds by type of seeds
        List<Seed> seedList = seedService.viewAllSeeds(typeOfSeeds);
        // Return the list of seeds with HTTP status 302 (Found)
        return new ResponseEntity<List<Seed>>(seedList, HttpStatus.FOUND);
    }
}


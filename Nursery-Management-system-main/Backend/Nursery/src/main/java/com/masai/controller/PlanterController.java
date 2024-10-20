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

import com.masai.exception.PlanterException;
import com.masai.model.Planter;
import com.masai.service.PlanterService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*")
public class PlanterController {

    @Autowired
    private PlanterService planterService;

    // Method to add a new planter
    @PostMapping("/planters")
    public ResponseEntity<Planter> addNewPlanter(@Valid @RequestBody Planter planter) throws PlanterException {
        // Call the service to add a new planter
        Planter savedPlanter = planterService.addPlanter(planter);
        // Return the saved planter with HTTP status 201 (Created)
        return new ResponseEntity<Planter>(savedPlanter, HttpStatus.CREATED);
    }

    // Method to update an existing planter by ID
    @PutMapping("/planters/{planterId}")
    public ResponseEntity<Planter> updatePlanter(@PathVariable Integer planterId, @Valid @RequestBody Planter planter)
            throws PlanterException {
        // Print the planter information to the console
        System.out.println(planter);
        // Call the service to update an existing planter
        Planter updatedPlanter = planterService.updatePlanter(planterId, planter);
        // Return the updated planter with HTTP status 200 (OK)
        return new ResponseEntity<Planter>(updatedPlanter, HttpStatus.OK);
    }

    // Method to delete a planter by ID
    @DeleteMapping("/planters/{planterId}")
    public ResponseEntity<Planter> deletePlanter(@PathVariable Integer planterId) throws PlanterException {
        // Call the service to delete a planter
        Planter deletedPlanter = planterService.deletePlanter(planterId);
        // Return the deleted planter with HTTP status 200 (OK)
        return new ResponseEntity<Planter>(deletedPlanter, HttpStatus.OK);
    }

    // Method to get a planter by ID
    @GetMapping("/planters/{planterId}")
    public ResponseEntity<Planter> getPlanterById(@PathVariable Integer planterId) throws PlanterException {
        // Call the service to view a specific planter by ID
        Planter planter = planterService.viewPlanterById(planterId);
        // Return the planter with HTTP status 302 (Found)
        return new ResponseEntity<Planter>(planter, HttpStatus.FOUND);
    }

    // Method to get all planters
    @GetMapping("/planters")
    public ResponseEntity<List<Planter>> getAllPlanters() throws PlanterException {
        // Call the service to view all planters
        List<Planter> planterList = planterService.viewAllPlanters();
        // Return the list of planters with HTTP status 302 (Found)
        return new ResponseEntity<List<Planter>>(planterList, HttpStatus.FOUND);
    }

    // Method to get planters within a cost range
    @GetMapping("/planters/{startCost}/{endCost}")
    public ResponseEntity<List<Planter>> getAllPlanterByCost(@PathVariable Double startCost,
                                                             @PathVariable Double endCost) throws PlanterException {
        // Call the service to view planters within a cost range
        List<Planter> planterList = planterService.viewPlantersByCost(startCost, endCost);
        // Return the list of planters with HTTP status 302 (Found)
        return new ResponseEntity<List<Planter>>(planterList, HttpStatus.FOUND);
    }

    // Method to get planters by shape
    @GetMapping("/plantersByShape/{planterShape}")
    public ResponseEntity<List<Planter>> getPlanterByShape(@PathVariable String planterShape) throws PlanterException {
        // Call the service to view planters by shape
        List<Planter> planterList = planterService.viewPlantersByShape(planterShape);
        // Return the list of planters with HTTP status 302 (Found)
        return new ResponseEntity<List<Planter>>(planterList, HttpStatus.FOUND);
    }
}

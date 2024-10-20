package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.masai.exception.PlantException;
import com.masai.model.Plant;
import com.masai.repository.Plantrepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PlantServiceimpl implements PlantService{

	@Autowired
	private Plantrepository plantrepo;
	
	@Override
	public Plant addPlant(Plant plant) {
		
		log.info("plant added successfully");
		
		if(plant==null)throw new PlantException("plant details are not valid !!!");
      
		Optional<Plant> newPlant= plantrepo.findById(plant.getPlantId());
		
		if(newPlant.isPresent()) throw new PlantException("This Plant is Already Existed !!!");
		
		plantrepo.save(plant);
		
		return plant;
	}

	@Override
	public Plant updatePlant(Plant plant) {
		log.info("plant updated successfully");
		
		if(plant==null)throw new PlantException("Plant details are not valid !!!");
		
		Optional<Plant> newPlant= plantrepo.findById(plant.getPlantId());
		
		if(!newPlant.isPresent()) throw new PlantException("This Plant is Not Existed !!!");
		
		plantrepo.save(plant);
		
		return plant;
	}

	@Override
	public Plant deletePlant(Integer plantid) {
		
        log.info("Plant Deleted Successfully");
     
		if(plantid==null)throw new PlantException("Plant details are not valid !!");
		
        Optional<Plant> newPlant= plantrepo.findById(plantid);
     
		if(!newPlant.isPresent()) throw new PlantException("This plant does not existed !!!");
		
		Plant plant1= newPlant.get();
		
		plantrepo.delete(plant1);
		
		return plant1;
	}

	@Override
	public Plant viewPlant(int plantId) {
		
		log.info("Plant viewed Successfully");
		
		Optional<Plant> newPlant= plantrepo.findById(plantId);
		
		if(newPlant==null)throw new PlantException("plant details are not valid");
		
		if(!newPlant.isPresent())throw new PlantException("This plant does not existed !!!");
		
		Plant plant=newPlant.get();
		
		return plant;
	}

	@Override
	public Plant viewplant(String commonName) {
		
        log.info("Plant viewed Successfully");
		
		Optional<Plant> newPlant= plantrepo.findByCommonName(commonName);
		
		if(newPlant==null)throw new PlantException("plant details are not valid");
		
		if(!newPlant.isPresent())throw new PlantException("This plant does not existed !!!");
		
		Plant plant=newPlant.get();
		
		return plant;
	}

	@Override
	public List<Plant> viewAllPlants() {
		
        log.info("Plants viewed Successfully");
        
        Pageable p= PageRequest.of(0, 5,Sort.by("plantId").ascending());
		
		Page<Plant> Plants= plantrepo.findAll(p);
		
		if(Plants.isEmpty())throw new PlantException("No Plant Found !!!");
		
		return Plants.toList();
	}

	@Override
	public List<Plant> viewAllPlants(String typeOfplant) {
		
        log.info("Plants viewed Successfully");
        
        Pageable p= PageRequest.of(0, 5,Sort.by("typeOfPlant").ascending());
		
		Page<Plant> Plants= plantrepo.findAll(p);
		
		if(Plants.isEmpty())throw new PlantException("No Plant Found !!!");
		
		return Plants.toList();
	}

}

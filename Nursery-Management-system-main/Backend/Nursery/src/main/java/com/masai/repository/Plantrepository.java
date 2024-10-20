package com.masai.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.masai.model.Plant;

public interface Plantrepository extends JpaRepository<Plant,Integer>,PagingAndSortingRepository<Plant,Integer>{

	@Query("select p from Plant p where p.commonName=?1")
	public List<Plant> getByCommonName(String commonName);
	
	
	@Query("select p from Plant p where p.typeOfPlant=?1")
	public List<Plant> getByTypeOfPlant(String typeOfPlant);
}

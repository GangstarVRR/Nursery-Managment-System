package com.masai.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.masai.model.Seed;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;



@Repository
public interface SeedsRepository extends JpaRepository<Seed, Integer>{
	
	@Query("select s from Seed s where s.commonName=?1")
	public List<Seed> getByCommonName(String commonName);
	
	
	@Query("select s from Seed s where s.typeOfSeeds=?1")
	public List<Seed> getByTypeOfSeeds(String typeOfSeeds);

}

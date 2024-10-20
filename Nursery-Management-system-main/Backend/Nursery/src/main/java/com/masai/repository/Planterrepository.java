package com.masai.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.exception.PlanterException;
import com.masai.model.Planter;

@Repository
public interface Planterrepository extends JpaRepository<Planter, Integer>{

	public List<Planter> findByPlanterShape(String planterShape) throws PlanterException;
	
	public List<Planter> findByPlanterCostBetween(Double startCost, Double endCost) throws PlanterException;
	
}

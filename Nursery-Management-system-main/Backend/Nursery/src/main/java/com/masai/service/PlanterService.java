package com.masai.service;

import java.util.List;

import com.masai.exception.PlanterException;
import com.masai.model.Planter;

public interface PlanterService {

	public Planter addPlanter(Planter planter) throws PlanterException;

	public Planter updatePlanter(Integer planterId,Planter planter) throws PlanterException;

	public Planter deletePlanter(Integer planterId) throws PlanterException;

	public Planter viewPlanterById(Integer planterId) throws PlanterException;

	public List<Planter> viewPlantersByShape(String planterShape) throws PlanterException;

	public List<Planter> viewAllPlanters() throws PlanterException;

	public List<Planter> viewPlantersByCost(Double minCost, Double maxCost) throws PlanterException;
}

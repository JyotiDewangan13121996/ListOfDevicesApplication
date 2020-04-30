package com.app.dao;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.pojos.Manufacturer;



@Repository
public class ManufacturerDaoImplementation implements IManufacturerDao
{

	private List<Manufacturer> manufacturerList =  new ArrayList<Manufacturer>(Arrays.asList(
			
			new Manufacturer(1, "Apple" , "Bangalore" , "01-05-2018") ,
			new Manufacturer(2, "Samsung" , "Pune" , "11-02-2020") ,
			new Manufacturer(3, "LG" , "Delhi" , "20-05-2019") 
			
			)) ;
	
	// To display the manufacturer details.
	
	@Override
	public Manufacturer getManufacturerDetails(int manufacturerId) 
	{
		return manufacturerList.get(manufacturerId);
	}

	
	// To update the manufacturer details. 
	
	@Override
	public Manufacturer updateManufacturerDetails(Manufacturer updatedManufacturer)
	{
	    Manufacturer manufacturerToBeUpdated = getManufacturerDetails(updatedManufacturer.getManufactureId());
	    
	    manufacturerToBeUpdated.setManufacturerName(updatedManufacturer.getManufacturerName());
	    manufacturerToBeUpdated.setLocationOfManufacturing(updatedManufacturer.getLocationOfManufacturing());
	    manufacturerToBeUpdated.setDateOfManufacturing(updatedManufacturer.getDateOfManufacturing());
	   
		
		return manufacturerToBeUpdated;
	}

}

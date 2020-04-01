package com.app.serviceTester;

import static org.junit.Assert.assertNotNull;

import org.springframework.beans.factory.annotation.Autowired;

import com.app.pojos.Manufacturer;
import com.app.service.IManufacturerService;

public class ManufacturerServiceTester 
{
  
	@Autowired
	private IManufacturerService manufacturerServiceTester ;
	
	
	// To test the getManufacturerDetails() method by manufacturer service layer . 
	
	public void testGetManufacturerDetails(int manufacturerId)
	{
		assertNotNull(manufacturerServiceTester.getManufacturerDetails(manufacturerId));
		
	}
	
	
	// To test the updateManufacturerDetails() method by manufacturer service layer . 
	
	public void testUpdateManufacturerDetails(Manufacturer updatedManufacturer)
	{
		assertNotNull(manufacturerServiceTester.updateManufacturerDetails(updatedManufacturer));
	}
	
	
}

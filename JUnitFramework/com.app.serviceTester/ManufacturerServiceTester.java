package com.app.serviceTester;

import static org.junit.Assert.assertNotNull;

import java.util.Scanner;

import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;

import com.app.pojos.Manufacturer;
import com.app.service.IManufacturerService;

public class ManufacturerServiceTester 
{
  
	@Autowired
	private IManufacturerService manufacturerServiceTester;

	
	private Integer manufacturerIdToBeTested ;
	
	
	@Before
	public void initialize()
	{
		
		Scanner sc = new Scanner(System.in) ;

		System.out.println("Enter the manufacturer id which is to be tested :");
		this.manufacturerIdToBeTested = sc.nextInt() ;
		
	}
	
	
	// To test the getManufacturerDetails() method by manufacturer service layer . 
	
	public void testGetManufacturerDetails(int manufacturerId)
	{
		manufacturerId =this. manufacturerIdToBeTested ;
		
		assertNotNull(manufacturerServiceTester.getManufacturerDetails(manufacturerId));
		
	}
	
	
	// To test the updateManufacturerDetails() method by manufacturer service layer . 
	
	public void testUpdateManufacturerDetails(Manufacturer updatedManufacturer)
	{
		updatedManufacturer = manufacturerServiceTester.getManufacturerDetails(this.manufacturerIdToBeTested);
		
		assertNotNull(manufacturerServiceTester.updateManufacturerDetails(updatedManufacturer));
	}
	
	
}

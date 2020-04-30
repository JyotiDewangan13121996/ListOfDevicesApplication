package com.app.serviceTester;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import com.app.dao.ManufacturerDaoImplementation;
import com.app.pojos.Manufacturer;
import com.app.service.IManufacturerService;
import com.app.service.ManufacturerServiceImplementation;


@RunWith(SpringRunner.class)
public class ManufacturerServiceTester 
{
 
	@InjectMocks
	private ManufacturerServiceImplementation manufacturerServiceTester ;

	@Mock
	private ManufacturerDaoImplementation manufacturerdao ;
	
	private Integer manufacturerIdToBeTested =1 ;
	
	
	
	// To test the getManufacturerDetails() method by manufacturer service layer . 
	@Test
	public void testGetManufacturerDetails()
	{
		
		Manufacturer manufacturer= new Manufacturer();
		manufacturer.setLocationOfManufacturing("Pune");
		manufacturer.setManufactureId(1);
		manufacturer.setManufacturerName("Samsung");
		
		Mockito.when(manufacturerdao.getManufacturerDetails(1) ).thenReturn(manufacturer);
		
		assertThat(manufacturerServiceTester.getManufacturerDetails(1)).isEqualTo(manufacturer);
		
		//assertNotNull(manufacturerServiceTester.getManufacturerDetails(this.manufacturerIdToBeTested));
		
	}
	
	
	// To test the updateManufacturerDetails() method by manufacturer service layer . 
	@Test
	public void testUpdateManufacturerDetails()
	{
		Manufacturer manufacturer= new Manufacturer();
		manufacturer.setLocationOfManufacturing("Pune");
		manufacturer.setManufactureId(1);
		manufacturer.setManufacturerName("Samsung");
		
		Mockito.when(manufacturerdao.updateManufacturerDetails(manufacturer)).thenReturn(manufacturer);
		
		assertThat(manufacturerServiceTester.updateManufacturerDetails(manufacturer)).isEqualTo(manufacturer);
		
		// Manufacturer updatedManufacturer = manufacturerServiceTester.getManufacturerDetails(this.manufacturerIdToBeTested);
		
		//assertNotNull(manufacturerServiceTester.updateManufacturerDetails(updatedManufacturer));
	}
	
	
}

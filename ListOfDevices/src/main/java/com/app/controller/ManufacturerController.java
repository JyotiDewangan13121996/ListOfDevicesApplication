package com.app.controller;

import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Manufacturer;
import com.app.service.IManufacturerService;

@RestController
@CrossOrigin
@RequestMapping("/manufacturer")

public class ManufacturerController
{
	
	@Autowired
	private IManufacturerService manufacturerService ;
	
	
	@PostConstruct
	public void init() {
		System.out.println("in init " +  manufacturerService);
	}
	
	
	//  REST request handling method to get manufacturer details  by id .
	
	@GetMapping("/getManufacturerDetails/{manufactureId}")
	public ResponseEntity<?> getManufacturerDetails(@PathVariable int manufactureId)
	{
		System.out.println(" Get Manufacturer Details having manufacturer Id : " + manufactureId );
	    
		Manufacturer manufacturerDetails = manufacturerService.getManufacturerDetails(manufactureId);
	
		if(manufacturerDetails == null )
		     return new ResponseEntity<Void>(HttpStatus.NOT_FOUND) ;
		
		return new ResponseEntity<Manufacturer> (manufacturerDetails , HttpStatus.OK) ;
	
	}
	
	
   //  REST request handling method to update the manufacturer details .
	
	@PutMapping("/updateManufacturerDetails/{manufactureId}")
	
	public ResponseEntity<?> updateManufacturerDetails(@RequestParam String manufacturerName , @RequestParam String locationOfManufacturing,
		                                @RequestParam String dateOfManufacturing , @PathVariable int manufactureId)
	{
		
		System.out.println(" Update the manufacturer details  having manufacturer Id: " + manufactureId  );
		
		Manufacturer manufacturerDetails =  manufacturerService.getManufacturerDetails(manufactureId) ;
		
		if(manufacturerDetails == null )
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND) ;
		
		manufacturerDetails.setManufacturerName(manufacturerName);
		manufacturerDetails.setLocationOfManufacturing(locationOfManufacturing);
		manufacturerDetails.setDateOfManufacturing(dateOfManufacturing);
		
		
		try 
		{
			return new ResponseEntity<Manufacturer>( manufacturerService.updateManufacturerDetails(manufacturerDetails) , HttpStatus.OK);
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
		
		
	}
	 
	

}

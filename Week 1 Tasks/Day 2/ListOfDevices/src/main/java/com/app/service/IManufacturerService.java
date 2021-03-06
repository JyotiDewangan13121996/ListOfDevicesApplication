package com.app.service;

import com.app.pojos.Manufacturer;

public interface IManufacturerService 
{
 
	// to get the manufacturer details 
	Manufacturer getManufacturerDetails(int manufacturerId);
	
	
	// to update the manufacturer details .
	Manufacturer updateManufacturerDetails(Manufacturer updatedManufacturer) ;
	
	
}

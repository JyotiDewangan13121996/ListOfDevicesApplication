package com.app.dao;

import com.app.pojos.Manufacturer;

public interface IManufacturerDao 
{
   

	// to get the manufacturer details 
	Manufacturer getManufacturerDetails(int manufacturerId);
	
	
	// to update the manufacturer details .
	Manufacturer updateManufacturerDetails(Manufacturer updatedManufacturer) ;
	
}

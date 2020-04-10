package com.app.service;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.app.dao.IManufacturerDao;
import com.app.pojos.Manufacturer;


@Service

public class ManufacturerServiceImplementation implements IManufacturerService
{

	@Autowired
	private IManufacturerDao manufacturerDao ;
	
	
	// Overridden method for getting the manufacturing details of the device in service layer.
	
	@Override
	public Manufacturer getManufacturerDetails(int manufacturerId)
	{
		return manufacturerDao.getManufacturerDetails(manufacturerId);
	}

	
	// Overridden method for updating the manufacturing details of the device in service layer.
	@Override
	public Manufacturer updateManufacturerDetails(Manufacturer updatedManufacturer)
	{
		return manufacturerDao.updateManufacturerDetails(updatedManufacturer);
	}

}

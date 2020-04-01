package com.app.dao;

import javax.persistence.*;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.app.pojos.Manufacturer;


@Repository
public class ManufacturerDaoImplementation implements IManufacturerDao
{

	
	@PersistenceContext
	private EntityManager entityManager;
	
	
	// To display the manufacturer details.
	
	@Override
	public Manufacturer getManufacturerDetails(int manufacturerId) 
	{
		return entityManager.unwrap(Session.class).get(Manufacturer.class, manufacturerId);
	}

	
	// To update the manufacturer details. 
	
	@Override
	public Manufacturer updateManufacturerDetails(Manufacturer updatedManufacturer)
	{
	
		entityManager.unwrap(Session.class).update(updatedManufacturer);
		return updatedManufacturer;
	}

}

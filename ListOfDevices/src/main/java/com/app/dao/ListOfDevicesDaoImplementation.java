package com.app.dao;

import java.util.List;



import com.app.pojos.Device;
import com.app.pojos.ListOfDevices;

import javax.persistence.*;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;


@Repository
public class ListOfDevicesDaoImplementation implements IListOfDevicesDao
{

	@PersistenceContext
	private EntityManager entityManager ;
	
	// To get the list of the devices .
	
	@Override
	public List<Device> getListOfDevices() 
	{
		String jpql = " select device from Device device" ;
		
		return entityManager.unwrap(Session.class).createQuery(jpql ,Device.class).getResultList() ;
	}
	
	
	// To add a new device in the list.

	@Override
	public Device addNewDevice(Device newDevice)
	{
		 entityManager.unwrap(Session.class).persist(newDevice);
		 return newDevice ;
	}

	
	// To remove a device .
	
	@Override
	public void removeDevice(Device deviceToBeRemoved)
	{
		
		entityManager.unwrap(Session.class).delete(deviceToBeRemoved);
	}

	
	// To get the details of a device by its device id.
	
	@Override
	public Device getDeviceById(Integer deviceId)
	{
	   return entityManager.unwrap(Session.class).get(Device.class, deviceId);
	}

}

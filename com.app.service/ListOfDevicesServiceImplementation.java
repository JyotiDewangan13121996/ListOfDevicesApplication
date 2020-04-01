package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IListOfDevicesDao;
import com.app.pojos.Device;


@Service
@Transactional
public class ListOfDevicesServiceImplementation  implements IListOfDevicesService
{
	
	@Autowired
	private IListOfDevicesDao listDao ;

	
	// Overridden method for getting the list of the devices in service layer.
	
	@Override
	public List<Device> getListOfDevices() 
	{
		return listDao.getListOfDevices();
	}

	
	// Overridden method for adding a new device in the list of devices in service layer.
	
	@Override
	public Device addNewDevice(Device newDevice) 
	{
		return listDao.addNewDevice(newDevice);
	}

	
	// Overridden method for removing a device in the list of devices in service layer.
	
	@Override
	public void removeDevice(Device deviceToBeRemoved) 
	{
		 listDao.removeDevice(deviceToBeRemoved);
	}

	
	// Overridden method for getting the details of the device by its device id in service layer.
	@Override
	public Device getDeviceById(  Integer deviceId  ) 
	{
		return listDao.getDeviceById(deviceId);
	}

}
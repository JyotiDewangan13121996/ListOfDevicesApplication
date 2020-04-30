package com.app.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.app.dao.IDeviceDao;
import com.app.pojos.Device;


@Service
public class DeviceServiceImplementation implements IDeviceService
{
	@Autowired
	private IDeviceDao deviceDao ;

	
	// Overridden method for power button of a device in service layer.
	@Override
	public boolean powerButton(Device device)
	{
		return deviceDao.powerButton(device) ;
	}

	
	// Overridden method for getting on of status of a device in service layer.
	
	@Override
	public boolean getStatusOfDevice(Device device)
	{
		return deviceDao.getStatusOfDevice(device);
	}

	
	// Overridden method for getting the details of the device in service layer.
	
	@Override
	public Device getDetailsOfDevice(int deviceId) 
	{
		return deviceDao.getDetailsOfDevice(deviceId);
	}

	
	// Overridden method for resetting the device in power off mode in service layer.
	
	@Override
	public boolean resetDevice(Device device)
	{
		return deviceDao.resetDevice(device);
	}

	
	// Overridden method for updating the details of the device in service layer.
	
	@Override
	public Device updateDeviceDetails(Device updatedDevice) 
	{
		return deviceDao.updateDeviceDetails(updatedDevice);
	}
	
	
	@Override
	public List<Device> getListOfDevices() 
	{
		return deviceDao.getListOfDevices();
	}

	
	// Overridden method for adding a new device in the list of devices in service layer.
	
	@Override
	public Device addNewDevice(Device newDevice) 
	{
		return deviceDao.addNewDevice(newDevice);
	}

	
	// Overridden method for removing a device in the list of devices in service layer.
	
	@Override
	public void removeDevice(Device deviceToBeRemoved) 
	{
		deviceDao.removeDevice(deviceToBeRemoved);
	}

	
	// Overridden method for getting the details of the device by its device id in service layer.
	@Override
	public Device getDeviceById(  Integer deviceId  ) 
	{
		return deviceDao.getDeviceById(deviceId);
	}

	
	

}

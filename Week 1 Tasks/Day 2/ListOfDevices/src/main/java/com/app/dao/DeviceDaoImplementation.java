package com.app.dao;

import com.app.pojos.Device;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import org.springframework.stereotype.Repository;


@Repository
public class DeviceDaoImplementation implements IDeviceDao
{
	
	private  List<Device> deviceList = new ArrayList<Device> (Arrays.asList(
			
			new Device("Electronic Device", 1, "Fit Gear", "Smart Watch" , "SW1234", 2515, "Fit Gear", "Keeps You Fit", false),
			new Device("Electronic Device", 2, "LG Washing Machine", "Smart Washing Machine" , "MN1544", 4567, "Washing Machine", "Keeps Your Cloth Clean", false),
			new Device("Electronic Device", 3, "Samsung J12", "Smart Phone" , "AW1434", 2515, "Smart Phone", "Smart Phone", false)
			
			
			)) ;
	
 
	// To switch on or switch off the power button of a device.

	@Override
	public boolean powerButton(Device device) 
	{
		if(device.isDeviceStatus())   // if device is powered on then switch it off
			return false ;
		else                        // if device is powered off then switch it on
			return true ;
	}

	
	// To get the status of the device .
	
	@Override
	public boolean getStatusOfDevice(Device device) 
	{
		return device.isDeviceStatus();
	}

	
	
	// To get the details of a device.
	
	@Override
	public Device getDetailsOfDevice(int deviceId) 
	{
		return deviceList.get(deviceId);
	}

	
	// To reset the device into switch off mode.
	
	@Override
	public boolean resetDevice( Device device ) 
	{
		boolean status = false;
		
		if( device.isDeviceStatus() )
			status =false ;
		
		return status;
	}

	
	
	// To update the details of a device.
	
	@Override
	public Device updateDeviceDetails(Device updatedDevice)
	{
		
		Device deviceToBeUpdated = deviceList.get(updatedDevice.getDeviceId()) ;
		
		deviceToBeUpdated.setCategory(updatedDevice.getCategory());
		deviceToBeUpdated.setDeviceName(updatedDevice.getDeviceName());
		deviceToBeUpdated.setDeviceStatus(updatedDevice.isDeviceStatus());
		deviceToBeUpdated.setDeviceType(updatedDevice.getDeviceType());
		deviceToBeUpdated.setModelDescription(updatedDevice.getModelDescription());
		deviceToBeUpdated.setModelName(updatedDevice.getModelName());
		deviceToBeUpdated.setModelNo(updatedDevice.getModelNo());
		deviceToBeUpdated.setProductDescription(updatedDevice.getProductDescription());
		
		return deviceToBeUpdated;
	}
	
	
	@Override
	public List<Device> getListOfDevices() 
	{
		
		return deviceList;
	}
	
	
	// To add a new device in the list.

	@Override
	public Device addNewDevice(Device newDevice)
	{
		 deviceList.add(newDevice);
		 return newDevice ;
	}

	
	// To remove a device .
	
	@Override
	public void removeDevice(Device deviceToBeRemoved)
	{
		deviceList.remove(deviceToBeRemoved);
		
	}

	
	// To get the details of a device by its device id.
	
	@Override
	public Device getDeviceById(Integer deviceId)
	{
	  return deviceList.get(deviceId);
	}


}

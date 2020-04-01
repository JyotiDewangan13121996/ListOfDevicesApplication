package com.app.serviceTester;

import static org.junit.Assert.assertNotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.pojos.Device;
import com.app.service.IListOfDevicesService;


public class ListOfDevicesServiceTester 
{

	@Autowired
	private IListOfDevicesService listOfDevicesService ;
	
	
	// Tester to check the getListOfDevices() service method .
	
	public void testGetListOfDevices() 
	{
		
	   	assertNotNull(listOfDevicesService.getListOfDevices());
	}
	
	
	
	// Tester to check addNewDevice() service method.
	
	public void testAddNewDevice(Device newDevice)
	{
		assertNotNull(listOfDevicesService.addNewDevice(newDevice));
	}
	
	
	// Tester to check getDeviceById() service method .
	
	public void testGetDeviceById(int deviceId) 
	{
	  	assertNotNull(listOfDevicesService.getDeviceById(deviceId));
	}

	
	
	
	
}

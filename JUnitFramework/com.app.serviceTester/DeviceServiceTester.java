package com.app.serviceTester;

import static org.junit.Assert.assertNotNull;

import java.util.Scanner;

import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.pojos.Device;
import com.app.service.IListOfDevicesService;


public class ListOfDevicesServiceTester 
{

	@Autowired
	private IListOfDevicesService listOfDevicesService ;
	
	private Integer deviceIdToBeTested ;
	
	
	@Before
	public void initialize()
	{
		
		Scanner sc = new Scanner(System.in) ;

		System.out.println("Enter the device id which is to be tested :");
		this.deviceIdToBeTested = sc.nextInt() ;
		
	}
	
	
	// Tester to check the getListOfDevices() service method .
	
	public void testGetListOfDevices() 
	{
		
	   	assertNotNull(listOfDevicesService.getListOfDevices());
	}
	
	
	
	// Tester to check addNewDevice() service method.
	
	public void testAddNewDevice(Device newDevice)
	{
		newDevice = listOfDevicesService.getDeviceById(this.deviceIdToBeTested);
		
		assertNotNull(listOfDevicesService.addNewDevice(newDevice));
	}
	
	
	// Tester to check getDeviceById() service method .
	
	public void testGetDeviceById(int deviceId) 
	{
		deviceId = this.deviceIdToBeTested ;
		
	  	assertNotNull(listOfDevicesService.getDeviceById(deviceId));
	}

	
	
	
	
}

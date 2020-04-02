package com.app.serviceTester;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.Scanner;

import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;

import com.app.pojos.Device;
import com.app.service.IDeviceService;

public class DeviceServiceTester 
{

	@Autowired
	private IDeviceService deviceServiceTester ;
	
	
	private Integer deviceIdToBeTested ;
	
	
	@Before
	public void initialize()
	{
		
		Scanner sc = new Scanner(System.in) ;

		System.out.println("Enter the device id which is to be tested :");
		this.deviceIdToBeTested = sc.nextInt() ;
		
	}
	
	
	
	
	// To test powerButton() method of the device service layer . 
	
	public void testPowerButton(Device device )
	{
		device = deviceServiceTester.getDetailsOfDevice(this.deviceIdToBeTested);
		
		if(device.isDeviceStatus())
			assertTrue(deviceServiceTester.powerButton(device));
		
		else
			assertFalse(deviceServiceTester.powerButton(device));
	}
	
	
	
	// To test getStatusOfDevice() method of the device service layer . 
	
	public void testGetStatusOfDevice(Device device) 
	{
		
		device = deviceServiceTester.getDetailsOfDevice(this.deviceIdToBeTested);
		
		
		if(device.isDeviceStatus())
			assertTrue(deviceServiceTester.getStatusOfDevice(device));
		
		else
			assertFalse(deviceServiceTester.getStatusOfDevice(device));
		
	}
	
	
	
	// To test getDetailsOfDevice() method of the device service layer . 
	
	public void testGetDetailsOfDevice(int deviceId)
	{
		deviceId= this.deviceIdToBeTested;
		
		assertNotNull(deviceServiceTester.getDetailsOfDevice(deviceId));
		
	}
	
	
	
	// To test resetDevice() method of the device service layer .
	
	public void testResetDevice( Device device )
	{
		device = deviceServiceTester.getDetailsOfDevice(this.deviceIdToBeTested);
		
		assertFalse(deviceServiceTester.resetDevice(device));
		
	}
	
	
	// To test updateDeviceDetails() method of the device service layer .
	
	public void testUpdateDeviceDetails( Device updatedDevice ) 
	{
		updatedDevice = deviceServiceTester.getDetailsOfDevice(this.deviceIdToBeTested);
		
	    assertNotNull(deviceServiceTester.updateDeviceDetails(updatedDevice));
		
	}
	
	
}

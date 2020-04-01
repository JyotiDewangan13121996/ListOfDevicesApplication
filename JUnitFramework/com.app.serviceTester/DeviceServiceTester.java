package com.app.serviceTester;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.springframework.beans.factory.annotation.Autowired;

import com.app.pojos.Device;
import com.app.service.IDeviceService;

public class DeviceServiceTester 
{

	@Autowired
	private IDeviceService deviceServiceTester ;
	
	
	
	// To test powerButton() method of the device service layer . 
	
	public void testPowerButton(Device device )
	{
		if(device.isDeviceStatus())
			assertTrue(deviceServiceTester.powerButton(device));
		
		else
			assertFalse(deviceServiceTester.powerButton(device));
	}
	
	
	
	// To test getStatusOfDevice() method of the device service layer . 
	
	public void testGetStatusOfDevice(Device device) 
	{
		
		if(device.isDeviceStatus())
			assertTrue(deviceServiceTester.getStatusOfDevice(device));
		
		else
			assertFalse(deviceServiceTester.getStatusOfDevice(device));
		
	}
	
	
	
	// To test getDetailsOfDevice() method of the device service layer . 
	
	public void testGetDetailsOfDevice(int deviceId)
	{
		assertNotNull(deviceServiceTester.getDetailsOfDevice(deviceId));
		
	}
	
	
	
	// To test resetDevice() method of the device service layer .
	
	public void testResetDevice( Device device )
	{
		assertFalse(deviceServiceTester.resetDevice(device));
		
	}
	
	
	// To test updateDeviceDetails() method of the device service layer .
	
	public void testUpdateDeviceDetails( Device updatedDevice ) 
	{
	    assertNotNull(deviceServiceTester.updateDeviceDetails(updatedDevice));
		
	}
	
	
}

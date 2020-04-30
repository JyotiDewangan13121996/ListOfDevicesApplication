package com.app.serviceTester;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import com.app.dao.DeviceDaoImplementation;
import com.app.pojos.Device;
import com.app.service.DeviceServiceImplementation;
import com.app.service.IDeviceService;

@RunWith(SpringRunner.class)
public class DeviceServiceTester 
{

	@InjectMocks
	private DeviceServiceImplementation deviceServiceTester ;
	
	@Mock
	private DeviceDaoImplementation deviceDao;
	
	
	//private Integer deviceIdToBeTested =1 ;
	
	
	
	// To test powerButton() method of the device service layer . 
	@Test
	public void testPowerButton( )
	{
		//Device device = deviceServiceTester.getDetailsOfDevice(this.deviceIdToBeTested);
		
		Device device = new Device("Samsung J2", "Electronics", "BR1234", 1234," version 12.5 ", "Smart Phone", false) ;
		
		Mockito.when(deviceDao.powerButton(device)).thenReturn(device.isDeviceStatus());
		
		assertThat(deviceServiceTester.powerButton(device)).isEqualTo(device.isDeviceStatus());
		
	}
	
	
	
	// To test getStatusOfDevice() method of the device service layer . 
	@Test
	public void testGetStatusOfDevice() 
	{
		
	//	Device device = deviceServiceTester.getDetailsOfDevice(this.deviceIdToBeTested);
		 
        Device device = new Device("Samsung J2", "Electronics", "BR1234", 1234," version 12.5 ", "Smart Phone", false) ;
		
		Mockito.when(deviceDao.getStatusOfDevice(device)).thenReturn(device.isDeviceStatus());
		
		assertThat(deviceServiceTester.getStatusOfDevice(device)).isEqualTo(device.isDeviceStatus());
		
		
	}
	
	
	
	// To test getDetailsOfDevice() method of the device service layer . 
	@Test
	public void testGetDetailsOfDevice()
	{
		int deviceId=1 ;
		
        Device device = new Device("Samsung J2", "Electronics", "BR1234", 1234," version 12.5 ", "Smart Phone", false) ;
		
		Mockito.when(deviceDao.getDetailsOfDevice(deviceId)).thenReturn(device);
		
		assertThat(deviceServiceTester.getDetailsOfDevice(deviceId)).isEqualTo(device);
		
		
		//assertNotNull(deviceServiceTester.getDetailsOfDevice(this.deviceIdToBeTested));
		
	}
	
	
	
	// To test resetDevice() method of the device service layer .
	@Test
	public void testResetDevice( )
	{
        Device device = new Device("Samsung J2", "Electronics", "BR1234", 1234," version 12.5 ", "Smart Phone", false) ;
		
		Mockito.when(deviceDao.resetDevice(device)).thenReturn(device.isDeviceStatus());
		
		assertThat(deviceServiceTester.resetDevice(device)).isEqualTo(device.isDeviceStatus());
		
	}
	
	
	// To test updateDeviceDetails() method of the device service layer .
	@Test
	public void testUpdateDeviceDetails( ) 
	{
        Device device = new Device("Samsung J2", "Electronics", "BR1234", 1234," version 12.5 ", "Smart Phone", false) ;
		
		Mockito.when(deviceDao.updateDeviceDetails(device)).thenReturn(device);
		
		assertThat(deviceServiceTester.updateDeviceDetails(device)).isEqualTo(device);
		
	}
	
	
}

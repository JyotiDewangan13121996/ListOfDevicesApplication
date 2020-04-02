package com.app.serviceTester;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.controller.ListOfDevicesController;
import com.app.dao.ListOfDevicesDaoImplementation;
import com.app.pojos.Device;
import com.app.pojos.ListOfDevices;
import com.app.service.IListOfDevicesService;
import com.app.service.ListOfDevicesServiceImplementation;

@RunWith(SpringRunner.class)
public class ListOfDevicesServiceTester 
{
	
    @InjectMocks
	private ListOfDevicesServiceImplementation listOfDevicesService  ;
    
    @Mock
    private ListOfDevicesDaoImplementation listOfDevicesDao ;
	
	//private Integer deviceIdToBeTested =1;
	
	
	
	// Tester to check the getListOfDevices() service method .
	@Test
	public void testGetListOfDevices() 
	{
		
		List<Device> listOfDevices = new ArrayList<>() ;
	   	
		 Device device1 = new Device("Samsung J2", "Electronics", "BR1234", 1234," version 12.5 ", "Smart Phone", false) ;
		 
		 Device device2 = new Device("Samsung T2", "Electronics", "TO1234", 5784," version 5.5 ", "Smart TV", false) ;
		 
		 listOfDevices.add(device1);
		 listOfDevices.add(device2);
		 
		 ListOfDevices deviceList = new ListOfDevices();
		
		 deviceList.setDevices(listOfDevices);
		 
		 Mockito.when(listOfDevicesDao.getListOfDevices()).thenReturn(listOfDevices);
		 
		// assertEquals(2, listOfDevicesService.getListOfDevices().size());
		 
		 assertThat(listOfDevicesService.getListOfDevices().size()).isEqualTo(2);
		
		 
	  //  assertNotNull(listOfDevicesService.getListOfDevices());
	}
	
	
	
	// Tester to check addNewDevice() service method.
	@Test
	public void testAddNewDevice()
	{
		
		 Device device1 = new Device("Samsung J2", "Electronics", "BR1234", 1234," version 12.5 ", "Smart Phone", false) ;
		
		 Mockito.when(listOfDevicesDao.addNewDevice(device1)).thenReturn(device1);
		 
		 assertThat(listOfDevicesService.addNewDevice(device1)).isEqualTo(device1);
		 
		/*
		Device newDevice = listOfDevicesService.getDeviceById(deviceIdToBeTested);
		
		
		assertNotNull(listOfDevicesService.addNewDevice(newDevice));
		*/
	}
	
	
	// Tester to check getDeviceById() service method .
	@Test
	public void testGetDeviceById() 
	{
		int deviceId = 1;
		
		Device device = new Device("Samsung J2", "Electronics", "BR1234", 1234," version 12.5 ", "Smart Phone", false) ;
		
		Mockito.when(listOfDevicesDao.getDeviceById(deviceId)).thenReturn(device);
		
		assertThat(listOfDevicesService.getDeviceById(deviceId)).isEqualTo(device);
		
		
		
	  	//assertNotNull(listOfDevicesService.getDeviceById(this.deviceIdToBeTested));
	}

	
	
	
	
}

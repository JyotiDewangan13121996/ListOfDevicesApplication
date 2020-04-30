package com.app;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.app.serviceTesterRunner.DeviceServiceTestRunner;
import com.app.serviceTesterRunner.ListOfDeviceServiceTestRunner;
import com.app.serviceTesterRunner.ManufacturerServiceTestRunner;


@SpringBootTest
class ListOfDevicesApplicationTests
{
	
	private ListOfDeviceServiceTestRunner listTestRunner = new ListOfDeviceServiceTestRunner() ;
	
	private DeviceServiceTestRunner deviceTestRunner = new DeviceServiceTestRunner() ;
	
	private ManufacturerServiceTestRunner manufacturerTestRunner = new ManufacturerServiceTestRunner();
	

	@Test
	void contextLoads()
	{
		
		// To run test cases to methods of ListOfDevicesService class .
		
		listTestRunner.listOfDeviceServiceTestRunnerMethod();
		
		
		
		
		// To run test cases to methods of DevicesService class .
		
		deviceTestRunner.deviceServiceTestRunnerMethod();
		
		
		
		
		// To run test cases to methods of ManufacturerService class .
		
		manufacturerTestRunner.manufacturerServiceTestRunnerMethod();
		
	}

}

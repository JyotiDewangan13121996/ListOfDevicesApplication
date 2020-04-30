package com.app.serviceTesterRunner;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import com.app.serviceTester.DeviceServiceTester;

public class DeviceServiceTestRunner
{

	public  void deviceServiceTestRunnerMethod() 
	{
	   Result result =  JUnitCore.runClasses(DeviceServiceTester.class);	
	   
	   for ( Failure failure : result.getFailures() )
	   {
		   System.out.println( failure.toString());
	   }
	   
	   System.out.println(result.wasSuccessful());
	   
	}
	
	
	
}

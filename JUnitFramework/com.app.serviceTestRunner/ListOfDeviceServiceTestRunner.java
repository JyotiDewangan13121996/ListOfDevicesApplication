package com.app.serviceTesterRunner;

import org.junit.runner.JUnitCore;

import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import com.app.serviceTester.ListOfDevicesServiceTester;

public class ListOfDeviceServiceTestRunner 
{

	public  void listOfDeviceServiceTestRunnerMethod() 
	{
	   Result result =  JUnitCore.runClasses(ListOfDevicesServiceTester.class);	
	   
	   for ( Failure failure : result.getFailures() )
	   {
		   System.out.println( failure.toString());
	   }
	   
	   System.out.println(result.wasSuccessful());
	   
	}
	
	
}
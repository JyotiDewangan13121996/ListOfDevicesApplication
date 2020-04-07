package com.app.serviceTesterRunner;


import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import com.app.serviceTester.ManufacturerServiceTester;

public class ManufacturerServiceTestRunner 
{

	public  void  manufacturerServiceTestRunnerMethod () 
	{
	   Result result =  JUnitCore.runClasses( ManufacturerServiceTester.class);	
	   
	   for ( Failure failure : result.getFailures() )
	   {
		   System.out.println( failure.toString());
	   }
	   
	   System.out.println(result.wasSuccessful());
	   
	}
	
	
}

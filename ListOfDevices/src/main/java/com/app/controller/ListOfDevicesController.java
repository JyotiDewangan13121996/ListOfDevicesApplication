package com.app.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Device;
import com.app.service.IListOfDevicesService;

@RestController
@CrossOrigin
@RequestMapping("/listOfDevices")

public class ListOfDevicesController
{
	
	@Autowired
	private IListOfDevicesService listOfDeviceService ;
	
	
	@PostConstruct
	public void init() {
		System.out.println("in init " + listOfDeviceService);
	}
	
	
	// REST request handling method to get list of devices .
	@GetMapping
	public ResponseEntity<?> displayListOfDevices()
	{
		System.out.println(" in list of devices ");
		
		List<Device> listOfDevices = listOfDeviceService.getListOfDevices() ;
		
		if(listOfDevices.size() == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT) ;
		
		return new ResponseEntity<List<Device>>(listOfDevices , HttpStatus.OK);
		
	}
	
	
	// REST request handling method to add new device .
	@PostMapping("/addNewDevice")
	
	public ResponseEntity<?> addNewDevice( @RequestBody Device device )
	{
		System.out.println(" Add new device :  " + device);
		
		try
		{

			Device newDevice = new Device(device.getDeviceName(), device.getDeviceType(), device.getModelName(), device.getModelNo(), device.getModelDescription(), device.getProductDescription(), device.isDeviceStatus());
					
			
			return new ResponseEntity<Device>(listOfDeviceService.addNewDevice(newDevice) , HttpStatus.CREATED) ;
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			
			return new ResponseEntity<Void> (HttpStatus.INTERNAL_SERVER_ERROR) ;
		}
		
	}
	
	
	
	// REST request handling method to remove a device from the list .
	
	@DeleteMapping("/deleteDevice/{deviceId}")
	public ResponseEntity<Void> removeDeviceFromList(@PathVariable int deviceId)
	{
		System.out.println(" Delete device having device id : " + deviceId);
		
		Device deviceToBeRemoved = listOfDeviceService.getDeviceById(deviceId);
		
		listOfDeviceService.removeDevice(deviceToBeRemoved);
		
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
	
	
	
	// REST request handling method to get details of a device using its device id  .
	
	@GetMapping("/deviceDetails/{deviceId}")
	
	public ResponseEntity<?> getDeviceDetailsByDeviceId(@PathVariable int deviceId)
	{
		
		System.out.println(" Get device details by device id : " + deviceId);
		
		Device deviceDetails = listOfDeviceService.getDeviceById(deviceId);
		
		if(deviceDetails == null )
			return new ResponseEntity<Void> (HttpStatus.NOT_FOUND) ;
		
		return new ResponseEntity<Device>(deviceDetails , HttpStatus.OK ) ;
		
	}
	

}
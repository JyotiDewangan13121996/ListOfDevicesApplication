package com.app.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.sound.midi.VoiceStatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Device;
import com.app.service.IDeviceService;

@RestController
@CrossOrigin
@RequestMapping("/device")

public class DeviceController 
{
	
	@Autowired
	private IDeviceService deviceService ;
	
	
	@PostConstruct
	public void init() {
		System.out.println("in init " + deviceService );
	}
	
	
	
	// REST request handling method to set the power button  of the device;
	
	@PutMapping("/powerButton/{deviceId}")
	public ResponseEntity<?> powerButton(@PathVariable int deviceId)
	{
		
		System.out.println("Power Button for device having device id : " + deviceId);
		
		Device deviceDetails = deviceService.getDetailsOfDevice(deviceId) ;
		boolean deviceStatus = deviceService.powerButton(deviceDetails);
		
		if(deviceDetails == null )
			return new ResponseEntity<Void> (HttpStatus.NOT_FOUND) ;
		
		deviceDetails.setDeviceStatus(deviceStatus);
		
		try
		{
			return new ResponseEntity<Device>(deviceService.updateDeviceDetails(deviceDetails) ,HttpStatus.OK) ;
			
		} catch (Exception e) 
		{
			e.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR ) ;
		}	
		
	}
	
	
	
	// REST request handling method to get the status of the device .
	
	@GetMapping("/statusOfDevice/{deviceId}")
	public ResponseEntity<?> getStatusOfDevice( @PathVariable int deviceId )
	{
		System.out.println("Status of device having device id : " + deviceId);
		
		Device deviceDetails = deviceService.getDetailsOfDevice(deviceId);
		
		if(deviceDetails == null)
			 return new ResponseEntity<Void> (HttpStatus.NOT_FOUND) ;
		
		return new ResponseEntity<Boolean> (deviceDetails.isDeviceStatus() , HttpStatus.OK) ;
		
	}
	
	

	// REST request handling method to get the details of the device .
	@GetMapping("/detailsOfDevice/{deviceId}")
	public ResponseEntity<?> getDetailsOfDevice( @PathVariable int deviceId )
	{
		System.out.println(" Details of device having : " + deviceId);
		
		Device deviceDetails = deviceService.getDetailsOfDevice(deviceId) ;
		
		if(deviceDetails == null )
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND) ;
		
		return new ResponseEntity<Device> (deviceDetails , HttpStatus.OK) ;
		
	}
	
	

	// REST request handling method to reset the status of the device .
	
	@PutMapping("/resetButton/{deviceId}")
	public ResponseEntity<?> resetDevice(@PathVariable int deviceId )
	{
		System.out.println( " Reset device having device id : " + deviceId );
		
		Device deviceDetails = deviceService.getDetailsOfDevice(deviceId) ;
		
		boolean deviceStatus = deviceService.resetDevice(deviceDetails) ;
		
		if(deviceDetails == null)
			return new ResponseEntity<Void> (HttpStatus.NOT_FOUND) ;
		
		deviceDetails.setDeviceStatus(deviceStatus);
		
		try
		{
			return new ResponseEntity<Device> (deviceService.updateDeviceDetails(deviceDetails),HttpStatus.OK) ;
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			return new ResponseEntity<Void> (HttpStatus.INTERNAL_SERVER_ERROR) ;
		}
		
		
	}
	
	
	// REST request handling method to update the details of the device .
	
	@PutMapping("/updateDeviceDetails/{deviceId}")
	public ResponseEntity<?> updateDeviceDetails(@PathVariable int deviceId , @RequestParam String deviceName , @RequestParam String deviceType,
			                         @RequestParam String modelName, @RequestParam Integer modelNo , @RequestParam String modelDescription ,
			                         @RequestParam String productDescription)
	{
		System.out.println(" Update Device Details having deviceId : " + deviceId);
		
		Device deviceDetails = deviceService.getDetailsOfDevice(deviceId);
		
		if(deviceDetails == null)
			return new ResponseEntity<Void> (HttpStatus.NOT_FOUND) ;
		
		deviceDetails.setDeviceName(deviceName);
		deviceDetails.setDeviceType(deviceType);
		deviceDetails.setModelName(modelName);
		deviceDetails.setModelNo(modelNo);
		deviceDetails.setModelDescription(modelDescription);
		deviceDetails.setProductDescription(productDescription);
		
		try
		{
			return new ResponseEntity<Device>(deviceService.updateDeviceDetails(deviceDetails), HttpStatus.OK) ;
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			
			return new ResponseEntity<Void>( HttpStatus.INTERNAL_SERVER_ERROR ) ;
		}
		
		
		
	}
	
	
	
	
	// REST request handling method to get list of devices .
		@GetMapping("/listOfDevices")
		public ResponseEntity<?> displayListOfDevices()
		{
			System.out.println(" in list of devices ");
			
			List<Device> listOfDevices = deviceService.getListOfDevices() ;
			
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

				Device newDevice = new Device(device.getCategory(), device.getDeviceId(), device.getDeviceName(), device.getDeviceType(), device.getModelName(), device.getModelNo(), device.getModelDescription(), device.getProductDescription(), device.isDeviceStatus());
						
				
				return new ResponseEntity<Device>(deviceService.addNewDevice(newDevice) , HttpStatus.CREATED) ;
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
			
			Device deviceToBeRemoved = deviceService.getDeviceById(deviceId);
			
			deviceService.removeDevice(deviceToBeRemoved);
			
			return new ResponseEntity<>(HttpStatus.OK);
			
		}
		
		
		
		// REST request handling method to get details of a device using its device id  .
		
		@GetMapping("/deviceDetails/{deviceId}")
		
		public ResponseEntity<?> getDeviceDetailsByDeviceId(@PathVariable int deviceId)
		{
			
			System.out.println(" Get device details by device id : " + deviceId);
			
			Device deviceDetails = deviceService.getDeviceById(deviceId);
			
			if(deviceDetails == null )
				return new ResponseEntity<Void> (HttpStatus.NOT_FOUND) ;
			
			return new ResponseEntity<Device>(deviceDetails , HttpStatus.OK ) ;
			
		}
		
	

}

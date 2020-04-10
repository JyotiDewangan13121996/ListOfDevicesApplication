package com.app.pojos;







public class Manufacturer
{
   private Integer manufactureId ;
   private String manufacturerName ;
   private String locationOfManufacturing ;
   
   private String  dateOfManufacturing ;
   
   private Device device;
   
   
   // default constructor of Manufacturer class.
   public Manufacturer() 
   {
      System.out.println( " in default constructor of the Manufacturer class");
   }


  
  // parameterized constructor of the Manufacturer class .
   
  public Manufacturer(Integer manufactureId, String manufacturerName, String locationOfManufacturing,
		String dateOfManufacturing) {
	super();
	this.manufactureId = manufactureId;
	this.manufacturerName = manufacturerName;
	this.locationOfManufacturing = locationOfManufacturing;
	this.dateOfManufacturing = dateOfManufacturing;
}


  // Getters and Setters .

  
 

//getter and setter for  manufacturer Id of the device.
 

  
public Integer getManufactureId() {
	return manufactureId;
}



public void setManufactureId(Integer manufactureId) {
	this.manufactureId = manufactureId;
}


//getter and setter for manufacturer name of the device

public String getManufacturerName() {
	return manufacturerName;
}



public void setManufacturerName(String manufacturerName) {
	this.manufacturerName = manufacturerName;
}


//getter and setter for location of manufacturing the device.

public String getLocationOfManufacturing() {
	return locationOfManufacturing;
}



public void setLocationOfManufacturing(String locationOfManufacturing) {
	this.locationOfManufacturing = locationOfManufacturing;
}


//getter and setter for date of manufacturing 

public String getDateOfManufacturing() {
	return dateOfManufacturing;
}



public void setDateOfManufacturing(String dateOfManufacturing) {
	this.dateOfManufacturing = dateOfManufacturing;
}



// getter and setter for device .

public Device getDevice() {
	return device;
}


public void setDevice(Device device) {
	this.device = device;
}




// Overridden toString() method of Manufacturer class.

@Override
public String toString() {
	return "Manufacturer [ manufactureId=" + manufactureId + ", manufacturerName="
			+ manufacturerName + ", locationOfManufacturing=" + locationOfManufacturing + ", dateOfManufacturing="
			+ dateOfManufacturing + "]";
}
	
  
  
   
   
}

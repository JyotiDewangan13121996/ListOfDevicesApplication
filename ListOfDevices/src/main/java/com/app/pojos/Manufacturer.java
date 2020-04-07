package com.app.pojos;

import javax.persistence.*;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "manufacturer")

public class Manufacturer
{
   private Integer manufactureId ;
   private String manufacturerName ;
   private String locationOfManufacturing ;
   
   @JsonFormat(pattern = "yyyy-MM-dd" , timezone = "IST")
   @DateTimeFormat(pattern = "yyyy-MM-dd")
   private Date dateOfManufacturing ;
   
   private Device device;
   
   
   // default constructor of Manufacturer class.
   public Manufacturer() 
   {
      System.out.println( " in default constructor of the Manufacturer class");
   }


  
  // parameterized constructor of the Manufacturer class .
   
  public Manufacturer(Integer manufactureId, String manufacturerName, String locationOfManufacturing,
		Date dateOfManufacturing) {
	super();
	this.manufactureId = manufactureId;
	this.manufacturerName = manufacturerName;
	this.locationOfManufacturing = locationOfManufacturing;
	this.dateOfManufacturing = dateOfManufacturing;
}


  // Getters and Setters .

  
 

//getter and setter for  manufacturer Id of the device.
 
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "manufactureId")
  
public Integer getManufactureId() {
	return manufactureId;
}



public void setManufactureId(Integer manufactureId) {
	this.manufactureId = manufactureId;
}


//getter and setter for manufacturer name of the device
@Column(name = "manufacturerName" , length = 50 )
public String getManufacturerName() {
	return manufacturerName;
}



public void setManufacturerName(String manufacturerName) {
	this.manufacturerName = manufacturerName;
}


//getter and setter for location of manufacturing the device.
@Column(name = "locationOfManufacturing" , length = 30 )
public String getLocationOfManufacturing() {
	return locationOfManufacturing;
}



public void setLocationOfManufacturing(String locationOfManufacturing) {
	this.locationOfManufacturing = locationOfManufacturing;
}


//getter and setter for date of manufacturing 
@Column(name = "dateOfManufacturing")
@Temporal(TemporalType.DATE)
public Date getDateOfManufacturing() {
	return dateOfManufacturing;
}



public void setDateOfManufacturing(Date dateOfManufacturing) {
	this.dateOfManufacturing = dateOfManufacturing;
}



// getter and setter for device .

@OneToOne
@JoinColumn(name = "deviceId")
@JsonIgnore
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

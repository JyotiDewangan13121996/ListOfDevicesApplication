package com.app.pojos;


public class Device 
{
	private String category ; 
	private Integer deviceId ;
	private String deviceName ;
	private String deviceType ;
	private String modelName ;
	private Integer modelNo ;
	private String modelDescription ;
	private String productDescription ;
	private boolean deviceStatus;
	
	
	
	// default constructor of Device
		public Device() 
		{
			System.out.println("in default constructor of Device");
		}
		
		
		// paramaterized constructor of Device.
		

		public Device(String category, Integer deviceId, String deviceName, String deviceType, String modelName,
			Integer modelNo, String modelDescription, String productDescription, boolean deviceStatus) {
		super();
		this.category = category;
		this.deviceId = deviceId;
		this.deviceName = deviceName;
		this.deviceType = deviceType;
		this.modelName = modelName;
		this.modelNo = modelNo;
		this.modelDescription = modelDescription;
		this.productDescription = productDescription;
		this.deviceStatus = deviceStatus;
	}





		//Getters And Setters
		
		//getter and setter for category

		public String getCategory() {
			return category;
		}



		public void setCategory(String category) {
			this.category = category;
		}


		//getter and setter for device id

		public Integer getDeviceId() {
			return deviceId;
		}



		public void setDeviceId(Integer deviceId) {
			this.deviceId = deviceId;
		}


		//getter and setter for device name.

		public String getDeviceName() {
			return deviceName;
		}



		public void setDeviceName(String deviceName) {
			this.deviceName = deviceName;
		}


		//getter and setter for device type.

		public String getDeviceType() {
			return deviceType;
		}



		public void setDeviceType(String deviceType) {
			this.deviceType = deviceType;
		}


		//getter and setter for model name.

		public String getModelName() {
			return modelName;
		}



		public void setModelName(String modelName) {
			this.modelName = modelName;
		}


		//getter and setter for model no.

		public Integer getModelNo() {
			return modelNo;
		}



		public void setModelNo(Integer modelNo) {
			this.modelNo = modelNo;
		}


		//getter and setter for model description.

		public String getModelDescription() {
			return modelDescription;
		}



		public void setModelDescription(String modelDescription) {
			this.modelDescription = modelDescription;
		}


		//getter and setter for  product description .

		public String getProductDescription() {
			return productDescription;
		}



		public void setProductDescription(String productDescription) {
			this.productDescription = productDescription;
		}



		//getter and setter for device status.
		
		public boolean isDeviceStatus() {
			return deviceStatus;
		}



		public void setDeviceStatus(boolean deviceStatus) {
			this.deviceStatus = deviceStatus;
		}


		//Overriden toString() method for Device.
		
		@Override
		public String toString() {
			return "Device [deviceId=" + deviceId + ", deviceName=" + deviceName + ", productDescription="
					+ productDescription + ", deviceStatus=" + deviceStatus + "]";
		}


		
		

	

}

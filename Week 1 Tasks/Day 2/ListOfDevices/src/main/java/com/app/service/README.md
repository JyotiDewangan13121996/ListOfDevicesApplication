# Service Layer

=> Service layer basically calls the methods from DAO layer which contains the business logic o implement the functionality .

=> Here I have defined interfaces as follows : 

1. IDeviceService - for Device class
2. IManufacturerService - for Manufacturer class 


=> Here I have defined interface implementation classes as follows : 

1. DeviceServiceImplementation - for Device class
2. ManufacturerServiceImplementation - for Manufacturer class 


**********************************  1. IDeviceService  ***************************************

This class contains the following un-implemented methods for : 

1. To power on and power of the device.
2. To get the on or off power status of the device.
3. To get the details of the device.
4. To reset the device to off mode .
5. To update the details of the device .
6. To display the list of devices. 
7. To add new device in the list .
8. To remove a device from the list .
9. To find a device using its device id.


**********************************  2. IManufacturerService  ***************************************

This class contains the following un-implemented methods for : 

1. To get the manufacturer details .
2. To update the manufacturer details .




**********************************  1. DeviceServiceImplementation  ***************************************

This class implements the un-implemented methods of IDeviceDao interface such as : 

1. To power on and power of the device.
2. To get the on or off power status of the device.
3. To get the details of the device.
4. To reset the device to off mode .
5. To update the details of the device .
6. To display the list of devices. 
7. To add new device in the list .
8. To remove a device from the list .
9. To find a device using its device id.


**********************************  2. ManufacturerServiceImplementation  ***************************************

This class implements the un-implemented methods of IManufacturerDao interface such as :  

1. To get the manufacturer details .
2. To update the manufacturer details .







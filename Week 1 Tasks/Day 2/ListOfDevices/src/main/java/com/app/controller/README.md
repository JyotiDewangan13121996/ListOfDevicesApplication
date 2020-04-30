# Controller 

=> Here I have defined two controllers :
1.  DeviceController  - for writing REST API for Device class.
2.  ManufacturerController - for writing REST API for Manufaturer class.


****************************  1. DeviceController **************************************

- Here interface " IDeviceService " is autowired (dependency injection) .

- REST request handling methods have been defined  here : 

1. To set the power button of device .
2. To get the status of the device .
3. To get the details of the device .
4. To reset the status of the device .
5. To update the details of the device .
6. To get the list of devices .
7. To add new device to the list.
8. To remove a device from the list .
9. To get the details of a device using its device id.




****************************  2. ManufacturerController **************************************

- Here interface " IManufacturerService " is autowired (dependency injection) .

- REST request handling methods have been defined  here : 

1. To get mannufacturer details by mannufacturer id .
2. To update the manufacturer details .



**********************************************************************************

-> Here the methods from the service layer will be called to carry out the functionality which will further call the methods from DAO Layer having business logic



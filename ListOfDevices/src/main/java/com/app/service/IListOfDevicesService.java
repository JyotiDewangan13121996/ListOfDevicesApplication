package com.app.service;

import java.util.List;

import com.app.pojos.Device;

public interface IListOfDevicesService 
{
   List<Device> getListOfDevices() ;   // to display the list of devices. 
   
   Device addNewDevice( Device newDevice ) ;  // to  add new device in the list
   
   void removeDevice( Device deviceToBeRemoved ) ;  // to remove a device from the list
   
   Device getDeviceById( Integer deviceId ) ;  // to find a device using its device id.
   
}

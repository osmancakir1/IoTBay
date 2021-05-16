/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.model;

/**
 *
 * @author mapso
 */
public class IotDevices {

    private int deviceId;
    private String deviceName;
    private int numberInStock;

    public int getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(int deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public int getNumberInStock() {
        return numberInStock;
    }

    public void setNumberInStock(int deviceType) {
        this.numberInStock = deviceType;
    }

    public IotDevices() {
    }

    public IotDevices(int deviceId, String deviceName, int deviceType) {
        this.deviceId = deviceId;
        this.deviceName = deviceName;
        this.numberInStock = deviceType;
    }

    @Override
    public String toString() {
        return "IotDevices{" + "deviceId=" + deviceId + ", deviceName=" + deviceName + ", deviceType=" + numberInStock + '}';
    }
    
    
}

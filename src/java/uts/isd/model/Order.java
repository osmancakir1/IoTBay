package uts.isd.model;

import java.io.Serializable;
import java.sql.Date;

public class Order implements Serializable{
    private int OrderID;
    private int CustomerID;
    private int PaymentID;
    private int DeviceID;
    private String Status;
    private int InvoiceID;
    private Date Date;
    private int count;

    public Order() {
    }
    
    
    //object creation
    public Order(int CustomerID, int PaymentID, int DeviceID, String Status, int InvoiceID, Date Date) {
        this.CustomerID = CustomerID;
        this.PaymentID = PaymentID;
        this.DeviceID = DeviceID;
        this.Status = Status;
        this.InvoiceID = InvoiceID;
        this.Date = Date;
    }
    //session storage
    public Order(int OrderID, int CustomerID, int PaymentID, int DeviceID, String Status, int InvoiceID, Date Date) {
        this.OrderID = OrderID;
        this.CustomerID = CustomerID;
        this.PaymentID = PaymentID;
        this.DeviceID = DeviceID;
        this.Status = Status;
        this.InvoiceID = InvoiceID;
        this.Date = Date;
    }
    
    //object creation
    public Order(int CustomerID, int PaymentID, int DeviceID, String Status, int count, int InvoiceID, Date Date) {
        this.CustomerID = CustomerID;
        this.PaymentID = PaymentID;
        this.DeviceID = DeviceID;
        this.Status = Status;
        this.InvoiceID = InvoiceID;
        this.Date = Date;
        this.count = count;
    }
    
    //object creation
    public Order(int orderId, int CustomerID, int PaymentID, int DeviceID, String Status, int count, int InvoiceID, Date Date) {
        this.OrderID = orderId;
        this.CustomerID = CustomerID;
        this.PaymentID = PaymentID;
        this.DeviceID = DeviceID;
        this.Status = Status;
        this.InvoiceID = InvoiceID;
        this.Date = Date;
        this.count = count;
    }

    public int getOrderID() {
        return OrderID;
    }

    public void setOrderID(int OrderID) {
        this.OrderID = OrderID;
    }

    public int getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(int StaffID) {
        this.CustomerID = CustomerID;
    }

    public int getPaymentID() {
        return PaymentID;
    }

    public void setPaymentID(int PaymentID) {
        this.PaymentID = PaymentID;
    }

    public int getDeviceID() {
        return DeviceID;
    }

    public void setDeviceID(int DeviceID) {
        this.DeviceID = DeviceID;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public int getInvoiceID() {
        return InvoiceID;
    }

    public void setInvoiceID(int InvoiceID) {
        this.InvoiceID = InvoiceID;
    }

    public Date getDate() {
        return Date;
    }

    public void setDate(Date Date) {
        this.Date = Date;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
    
}

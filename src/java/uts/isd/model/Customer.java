package uts.isd.model;

import java.io.Serializable;

public class Customer implements Serializable {

    private int customerId;
    private int userId;
    private String firstName;
    private String lastName;
    private String otherNames;
    private String address;
    private int phone;
    private int payment;

    public Customer() {
    }

    public Customer(int customerId, int userId, String firstName, String lastName, String otherNames, String address, int phone, int payment) {
        this.customerId = customerId;
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.otherNames = otherNames;
        this.address = address;
        this.phone = phone;
        this.payment = payment;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getOtherNames() {
        return otherNames;
    }

    public void setOtherNames(String otherNames) {
        this.otherNames = otherNames;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public int getPayment() {
        return payment;
    }

    public void setPayment(int payment) {
        this.payment = payment;
    }

    @Override
    public String toString() {
        return "Customer{" + "customerId=" + customerId + ", userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", otherNames=" + otherNames + ", address=" + address + ", phone=" + phone + ", payment=" + payment + '}';
    }
    
}

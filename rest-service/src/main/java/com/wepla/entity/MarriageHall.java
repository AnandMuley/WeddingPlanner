package com.wepla.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "marriagehalls")
public class MarriageHall {

    @Id
    private String id;

    private String location;
    private String officeAddress;
    private Person contactPerson;
    private short rate;
    private HallType hallType;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getOfficeAddress() {
        return officeAddress;
    }

    public void setOfficeAddress(String officeAddress) {
        this.officeAddress = officeAddress;
    }

    public Person getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(Person contactPerson) {
        this.contactPerson = contactPerson;
    }

    public short getRate() {
        return rate;
    }

    public void setRate(short rate) {
        this.rate = rate;
    }

    public HallType getHallType() {
        return hallType;
    }

    public void setHallType(HallType hallType) {
        this.hallType = hallType;
    }

    @Override
    public String toString() {
        return "MarriageHall{" +
                "id='" + id + '\'' +
                ", location='" + location + '\'' +
                ", officeAddress='" + officeAddress + '\'' +
                ", contactPerson=" + contactPerson +
                ", rate=" + rate +
                ", hallType=" + hallType +
                '}';
    }
}

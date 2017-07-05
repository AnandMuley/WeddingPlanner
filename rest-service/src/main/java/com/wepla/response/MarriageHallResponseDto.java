package com.wepla.response;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class MarriageHallResponseDto {

    private String id;
    private String officeAddress;
    private String hallLocation;
    private String personToContact;
    private String contactNo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOfficeAddress() {
        return officeAddress;
    }

    public void setOfficeAddress(String officeAddress) {
        this.officeAddress = officeAddress;
    }

    public String getHallLocation() {
        return hallLocation;
    }

    public void setHallLocation(String hallLocation) {
        this.hallLocation = hallLocation;
    }

    public String getPersonToContact() {
        return personToContact;
    }

    public void setPersonToContact(String personToContact) {
        this.personToContact = personToContact;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    @Override
    public String toString() {
        return "MarriageHallResponse{" +
                "id='" + id + '\'' +
                ", officeAddress='" + officeAddress + '\'' +
                ", hallLocation='" + hallLocation + '\'' +
                ", personToContact='" + personToContact + '\'' +
                ", contactNo='" + contactNo + '\'' +
                '}';
    }
}

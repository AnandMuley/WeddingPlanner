package com.wepla.rest.dto;

public class PanditDto {

    private String id;
    private String name;
    private String contactNo;
    private String emailId;
    private AddressDto addressDto;

    public PanditDto() {
        addressDto = new AddressDto();
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public AddressDto getAddressDto() {
        return addressDto;
    }

    public void setAddressDto(AddressDto addressDto) {
        this.addressDto = addressDto;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PanditDto{");
        sb.append("id='").append(id).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", contactNo='").append(contactNo).append('\'');
        sb.append(", emailId='").append(emailId).append('\'');
        sb.append(", addressDto=").append(addressDto);
        sb.append('}');
        return sb.toString();
    }
}

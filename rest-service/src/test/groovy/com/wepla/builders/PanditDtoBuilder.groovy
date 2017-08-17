package com.wepla.builders

import com.wepla.rest.dto.AddressDto
import com.wepla.rest.dto.PanditDto

class PanditDtoBuilder {

     String id
     String name
     String contactNo
     String emailId
     AddressDto addressDto

    PanditDtoBuilder() {
        name = "Arjun Pandit"
        contactNo = "7780098700"
        emailId = "arjun.pandit@gmail.com"
        addressDto = new AddressDto(
                addressLine1: "Ram tekadi, Pune, 444001",
                city: "Pune",
                state: "Maharashtra"
        )
    }

    def withId(String id){
        this.id = id
        this
    }

    def withName(String name){
        this.name = name
        this
    }

    def withContactNo(String contactNo){
        this.contactNo = contactNo
        this
    }

    def withEmailId(String emailId){
        this.emailId = emailId
        this
    }

    def withAddress(AddressDto addressDto){
        this.addressDto = addressDto
        this
    }

    def build(){
        new PanditDto(
                id:id,
                name:name,
                contactNo:contactNo,
                emailId:emailId,
                addressDto: addressDto
        )
    }
}

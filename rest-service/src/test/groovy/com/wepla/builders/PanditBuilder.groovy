package com.wepla.builders

import com.wepla.entity.Address
import com.wepla.entity.Pandit

class PanditBuilder {

    String id
    String name
    String contactNo
    String emailId
    Address address

    PanditBuilder() {
        id = UUID.randomUUID().toString()
        name = "Arjun Pandit"
        contactNo = "7780098700"
        emailId = "arjun.pandit@gmail.com"
        address = new Address(
                addressLine1: "Ram tekadi, Pune, 444001",
                city: "Pune",
                state: "Maharashtra"
        )
    }

    def withId(String id) {
        this.id = id
    }

    def withName(String name) {
        this.name = name
    }

    def withContactNo(String contactNo) {
        this.contactNo = contactNo
    }

    def withEmailId(String emailId) {
        this.emailId = emailId
    }

    def withAddress(Address address) {
        this.address = address
    }

    def build() {
        new Pandit(
                id: id,
                name: name,
                contactNo: contactNo,
                emailId: emailId,
                address: address
        )
    }
}

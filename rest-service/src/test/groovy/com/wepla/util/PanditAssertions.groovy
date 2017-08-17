package com.wepla.util

import com.wepla.entity.Address
import com.wepla.rest.dto.AddressDto

class PanditAssertions {

    def static assertValue(AddressDto addressDto, Address address){
        assert addressDto.state == address.state
        assert addressDto.city == address.city
        assert addressDto.addressLine1 == address.addressLine1
        true
    }

}

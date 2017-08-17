package com.wepla.service.mappers;

import com.wepla.entity.Address;
import com.wepla.rest.dto.AddressDto;

import java.util.Optional;

public abstract class Mapper {

    public static void map(AddressDto source, Address target) {
        Optional.ofNullable(source.getAddressLine1()).ifPresent(target::setAddressLine1);
        Optional.ofNullable(source.getCity()).ifPresent(target::setCity);
        Optional.ofNullable(source.getState()).ifPresent(target::setState);
    }

    public static void map(Address source, AddressDto target) {
        Optional.ofNullable(source.getAddressLine1()).ifPresent(target::setAddressLine1);
        Optional.ofNullable(source.getCity()).ifPresent(target::setCity);
        Optional.ofNullable(source.getState()).ifPresent(target::setState);
    }

}

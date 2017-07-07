package com.wepla.rest

import com.wepla.entity.HallType
import com.wepla.entity.Person
import com.wepla.rest.dto.MarriageHallDto
import com.wepla.service.MarriageHallService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import spock.lang.Specification

class MarriageHallResourceSpec extends Specification {

    MarriageHallResource marriageHallResource
    MarriageHallService mockMarriageHallService

    def setup(){
        mockMarriageHallService = Mock()
        marriageHallResource = new MarriageHallResource(
                marriageHallService: mockMarriageHallService
        )
    }

    def "addMarriageHall - should add new entry"(){
        given:
        MarriageHallDto marriageHallDto = new MarriageHallDto(
                id: "123", location: "SB road", officeAddress: "akurdi", contactPerson: new Person(
                name: "Abc", contactNo: "9214526585"), rate: 1500, hallType: HallType.LAWN )
        1 * mockMarriageHallService.addMarriageHall(marriageHallDto) >> marriageHallDto.id
        0 * _
        when:
        ResponseEntity responseEntity = marriageHallResource.addMarriageHall(marriageHallDto);
        then:
        assert responseEntity.statusCodeValue == 200 && responseEntity.statusCode == HttpStatus.OK && responseEntity.body == marriageHallDto.id
    }

}

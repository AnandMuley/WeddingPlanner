package com.wepla.rest

import com.wepla.rest.dto.PanditDto
import com.wepla.service.PanditService
import spock.lang.Specification

import javax.ws.rs.core.Response

class PanditResourceSpec extends Specification{

    PanditResource panditResource;
    PanditService mockPanditResource;

    def setup(){
        mockPanditResource = Mock()
        panditResource = new PanditResource(
                panditService: mockPanditResource
        )
    }

    def "create - should return id of Pandit Object"(){
         given: "PanditDto is passed"
         PanditDto panditDto = new PanditDto(id:"123", name:"Abc", contactNo:"7845129663")
         1 * mockPanditResource.create({PanditDto panditDto1 -> panditDto1 instanceof PanditDto})
         0 * _
         when: "create api is called"
         Response response = panditResource.create(panditDto)
         then:
         assert response.status == 201
    }

}

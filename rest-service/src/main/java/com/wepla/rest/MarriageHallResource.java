package com.wepla.rest;

import com.wepla.rest.dto.MarriageHallDto;
import com.wepla.service.MarriageHallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;

@Component
@Path("marriagehalls")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MarriageHallResource {

    @Autowired
    private MarriageHallService marriageHallService;

    @POST
    public Response addMarraigeHall(MarriageHallDto marriageHallDto){
        return Response.created(URI.create(marriageHallService.addMarriageHall(marriageHallDto))).build();
    }

}

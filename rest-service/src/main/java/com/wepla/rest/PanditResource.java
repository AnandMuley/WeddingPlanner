package com.wepla.rest;

import com.wepla.rest.dto.PanditDto;
import com.wepla.service.PanditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;

@Component
@Path("pandits")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PanditResource {

    @Autowired
    private PanditService panditService;

    @POST
    public Response create(PanditDto panditDto) {
        panditService.create(panditDto);
        return Response.created(URI.create(panditDto.getId())).build();
    }

}

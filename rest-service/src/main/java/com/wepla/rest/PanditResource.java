package com.wepla.rest;

import com.wepla.rest.dto.PanditDto;
import com.wepla.service.PanditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
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

    @GET
    public Response getAll() {
        return Response.ok(panditService.getAll()).build();
    }

    @GET
    @Path("{name}")
    public Response getAll(@PathParam("name")String name) {
        return Response.ok(panditService.findByName(name)).build();
    }

    @DELETE
    @Path("{id}")
    public Response deleteById(@PathParam("id") String id) {
        panditService.delete(id);
        return Response.ok().build();
    }

}

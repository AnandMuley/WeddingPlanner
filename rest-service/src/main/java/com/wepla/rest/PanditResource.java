package com.wepla.rest;

import com.wepla.exceptions.NoDataFoundException;
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
    public Response search() {
        return Response.ok(panditService.getAll()).build();
    }

    @GET
    @Path(value = "{id}")
    public Response findById(@PathParam("id") String id) {
        try {
            return Response.ok(panditService.find(id)).build();
        } catch (NoDataFoundException e) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @PUT
    @Path(value = "{id}")
    public Response update(@PathParam("id") String id, PanditDto panditDto) {
        panditDto.setId(id);
        panditService.update(panditDto);
        return Response.noContent().build();
    }

    @GET
    @Path(value = "search")
    public Response search(@QueryParam("name") String name) {
        return Response.ok(panditService.findByName(name)).build();
    }

    @DELETE
    @Path("{id}")
    public Response deleteById(@PathParam("id") String id) {
        panditService.delete(id);
        return Response.ok().build();
    }

}

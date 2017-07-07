package com.wepla.rest;

import com.wepla.response.MarriageHallResponseDto;
import com.wepla.rest.dto.MarriageHallDto;
import com.wepla.service.MarriageHallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Component
@Path("marriagehalls")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MarriageHallResource {

    @Autowired
    private MarriageHallService marriageHallService;

    @POST
    public ResponseEntity addMarriageHall(MarriageHallDto marriageHallDto){
        String marriageHallId = marriageHallService.addMarriageHall(marriageHallDto);
        return ResponseEntity.ok(marriageHallId);
    }

    @GET
    @Path(value = "/location/{location}")
    public ResponseEntity getByLocation(@PathParam("location") String location){
        List<MarriageHallResponseDto> marriageHalls = marriageHallService.getByLocation(location);
        return ResponseEntity.ok(marriageHalls);
    }
}

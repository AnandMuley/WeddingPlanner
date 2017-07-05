package com.wepla.service;

import com.wepla.entity.MarriageHall;
import com.wepla.mapper.MarriageHallResponseGenerator;
import com.wepla.repository.MarriageHallRepository;
import com.wepla.response.MarriageHallResponseDto;
import com.wepla.rest.dto.MarriageHallDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarriageHallService {

    @Autowired
    private MarriageHallRepository marriageHallRepo;

    public String addMarriageHall(MarriageHallDto marriageHallDto){
        MarriageHall marriageHall = new MarriageHall();
        BeanUtils.copyProperties(marriageHallDto, marriageHall);
        marriageHallRepo.save(marriageHall);
        return marriageHall.getId();
    }

    public List<MarriageHallResponseDto> getByLocation(String location){
        List<MarriageHall> marriageHalls = marriageHallRepo.findByLocationContainingIgnoreCase(location);
        return MarriageHallResponseGenerator.mapMarriageHallResponse(marriageHalls);
    }
}

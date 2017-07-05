package com.wepla.mapper;

import com.wepla.entity.MarriageHall;
import com.wepla.response.MarriageHallResponseDto;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

public class MarriageHallResponseGenerator {

    public static List<MarriageHallResponseDto> mapMarriageHallResponse(List<MarriageHall> marriageHalls){
        List<MarriageHallResponseDto> marriageHallResponseDtos = marriageHalls.stream().map(marriageHall -> {
            MarriageHallResponseDto marriageHallResponseDto = new MarriageHallResponseDto();
            copyProperties(marriageHallResponseDto, marriageHall);
            return marriageHallResponseDto;
        }).collect(Collectors.toList());

        return marriageHallResponseDtos;
    }

    public static void copyProperties(MarriageHallResponseDto marriageHallResponseDto, MarriageHall marriageHall){
        marriageHallResponseDto.setContactNo(marriageHall.getContactPerson().getContactNo());
        marriageHallResponseDto.setPersonToContact(marriageHall.getContactPerson().getName());
        BeanUtils.copyProperties(marriageHall,marriageHallResponseDto);
    }
}

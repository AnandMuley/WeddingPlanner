package com.wepla.service;

import com.wepla.entity.Pandit;
import com.wepla.repository.PanditRepository;
import com.wepla.rest.dto.PanditDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PanditService {

    @Autowired
    private PanditRepository panditRepository;

    public void create(PanditDto panditDto) {
        Pandit pandit = new Pandit();
        BeanUtils.copyProperties(panditDto, pandit);
        panditRepository.save(pandit);
        panditDto.setId(pandit.getId());
    }

}

package com.wepla.service;

import com.wepla.entity.Pandit;
import com.wepla.repository.PanditRepository;
import com.wepla.rest.dto.PanditDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<PanditDto> getAll() {
        return panditRepository.findAll().stream().map(pandit -> {
            PanditDto panditDto = new PanditDto();
            BeanUtils.copyProperties(pandit, panditDto);
            return panditDto;
        }).collect(Collectors.toList());
    }

    public void delete(String id) {
        panditRepository.delete(id);
    }

    public List<PanditDto> findByName(String name) {
        return panditRepository.findByNameContainingIgnoreCase(name).stream().map(pandit -> {
            PanditDto panditDto = new PanditDto();
            BeanUtils.copyProperties(pandit, panditDto);
            return panditDto;
        }).collect(Collectors.toList());
    }
}

package com.wepla.service;

import com.wepla.entity.Pandit;
import com.wepla.exceptions.NoDataFoundException;
import com.wepla.repository.PanditRepository;
import com.wepla.rest.dto.PanditDto;
import com.wepla.service.mappers.Mapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PanditService {

    @Autowired
    private PanditRepository panditRepository;

    public void create(PanditDto panditDto) {
        Pandit pandit = new Pandit();
        BeanUtils.copyProperties(panditDto, pandit);
        if (Optional.ofNullable(panditDto.getAddressDto()).isPresent()) {
            Mapper.map(panditDto.getAddressDto(), pandit.getAddress());
        }
        panditRepository.save(pandit);
        panditDto.setId(pandit.getId());
    }

    public List<PanditDto> getAll() {
        return panditRepository.findAll().stream().map(pandit -> {
            PanditDto panditDto = new PanditDto();
            BeanUtils.copyProperties(pandit, panditDto);
            Mapper.map(pandit.getAddress(), panditDto.getAddressDto());
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
            Mapper.map(pandit.getAddress(), panditDto.getAddressDto());
            return panditDto;
        }).collect(Collectors.toList());
    }

    public PanditDto find(final String id) throws NoDataFoundException {
        PanditDto panditDto = new PanditDto();
        Pandit pandit = Optional.ofNullable(panditRepository.findOne(id)).orElseThrow(NoDataFoundException::new);
        BeanUtils.copyProperties(pandit, panditDto);
        Mapper.map(pandit.getAddress(), panditDto.getAddressDto());
        return panditDto;
    }

    public void update(final PanditDto panditDto) {
        final Pandit pandit = new Pandit();
        Optional.ofNullable(panditDto.getName()).ifPresent(pandit::setName);
        if (Optional.ofNullable(panditDto.getAddressDto()).isPresent()) {
            Mapper.map(panditDto.getAddressDto(), pandit.getAddress());
        }
        Optional.ofNullable(panditDto.getContactNo()).ifPresent(pandit::setContactNo);
        Optional.ofNullable(panditDto.getEmailId()).ifPresent(pandit::setEmailId);
        Optional.ofNullable(panditDto.getId()).ifPresent(pandit::setId);
        panditRepository.save(pandit);
    }
}

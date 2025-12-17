package com.example.finalprojectrpo.service.serviceImpl;


import com.example.finalprojectrpo.dto.PhoneDto;
import com.example.finalprojectrpo.mapper.PhoneMapper;
import com.example.finalprojectrpo.model.Phone;
import com.example.finalprojectrpo.repository.PhoneRepository;
import com.example.finalprojectrpo.service.PhoneService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PhoneServiceImpl implements PhoneService {

    private final PhoneRepository phoneRepository;
    private final PhoneMapper phoneMapper;

    @Override
    public List<PhoneDto> getAll() {
        return phoneMapper.toDtoList(phoneRepository.findAll());
    }

    @Override
    public PhoneDto getById(Long id) {
        return phoneMapper.toDto(phoneRepository.findById(id).orElse(null));
    }

    @Override
    public PhoneDto addPhone(PhoneDto phoneDto) {
        Phone phone = phoneMapper.toEntity(phoneDto);
        Phone savedPhone = phoneRepository.save(phone);
        return phoneMapper.toDto(savedPhone);
    }

    @Override
    public PhoneDto updPhone(Long id, PhoneDto phoneDto) {
        Phone phone = phoneRepository.findById(id).orElseThrow();
        phone.setName(phoneDto.getNameDto());
        phone.setDescription(phoneDto.getDescriptionDto());
        phone.setPrice(phoneDto.getPriceDto());
        return phoneMapper.toDto(phoneRepository.save(phone));
    }

    @Override
    public boolean delPhone(Long id) {
        if (!phoneRepository.existsById(id)) {
            return false;
        }
        phoneRepository.deleteById(id);
        return true;
    }
}

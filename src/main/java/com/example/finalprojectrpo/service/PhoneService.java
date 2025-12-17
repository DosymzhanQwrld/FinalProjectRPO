package com.example.finalprojectrpo.service;

import com.example.finalprojectrpo.dto.PhoneDto;

import java.util.List;

public interface PhoneService {
    List<PhoneDto> getAll();
    PhoneDto getById(Long id);
    PhoneDto addPhone(PhoneDto phoneDto);
    PhoneDto updPhone(Long id, PhoneDto phoneDto);
    boolean delPhone(Long id);
}

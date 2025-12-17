package com.example.finalprojectrpo.service;

import com.example.finalprojectrpo.dto.BrandDto;

import java.util.List;

public interface BrandService {
    List<BrandDto> getAll();
    BrandDto addBrand(BrandDto brandDto);
    BrandDto getById(Long id);
}

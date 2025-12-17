package com.example.finalprojectrpo.service.serviceImpl;

import com.example.finalprojectrpo.dto.BrandDto;
import com.example.finalprojectrpo.mapper.BrandMapper;
import com.example.finalprojectrpo.repository.BrandRepository;
import com.example.finalprojectrpo.service.BrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BrandServiceImpl implements BrandService {
    private final BrandRepository brandRepository;
    private final BrandMapper brandMapper;

    @Override
    public List getAll() {
        return brandMapper.toDtoList(brandRepository.findAll());
    }

    @Override
    public BrandDto addBrand(BrandDto brandDto) {
        return brandMapper.toDto(brandRepository.save(brandMapper.toEntity(brandDto)));
    }

    @Override
    public BrandDto getById(Long id) {
        return brandMapper.toDto(brandRepository.findById(id).orElse(null));
    }

}

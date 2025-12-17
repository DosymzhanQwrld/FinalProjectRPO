package com.example.finalprojectrpo.service.serviceImpl;

import com.example.finalprojectrpo.dto.CountryDto;
import com.example.finalprojectrpo.mapper.CountryMapper;
import com.example.finalprojectrpo.repository.CountryRepository;
import com.example.finalprojectrpo.service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CountryServiceImpl implements CountryService {
    private final CountryRepository countryRepository;
    private final CountryMapper countryMapper;

    @Override
    public List getAll() {
        return countryMapper.toDtoList(countryRepository.findAll());
    }

    @Override
    public void addCountry(CountryDto countryDto) {
        countryRepository.save(countryMapper.toEntity(countryDto));
    }

    @Override
    public void getById(Long id) {
        countryMapper.toDto(countryRepository.findById(id).orElse(null));
    }
}

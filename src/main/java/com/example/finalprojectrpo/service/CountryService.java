package com.example.finalprojectrpo.service;

import com.example.finalprojectrpo.dto.CountryDto;

import java.util.List;

public interface CountryService {

    List<CountryDto> getAll();
    CountryDto addCountry(CountryDto countryDto);
    CountryDto getById(Long id);
}
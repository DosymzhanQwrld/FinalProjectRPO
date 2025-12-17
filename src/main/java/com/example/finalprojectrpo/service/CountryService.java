package com.example.finalprojectrpo.service;

import com.example.finalprojectrpo.dto.CountryDto;

import java.util.List;

public interface CountryService {

    List<CountryDto> getAll();
    void addCountry(CountryDto countryDto);
    void getById(Long id);
}
package com.example.finalprojectrpo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PhoneDto {
    private Long id;
    private String nameDto;
    private String descriptionDto;
    private int priceDto;

    private BrandDto brand;
    private List<CountryDto> countries;
}

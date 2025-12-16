package com.example.finalprojectrpo.mapper;

import com.example.finalprojectrpo.dto.BrandDto;
import com.example.finalprojectrpo.model.Brand;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BrandMapper {
    @Mapping(source = "name", target = "nameDto")
    BrandDto toDto(Brand brand);
    @Mapping(source = "nameDto", target = "name")
    Brand toEntity(BrandDto brandDto);
    List<BrandDto> toDtoList(List<Brand> brandes);
}
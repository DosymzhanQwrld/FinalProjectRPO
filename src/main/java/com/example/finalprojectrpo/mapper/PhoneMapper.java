package com.example.finalprojectrpo.mapper;

import com.example.finalprojectrpo.dto.PhoneDto;
import com.example.finalprojectrpo.model.Phone;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PhoneMapper {
    @Mapping(source = "name", target = "nameDto")
    @Mapping(source = "description", target = "descriptionDto")
    @Mapping(source = "price", target = "priceDto")
    PhoneDto toDto(Phone phone);
    @Mapping(source = "nameDto", target = "name")
    @Mapping(source = "descriptionDto", target = "description")
    @Mapping(source = "priceDto", target = "price")
    Phone toEntity(PhoneDto phoneDto);
    List<PhoneDto> toDtoList(List<Phone> phones);
}


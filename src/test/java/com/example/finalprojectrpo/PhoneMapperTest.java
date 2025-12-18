package com.example.finalprojectrpo;

import com.example.finalprojectrpo.dto.PhoneDto;
import com.example.finalprojectrpo.mapper.PhoneMapper;
import com.example.finalprojectrpo.model.Brand;
import com.example.finalprojectrpo.model.Country;
import com.example.finalprojectrpo.model.Phone;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class PhoneMapperTest {

    @Autowired
    private PhoneMapper phoneMapper;

    @Test
    void convertEntityToDtoTest() {
        Brand brand = new Brand(1L, "Iphone");
        Country country = new Country(1L, "Japan", "JPN");
        Phone phoneEntity = new Phone(
                1L,
                "Iphone",
                "12 Pro Max",
                200000,
                brand,
                List.of(country)
        );
        PhoneDto dto = phoneMapper.toDto(phoneEntity);

        Assertions.assertNotNull(dto, "DTO не должен быть null");

        Assertions.assertEquals(phoneEntity.getName(), dto.getNameDto());
        Assertions.assertEquals(phoneEntity.getDescription(), dto.getDescriptionDto());
        Assertions.assertEquals(phoneEntity.getPrice(), dto.getPriceDto());
    }

    @Test
    void convertDtoToEntityTest() {

        PhoneDto dto = new PhoneDto();
        dto.setNameDto("Iphone");
        dto.setDescriptionDto("12 Pro Max");
        dto.setPriceDto(200000);

        Phone entity = phoneMapper.toEntity(dto);

        Assertions.assertNotNull(entity, "Entity не должен быть null");

        Assertions.assertEquals(dto.getNameDto(), entity.getName());
        Assertions.assertEquals(dto.getDescriptionDto(), entity.getDescription());
        Assertions.assertEquals(dto.getPriceDto(), entity.getPrice());
    }

    @Test
    void convertListEntityToDtoListTest() {

        Brand brand = new Brand(1L, "Iphone");
        Country country = new Country(1L, "Japan", "JPN");

        List<Phone> phoneList = new ArrayList<>(); //List of phones
        phoneList.add(new Phone(1L, "Iphone", "12 Pro Max", 200000, brand, List.of(country)));
        phoneList.add(new Phone(2L, "Samsung", "S24 Ultra", 350000, brand, List.of(country)));
        phoneList.add(new Phone(3L, "Xiaomi", "Mi 14", 150000, brand, List.of(country)));
        List<PhoneDto> dtoList = phoneMapper.toDtoList(phoneList); //change EntityListPhone to dto

        Assertions.assertNotNull(dtoList, "DTO List не должен быть null");
        Assertions.assertEquals(phoneList.size(), dtoList.size(), "Размер списков должен совпадать");

        for (int i = 0; i < dtoList.size(); i++) {
            PhoneDto dto = dtoList.get(i);
            Phone entity = phoneList.get(i);

            Assertions.assertEquals(entity.getName(), dto.getNameDto());
            Assertions.assertEquals(entity.getDescription(), dto.getDescriptionDto());
            Assertions.assertEquals(entity.getPrice(), dto.getPriceDto());
        }
    }
}
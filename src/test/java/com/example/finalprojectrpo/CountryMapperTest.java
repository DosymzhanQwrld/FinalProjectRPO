package com.example.finalprojectrpo;

import com.example.finalprojectrpo.dto.CountryDto;
import com.example.finalprojectrpo.mapper.CountryMapper;
import com.example.finalprojectrpo.model.Country;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class CountryMapperTest {

    @Autowired
    private CountryMapper countryMapper;

    @Test
    void convertEntityToDtoTest() {
        Country countryEntity = new Country(1L, "Japan", "JPN");
        CountryDto dto = countryMapper.toDto(countryEntity);

        Assertions.assertNotNull(dto);
        Assertions.assertEquals(countryEntity.getName(), dto.getNameDto());
        Assertions.assertEquals(countryEntity.getCode(), dto.getCodeDto());
    }

    @Test
    void convertDtoToEntityTest() {
        CountryDto dto = new CountryDto();
        dto.setNameDto("Kazakhstan");
        dto.setCodeDto("KZ");
        Country entity = countryMapper.toEntity(dto);

        Assertions.assertNotNull(entity);
        Assertions.assertEquals(dto.getNameDto(), entity.getName());
        Assertions.assertEquals(dto.getCodeDto(), entity.getCode());
    }

    @Test
    void convertListEntityToDtoListTest() {
        List<Country> countryList = new ArrayList<>();
        countryList.add(new Country(1L, "Japan", "JPN"));
        countryList.add(new Country(2L, "Kazakhstan", "KZ"));
        countryList.add(new Country(3L, "Korea", "KR"));

        List<CountryDto> dtoList = countryMapper.toDtoList(countryList);

        Assertions.assertNotNull(dtoList);
        Assertions.assertEquals(countryList.size(), dtoList.size());

        for (int i = 0; i < dtoList.size(); i++) {
            CountryDto dto = dtoList.get(i);
            Country entity = countryList.get(i);
            Assertions.assertEquals(entity.getName(), dto.getNameDto());
            Assertions.assertEquals(entity.getCode(), dto.getCodeDto());
        }
    }
}
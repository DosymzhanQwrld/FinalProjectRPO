package com.example.finalprojectrpo;

import com.example.finalprojectrpo.dto.CountryDto;
import com.example.finalprojectrpo.service.CountryService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Random;

@SpringBootTest
public class CountryServiceTest {

    @Autowired
    private CountryService countryService;

    @Test
    void getAllTest() {
        List<CountryDto> list = countryService.getAll();

        Assertions.assertNotNull(list);
        Assertions.assertNotEquals(0, list.size());

        for (CountryDto countryDto : list) {
            Assertions.assertNotNull(countryDto);
            Assertions.assertNotNull(countryDto.getId());
            Assertions.assertNotNull(countryDto.getNameDto());
            Assertions.assertNotNull(countryDto.getCodeDto());
        }
    }

    @Test
    void getByIdTest() {
        Random random = new Random();

        int randomIndex = random.nextInt(countryService.getAll().size());
        Long someIndex = countryService.getAll().get(randomIndex).getId();

        CountryDto countryDto = countryService.getById(someIndex);

        Assertions.assertNotNull(countryDto);
        Assertions.assertNotNull(countryDto.getId());
        Assertions.assertNotNull(countryDto.getNameDto());
        Assertions.assertNotNull(countryDto.getCodeDto());

        CountryDto checkCountry = countryService.getById(-1L);
        Assertions.assertNull(checkCountry);
    }

    @Test
    void addCountryTest() {
        CountryDto countryDto = new CountryDto();
        countryDto.setNameDto("TestCountry");
        countryDto.setCodeDto("TC");

        CountryDto createdCountry = countryService.addCountry(countryDto);

        Assertions.assertNotNull(createdCountry);
        Assertions.assertNotNull(createdCountry.getId());
        Assertions.assertNotNull(createdCountry.getNameDto());
        Assertions.assertNotNull(createdCountry.getCodeDto());

        Assertions.assertEquals(countryDto.getNameDto(), createdCountry.getNameDto());
        Assertions.assertEquals(countryDto.getCodeDto(), createdCountry.getCodeDto());

        CountryDto getCountry = countryService.getById(createdCountry.getId());

        Assertions.assertNotNull(getCountry);
        Assertions.assertEquals(createdCountry.getId(), getCountry.getId());
        Assertions.assertEquals(createdCountry.getNameDto(), getCountry.getNameDto());
        Assertions.assertEquals(createdCountry.getCodeDto(), getCountry.getCodeDto());
    }
}
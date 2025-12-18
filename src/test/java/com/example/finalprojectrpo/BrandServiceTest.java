package com.example.finalprojectrpo;

import com.example.finalprojectrpo.dto.BrandDto;
import com.example.finalprojectrpo.service.BrandService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Random;

@SpringBootTest
public class BrandServiceTest {

    @Autowired
    private BrandService brandService;

    @Test
    void getAllTest() {
        List<BrandDto> list = brandService.getAll();

        Assertions.assertNotNull(list);
        Assertions.assertNotEquals(0, list.size());

        for (BrandDto brandDto : list) {
            Assertions.assertNotNull(brandDto);
            Assertions.assertNotNull(brandDto.getId());
            Assertions.assertNotNull(brandDto.getNameDto());
        }
    }

    @Test
    void getByIdTest() {
        Random random = new Random();

        int randomIndex = random.nextInt(brandService.getAll().size());
        Long someIndex = brandService.getAll().get(randomIndex).getId();

        BrandDto brandDto = brandService.getById(someIndex);

        Assertions.assertNotNull(brandDto);
        Assertions.assertNotNull(brandDto.getId());
        Assertions.assertNotNull(brandDto.getNameDto());

        BrandDto checkBrand = brandService.getById(-1L);
        Assertions.assertNull(checkBrand);
    }

    @Test
    void addBrandTest() {
        BrandDto brandDto = new BrandDto();
        brandDto.setNameDto("TestBrand");
        BrandDto createdBrand = brandService.addBrand(brandDto);

        Assertions.assertNotNull(createdBrand);
        Assertions.assertNotNull(createdBrand.getId());
        Assertions.assertNotNull(createdBrand.getNameDto());

        Assertions.assertEquals(brandDto.getNameDto(), createdBrand.getNameDto());

        BrandDto getBrand = brandService.getById(createdBrand.getId());

        Assertions.assertNotNull(getBrand);

        Assertions.assertNotNull(getBrand.getId());
        Assertions.assertNotNull(getBrand.getNameDto());

        Assertions.assertEquals(createdBrand.getId(), getBrand.getId());
        Assertions.assertEquals(createdBrand.getNameDto(), getBrand.getNameDto());

    }
}
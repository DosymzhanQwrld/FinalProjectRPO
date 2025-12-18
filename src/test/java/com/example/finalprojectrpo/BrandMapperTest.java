package com.example.finalprojectrpo;

import com.example.finalprojectrpo.dto.BrandDto;
import com.example.finalprojectrpo.mapper.BrandMapper;
import com.example.finalprojectrpo.model.Brand;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class BrandMapperTest {

    @Autowired
    private BrandMapper brandMapper;

    @Test
    void convertEntityToDtoTest() {
        Brand brandEntity = new Brand(1L, "Iphone");
        BrandDto dto = brandMapper.toDto(brandEntity);

        Assertions.assertNotNull(dto);
        Assertions.assertEquals(brandEntity.getName(), dto.getNameDto());
    }

    @Test
    void convertDtoToEntityTest() {
        BrandDto dto = new BrandDto();
        dto.setNameDto("Samsung");
        Brand entity = brandMapper.toEntity(dto);

        Assertions.assertNotNull(entity);
        Assertions.assertEquals(dto.getNameDto(), entity.getName());
    }

    @Test
    void convertListEntityToDtoListTest() {
        List<Brand> brandList = new ArrayList<>();
        brandList.add(new Brand(1L, "Iphone"));
        brandList.add(new Brand(2L, "Samsung"));
        brandList.add(new Brand(3L, "Xiaomi"));

        List<BrandDto> dtoList = brandMapper.toDtoList(brandList);

        Assertions.assertNotNull(dtoList);
        Assertions.assertEquals(brandList.size(), dtoList.size());

        for (int i = 0; i < dtoList.size(); i++) {
            BrandDto dto = dtoList.get(i);
            Brand entity = brandList.get(i);
            Assertions.assertEquals(entity.getName(), dto.getNameDto());
        }
    }
}
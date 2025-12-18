package com.example.finalprojectrpo;

import com.example.finalprojectrpo.dto.PhoneDto;
import com.example.finalprojectrpo.service.PhoneService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Random;

@SpringBootTest
public class PhoneServiceTest {

    @Autowired
    private PhoneService phoneService;

    @Test
    void getAllTest() {
        List<PhoneDto> list = phoneService.getAll();

        Assertions.assertNotNull(list);
        Assertions.assertNotEquals(0, list.size());

        for (PhoneDto phoneDto : list) {
            Assertions.assertNotNull(phoneDto);
            Assertions.assertNotNull(phoneDto.getId());
            Assertions.assertNotNull(phoneDto.getNameDto());
            Assertions.assertNotNull(phoneDto.getPriceDto());
        }
    }

    @Test
    void getByIdTest() {
        Random random = new Random();

        int randomIndex = random.nextInt(phoneService.getAll().size());
        Long someIndex = phoneService.getAll().get(randomIndex).getId();

        PhoneDto phoneDto = phoneService.getById(someIndex);

        Assertions.assertNotNull(phoneDto);
        Assertions.assertNotNull(phoneDto.getId());
        Assertions.assertNotNull(phoneDto.getNameDto());
        Assertions.assertNotNull(phoneDto.getPriceDto());

        PhoneDto checkPhone = phoneService.getById(-1L);
        Assertions.assertNull(checkPhone);
    }

    @Test
    void addPhoneTest() {
        PhoneDto phoneDto = new PhoneDto();
        phoneDto.setNameDto("TestPhone");
        phoneDto.setPriceDto(99);

        PhoneDto createdPhone = phoneService.addPhone(phoneDto);

        Assertions.assertNotNull(createdPhone);
        Assertions.assertNotNull(createdPhone.getId());
        Assertions.assertNotNull(createdPhone.getNameDto());
        Assertions.assertNotNull(createdPhone.getPriceDto());

        Assertions.assertEquals(phoneDto.getNameDto(), createdPhone.getNameDto());
        Assertions.assertEquals(phoneDto.getPriceDto(), createdPhone.getPriceDto());

        PhoneDto getPhone = phoneService.getById(createdPhone.getId());

        Assertions.assertNotNull(getPhone);
        Assertions.assertEquals(createdPhone.getId(), getPhone.getId());
        Assertions.assertEquals(createdPhone.getNameDto(), getPhone.getNameDto());
        Assertions.assertEquals(createdPhone.getPriceDto(), getPhone.getPriceDto());
    }

    @Test
    void updatePhoneTest() {
        Random random = new Random();

        int randomIndex = random.nextInt(phoneService.getAll().size());
        Long someIndex = phoneService.getAll().get(randomIndex).getId();

        PhoneDto phoneDto = new PhoneDto();
        phoneDto.setId(someIndex);
        phoneDto.setNameDto("UpdatedPhone");
        phoneDto.setPriceDto(150);

        phoneService.updPhone(phoneDto.getId(), phoneDto);

        PhoneDto updatedPhone = phoneService.getById(someIndex);

        Assertions.assertNotNull(updatedPhone);
        Assertions.assertEquals(phoneDto.getId(), updatedPhone.getId());
        Assertions.assertEquals(phoneDto.getNameDto(), updatedPhone.getNameDto());
        Assertions.assertEquals(phoneDto.getPriceDto(), updatedPhone.getPriceDto());
    }

    @Test
    void deletePhoneTest() {
        Random random = new Random();

        int randomIndex = random.nextInt(phoneService.getAll().size());
        Long someIndex = phoneService.getAll().get(randomIndex).getId();

        Assertions.assertTrue(phoneService.delPhone(someIndex));

        PhoneDto checkPhone = phoneService.getById(someIndex);
        Assertions.assertNull(checkPhone);
    }
}
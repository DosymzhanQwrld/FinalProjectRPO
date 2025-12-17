package com.example.finalprojectrpo.controller;

import com.example.finalprojectrpo.dto.PhoneDto;
import com.example.finalprojectrpo.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/phone")
public class PhoneApi {
    @Autowired
    private PhoneService phoneService;

    @GetMapping
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(phoneService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable(name = "id") Long id) {
        return new ResponseEntity<>(phoneService.getById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> addPhone(@RequestBody PhoneDto phoneDto) {
        phoneService.addPhone(phoneDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updPhone(@PathVariable(name = "id") Long id,
                                      @RequestBody PhoneDto phoneDto) {
        phoneService.updPhone(id, phoneDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delPhone(@PathVariable(name = "id")Long id){
        if (phoneService.delPhone(id)){
            return new ResponseEntity<>(HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}


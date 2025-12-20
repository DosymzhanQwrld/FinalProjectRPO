package com.example.finalprojectrpo.controller;

import com.example.finalprojectrpo.model.User;
import com.example.finalprojectrpo.service.ItemService;
import com.example.finalprojectrpo.service.MyService;
import com.example.finalprojectrpo.service.PhoneService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class UserApi {

    private final MyService myService;
    private final ItemService itemService;

    @GetMapping
    public String getAuth(){
        return "hello";
    }
    @PostMapping("/register")
    public String getRegister(@RequestBody User user){
        myService.regitr(user);
        return "done";
    }
    @GetMapping("/items")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public ResponseEntity<?> getItems(){
        return new ResponseEntity<>(itemService.getAll(), HttpStatus.OK);
    }
}
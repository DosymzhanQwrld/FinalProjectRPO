package com.example.finalprojectrpo.service;

import com.example.finalprojectrpo.model.Item;
import com.example.finalprojectrpo.repository.ItemRep;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemRep itemRep;


    public List<Item> getAll(){
        return itemRep.findAll();
    }
}

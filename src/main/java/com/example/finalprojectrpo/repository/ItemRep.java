package com.example.finalprojectrpo.repository;

import com.example.finalprojectrpo.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRep extends JpaRepository<Item, Long> {
}

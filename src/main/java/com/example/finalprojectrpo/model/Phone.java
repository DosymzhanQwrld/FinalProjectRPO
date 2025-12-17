package com.example.finalprojectrpo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "t_phone")
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private int price;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "brand_id")
    private Brand brand;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Country> countries;
}

package com.art.artproject.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Tnx {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

}

package com.art.artproject.entity;

import jakarta.persistence.*;
import jakarta.persistence.criteria.Path;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter

public class Card {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String imageFile;

    private String file;
    private String imageTitle;
    private Double price;
    private String description;
    private String userName;


    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="user_id")
    private User user;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="category_id")
    private Category category;


}
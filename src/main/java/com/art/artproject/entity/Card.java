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
<<<<<<< HEAD
    private String imageFile;
=======
    private String file;
>>>>>>> 6ee21ce59f7530cf681c45adf1863a59902f8866
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
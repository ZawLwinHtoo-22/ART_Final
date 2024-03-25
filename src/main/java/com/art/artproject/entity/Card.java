package com.art.artproject.entity;

import com.art.artproject.dto.NewCardRequest;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String image;
    private String imageTitle;
    private Double price;
    private String description;
    private String userName;
//    @Column(name = "admin_approved")
//    private Boolean admin_approved;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="user_id")
    private User user;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="category_id")
    private Category category;

}
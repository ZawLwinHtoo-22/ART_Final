package com.art.artproject.entity;

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
    private String imageFile;
    private String imageTitle;
    private Double price;
    private String description;
    private String userName;


//    Byte[] FileData = new Byte[imageFile.length];
//    for (int i = 0; i < imageFile.length; i++) {
//        FileData[i] = imageFile[i];
//    }
//    public Byte[] getimageFile() {
//        return Arrays.stream(imageFile)
//                .sorted()
//                .toArray(Byte[]::new);
//    }
//    public void setimageFile(Byte[] imageFile) {
//        this.imageFile = imageFile;
//    }


    public String getImageFile() {
        return imageFile;
    }

    public void setImageFile(String imageFile) {
        this.imageFile = imageFile;
    }

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="user_id")
    private User user;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="category_id")
    private Category category;


}
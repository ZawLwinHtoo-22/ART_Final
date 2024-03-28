package com.art.artproject.entity;

import ch.qos.logback.classic.spi.LoggingEventVO;
import com.art.artproject.dto.NewUserRequest;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user_art")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstName;
    private String lastName;
    private String userName;
    private String phoneNumber;
    private String mail;
    private String profileImage;
    private String password;


    public static User of(NewUserRequest request) {
        User user = new User();
        user.firstName = request.getFirstName();
        user.lastName = request.getLastName();
        user.userName = request.getFirstName()+" "+request.getLastName();
        user.phoneNumber = request.getPhoneNumber();
        user.mail = request.getMail();
        user.profileImage = request.getProfileImage();
        user.password = request.getPassword();
        return user;
    }

    public User(String userName, String profileImage) {
        this.userName = userName;
        this.profileImage = profileImage;
    }



}
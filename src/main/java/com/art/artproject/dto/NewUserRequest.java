package com.art.artproject.dto;

import com.art.artproject.entity.User;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class NewUserRequest {

    private Long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String mail;
    private String profileImage;
    private String password;

//    private Long id;
//    private String userName;
//    private String profileImage;

    public static User getUser(NewUserRequest userRequest){
        return new User()
                .builder()
                .id(userRequest.getId())
                .userName(userRequest.getFirstName()+" "+userRequest.getLastName())
                .profileImage(userRequest.getProfileImage())
                .build();
    }

}
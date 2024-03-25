package com.art.artproject.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserInfo {
    private Long user_id;
    private String mail;
    private String password;

        public static UserInfo of (User user){
            UserInfo userInfo = new UserInfo();
            userInfo.user_id=user.getId();
            userInfo.mail = user.getMail();
            userInfo.password = user.getPassword();

            return userInfo;

        }
}

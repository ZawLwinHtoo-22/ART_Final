package com.art.artproject.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdminInfo {

    private String mail;
    private String password;

    public static AdminInfo of (Admin admin){
        AdminInfo adminInfo = new AdminInfo();
        adminInfo.mail = admin.getMail();
        adminInfo.password = admin.getPassword();
        return adminInfo;
    }

}

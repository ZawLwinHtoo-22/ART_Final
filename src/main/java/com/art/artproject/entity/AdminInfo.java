package com.art.artproject.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdminInfo {
    private Long id;
    private String mail;
    private String password;

    public static AdminInfo of (Admin admin){
        AdminInfo adminInfo = new AdminInfo();
        adminInfo.id=admin.getId();
        adminInfo.mail = admin.getMail();
        adminInfo.password = admin.getPassword();
        return adminInfo;
    }


}

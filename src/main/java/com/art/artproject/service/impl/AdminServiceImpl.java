package com.art.artproject.service.impl;

import com.art.artproject.dto.AdminValidateRequest;
import com.art.artproject.entity.Admin;
import com.art.artproject.entity.AdminInfo;
import com.art.artproject.repo.AdminRepo;
import com.art.artproject.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepo adminRepo;

    @Override
    public AdminInfo validateAdmin(AdminValidateRequest adminValidateRequest) {
        final Admin admin = adminRepo
                .findAdminByMailAndPassword(adminValidateRequest.getMail(),adminValidateRequest.getPassword())
                .orElseThrow( () -> new RuntimeException("NO Admin"));

        return AdminInfo.of(admin);
    }
}

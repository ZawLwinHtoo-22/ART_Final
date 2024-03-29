package com.art.artproject.controller;

import com.art.artproject.domain.TalentResponse;
import com.art.artproject.dto.AdminValidateRequest;
import com.art.artproject.entity.AdminInfo;
import com.art.artproject.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/admins")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/validate")
    public ResponseEntity<TalentResponse<AdminInfo>> validateAdmin(@RequestBody AdminValidateRequest request){
        AdminInfo adminInfo=adminService.validateAdmin(request);
        TalentResponse<AdminInfo> response=
                new TalentResponse<>(adminInfo,"Successfully Logined", HttpStatus.OK);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}

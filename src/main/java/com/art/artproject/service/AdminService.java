package com.art.artproject.service;

import com.art.artproject.dto.AdminValidateRequest;
import com.art.artproject.entity.AdminInfo;

public interface AdminService {

    AdminInfo validateAdmin(AdminValidateRequest adminValidateRequest);

}

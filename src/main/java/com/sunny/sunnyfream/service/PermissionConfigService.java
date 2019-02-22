package com.sunny.sunnyfream.service;


import com.sunny.sunnyfream.model.PermissionConfig;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PermissionConfigService {

    List<PermissionConfig> getAllPermission();
}

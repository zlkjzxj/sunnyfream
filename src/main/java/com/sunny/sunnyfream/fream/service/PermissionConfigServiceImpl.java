package com.sunny.sunnyfream.fream.service;

import com.sunny.sunnyfream.mapper.PermissionConfigMapper;
import com.sunny.sunnyfream.fream.model.RolePermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description TODO
 * @Author sunny
 * Date 2019\1\28 0028 17:42
 */
@Service
public class PermissionConfigServiceImpl implements PermissionConfigService {
    @Autowired
    private PermissionConfigMapper permissionConfigMapper;

    @Override
    public List<RolePermission> getAllPermission() {
        return permissionConfigMapper.getAllPermission();
    }
}

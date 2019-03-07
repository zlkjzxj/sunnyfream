package com.sunny.sunnyfream.fream.service;

import com.sunny.sunnyfream.mapper.SysUserMapper;
import com.sunny.sunnyfream.fream.model.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private SysUserMapper userMapper;

    @Override
    public SysUser findByName(String name) {
        return userMapper.findByName(name);
    }
}

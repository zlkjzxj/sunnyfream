package com.sunny.sunnyfream.service;


import com.sunny.sunnyfream.model.SysUser;

public interface UserService {
    public SysUser findByName(String name);

}

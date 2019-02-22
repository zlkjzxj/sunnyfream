package com.sunny.sunnyfream.mapper;

import com.sunny.sunnyfream.model.SysUser;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component
public interface SysUserMapper {
    @Select("select * from sysuser where username = #{username}")
    SysUser findByName(String username);
}

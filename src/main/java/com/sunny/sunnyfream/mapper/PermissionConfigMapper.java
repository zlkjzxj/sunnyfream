package com.sunny.sunnyfream.mapper;

import com.sunny.sunnyfream.model.PermissionConfig;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Description TODO
 * @Author sunny
 * Date 2019\1\28 0028 17:38
 */
@Component
public interface PermissionConfigMapper {
    @Select("select * from permission_config order by sort")
    List<PermissionConfig> getAllPermission();
}

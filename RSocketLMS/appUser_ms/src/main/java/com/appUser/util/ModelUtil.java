package com.appUser.util;

import com.appUser.dto.UserDto;
import com.appUser.model.User;
import org.springframework.beans.BeanUtils;

public class ModelUtil {

    public static UserDto toDto(User user){
        UserDto dto = new UserDto();
        BeanUtils.copyProperties(user, dto);
        return dto;

    }

    public static User toEntity(UserDto dto){
        User user = new User();
        BeanUtils.copyProperties(dto, user);
        return user;

    }
}

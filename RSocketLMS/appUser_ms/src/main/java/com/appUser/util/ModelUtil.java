package com.appUser.util;

import com.appUser.dto.AppUserDto;
import com.appUser.model.AppUser;
import org.springframework.beans.BeanUtils;

public class ModelUtil {

    public static AppUserDto toDto(AppUser user){
        AppUserDto dto = new AppUserDto();
        BeanUtils.copyProperties(user, dto);
        return dto;

    }

    public static AppUser toEntity(AppUserDto dto){
        AppUser user = new AppUser();
        BeanUtils.copyProperties(dto, user);
        return user;

    }
}

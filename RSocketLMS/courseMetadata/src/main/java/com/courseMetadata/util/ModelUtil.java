package com.courseMetadata.util;

import com.courseMetadata.dto.CourseMetaDataDto;
import com.courseMetadata.model.CourseMetaData;
import org.springframework.beans.BeanUtils;

public class ModelUtil {

    public static CourseMetaDataDto toDto(CourseMetaData courseMetaData){
        CourseMetaDataDto dto = new CourseMetaDataDto();
        BeanUtils.copyProperties(courseMetaData,dto);
        return dto;
    }

    public static CourseMetaData toEntity(CourseMetaDataDto dto){
        CourseMetaData courseMetaData = new CourseMetaData();
        BeanUtils.copyProperties(dto,courseMetaData);
        return courseMetaData;
    }
}

package com.courseMetadata.dto;


import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor()
public class CourseMetaDataDto {
    private String courseId;
    private String title;
    private String description;
    private double rating;
    private int level;
    private int duration;
    private double studentProgress;
    private String prerequisites;
    private String learningObjectives;
    private String imageUrl;
    private String[] keywords;
    private String language= "en-US";
    private Integer Year;
    private Long view;
    private String price;
    private static Long views;
    private String CategoryId;
    private List<String> authorIds;



}

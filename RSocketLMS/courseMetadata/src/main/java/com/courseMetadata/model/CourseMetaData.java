package com.courseMetadata.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(staticName = "create")
@Component
public class CourseMetaData {
    @Id
    private String id;
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
    private Integer view;
    private String price;
    private static Long views;
    private String CategoryId;
    private List<String> authorIds;
}

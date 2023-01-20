package com.appUser.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppUserDto {
    private String firstName;
    private String lastName;
    private String organization;
    private String username;
    private String password;
    private String email;
    private boolean isAdmin = false;
    private List<String> enrolledCourses;
}

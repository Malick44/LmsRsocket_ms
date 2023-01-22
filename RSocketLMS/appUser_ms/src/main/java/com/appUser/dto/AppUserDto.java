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
    private String middleName;
    private String lastName;
    private String organization;
    private String designation;
    private String username;
    private String password;
    private String email;
    private String phoneNumber;
    private Address address;
    private String profilePic;
    private String bio;
    private String linkedInUrl;
    private String twitterUrl;
    private String facebookUrl;
    private boolean isAdmin = false;
    private boolean isAuthor = false;
    private boolean isStudent = true;
    private boolean isActive = false;
    private boolean isVerified = false;
    private boolean isEmailVerified = false;
    private boolean isPhoneVerified = false;
    private List<String> enrolledCourses;

}

package com.appUser.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AppUser {
    @Id
    private String id;

    private String firstName;
    private String lastName;
    private String organization;
    private String username;
    private String password;
    private String email;
    private boolean isAdmin = false;
    private List<String> enrolledCourses;
}

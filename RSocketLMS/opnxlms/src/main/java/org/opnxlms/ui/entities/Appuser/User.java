package org.opnxlms.ui.entities.Appuser;


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
public class User {
    @Id
    private String id;
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
    private boolean isActive = true;
    private boolean isVerified = false;
    private boolean isEmailVerified = false;
    private boolean isPhoneVerified = false;
    private List<String> enrolledCourses;
}

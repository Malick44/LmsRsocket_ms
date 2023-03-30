package com.appUser.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Document("user_address")
public class Address {
    private String street;
    private String city;
    private String state;
    private String country;
    private String zipCode;

}



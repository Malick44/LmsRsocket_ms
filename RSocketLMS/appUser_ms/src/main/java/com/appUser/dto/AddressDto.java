package com.appUser.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Data
public class AddressDto {
    private String houseNumber;
    private String street;
    private String country;
    private String state;
    private String city;
    private String zipCode;
}

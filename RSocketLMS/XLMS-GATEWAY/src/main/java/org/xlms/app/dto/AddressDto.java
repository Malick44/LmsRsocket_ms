package org.xlms.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

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

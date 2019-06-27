package com.github.emilg1101.marketplace.model.form;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
public class AddressForm {
    Long id;
    @Size(min = 2, max = 128, message = "Please enter Contact name between 2 - 128 characters")
    String name;
    @Size(min = 2, max = 64, message = "Please enter Country between 2 - 64 characters")
    String country;
    @Size(min = 2, max = 128, message = "Please enter Street address one 2 - 128 characters")
    String address;
    @Size(min = 2, max = 128, message = "Please enter Street address two 2 - 128 characters")
    String address2;
    @Size(min = 2, max = 64, message = "Please enter State between 2 - 64 characters")
    String state;
    @Size(min = 2, max = 64, message = "Please enter City between 2 - 64 characters")
    String city;
    @Size(min = 6, max = 6, message = "Please enter a ZIP/Postal Code")
    @Digits(integer = 6, fraction = 0, message = "Please Enter a 6-digit zip code, such as 123456")
    String zip;
    @Size(min = 11, max = 18, message = "Please enter Phone between 11 - 18 characters")
    String phone;
}

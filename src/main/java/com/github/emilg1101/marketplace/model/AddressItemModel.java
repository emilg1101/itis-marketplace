package com.github.emilg1101.marketplace.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddressItemModel {
    long id;
    String contactName;
    String country;
    String streetAddressOne;
    String streetAddressTwo;
    String state;
    String city;
    String zip;
    String mobile;
}

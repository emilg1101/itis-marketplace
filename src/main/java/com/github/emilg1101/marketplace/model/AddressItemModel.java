package com.github.emilg1101.marketplace.model;

import com.github.emilg1101.marketplace.data.entity.Address;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
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

    public static AddressItemModel map(Address address) {
        return AddressItemModel.builder()
                .id(address.getId())
                .contactName(address.getContactName())
                .country(address.getCountry())
                .streetAddressOne(address.getStreetAddressOne())
                .streetAddressTwo(address.getStreetAddressTwo())
                .state(address.getState())
                .city(address.getCity())
                .zip(address.getZip())
                .mobile(address.getMobile())
                .build();
    }
}

package com.github.emilg1101.marketplace.data.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@Entity
@Table(name = "address")
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    @Id
    @GeneratedValue
    Long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;
    @Column(name = "contact_name")
    String contactName;
    String country;
    @Column(name = "street_address_one")
    String streetAddressOne;
    @Column(name = "street_address_two")
    String streetAddressTwo;
    String state;
    String city;
    String zip;
    String mobile;
}

package com.github.emilg1101.marketplace.service;

import com.github.emilg1101.marketplace.data.entity.Address;
import com.github.emilg1101.marketplace.data.entity.User;
import com.github.emilg1101.marketplace.data.repository.AddressRepository;
import com.github.emilg1101.marketplace.model.form.AddressForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    public Address add(AddressForm form, User user) {
        Address address = Address.builder()
                .user(user)
                .contactName(form.getName())
                .country(form.getCountry())
                .streetAddressOne(form.getAddress())
                .streetAddressTwo(form.getAddress2())
                .state(form.getState())
                .city(form.getCity())
                .zip(form.getZip())
                .mobile(form.getPhone())
                .build();
        return addressRepository.save(address);
    }

    public Address get(long addressId, User user) {
        Optional<Address> addressCandidate = addressRepository.findById(addressId);
        if (addressCandidate.isPresent()) {
            if (addressCandidate.get().getUser().getId().equals(user.getId())) {
                return addressCandidate.get();
            }
        }
        throw new EntityNotFoundException();
    }

    public void update(AddressForm form, User user) {
        Address address = Address.builder()
                .id(form.getId())
                .user(user)
                .contactName(form.getName())
                .country(form.getCountry())
                .streetAddressOne(form.getAddress())
                .streetAddressTwo(form.getAddress2())
                .state(form.getState())
                .city(form.getCity())
                .zip(form.getZip())
                .mobile(form.getPhone())
                .build();
        addressRepository.save(address);
    }

    public void delete(long addressId, User user) {
        Optional<Address> addressCandidate = addressRepository.findById(addressId);
        if (addressCandidate.isPresent()) {
            if (addressCandidate.get().getUser().getId().equals(user.getId())) {
                addressRepository.delete(addressCandidate.get());
            } else {
                throw new EntityNotFoundException();
            }
        } else {
            throw new EntityNotFoundException();
        }
    }
}

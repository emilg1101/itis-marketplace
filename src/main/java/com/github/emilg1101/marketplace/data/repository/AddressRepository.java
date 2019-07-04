package com.github.emilg1101.marketplace.data.repository;

import com.github.emilg1101.marketplace.data.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}

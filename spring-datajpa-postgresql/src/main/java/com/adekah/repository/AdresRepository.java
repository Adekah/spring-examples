package com.adekah.repository;

import com.adekah.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdresRepository extends JpaRepository<Address, Long> {
}

package com.symbo.insurance.microservicetest.repository;

import com.symbo.insurance.microservicetest.domain.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, String> {
}

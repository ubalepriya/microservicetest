package com.symbo.insurance.microservicetest.repository;

import com.symbo.insurance.microservicetest.domain.UserDetails;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface UserRepository extends CrudRepository<UserDetails, String> {
}

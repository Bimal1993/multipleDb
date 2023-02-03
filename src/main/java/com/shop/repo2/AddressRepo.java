package com.shop.repo2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.shop.model2.Address;

@Component
@Repository
public interface AddressRepo extends JpaRepository<Address, Integer> {

}

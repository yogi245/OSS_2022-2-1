package com.upc.relaciones.repository.oneToOne.unidirectional;

import com.upc.relaciones.model.oneToOne.unidirectional.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}

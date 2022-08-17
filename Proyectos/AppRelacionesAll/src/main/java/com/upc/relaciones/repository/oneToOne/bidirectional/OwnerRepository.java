package com.upc.relaciones.repository.oneToOne.bidirectional;

import com.upc.relaciones.model.oneToOne.bidirectional.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepository extends JpaRepository<Owner, Long> {
}

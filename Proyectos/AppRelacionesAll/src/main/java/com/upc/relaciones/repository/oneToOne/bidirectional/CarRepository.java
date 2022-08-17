package com.upc.relaciones.repository.oneToOne.bidirectional;

import com.upc.relaciones.model.oneToOne.bidirectional.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
}

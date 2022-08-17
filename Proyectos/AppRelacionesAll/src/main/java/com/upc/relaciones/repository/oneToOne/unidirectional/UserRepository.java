package com.upc.relaciones.repository.oneToOne.unidirectional;

import com.upc.relaciones.model.oneToOne.unidirectional.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}

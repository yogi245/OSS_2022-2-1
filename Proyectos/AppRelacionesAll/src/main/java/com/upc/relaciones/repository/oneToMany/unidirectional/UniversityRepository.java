package com.upc.relaciones.repository.oneToMany.unidirectional;

import com.upc.relaciones.model.oneToMany.unidirectional.University;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UniversityRepository extends JpaRepository<University, Long> {
}

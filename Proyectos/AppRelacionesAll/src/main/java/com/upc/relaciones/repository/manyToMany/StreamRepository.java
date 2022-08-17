package com.upc.relaciones.repository.manyToMany;

import com.upc.relaciones.model.manyToMany.Stream;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StreamRepository extends JpaRepository<Stream, Long> {
}

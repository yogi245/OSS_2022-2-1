package com.upc.relaciones.repository.manyToMany;

import com.upc.relaciones.model.manyToMany.Viewer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ViewerRepository extends JpaRepository<Viewer, Long> {
}

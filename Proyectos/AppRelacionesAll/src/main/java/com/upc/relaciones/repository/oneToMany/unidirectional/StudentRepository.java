package com.upc.relaciones.repository.oneToMany.unidirectional;

import com.upc.relaciones.model.oneToMany.unidirectional.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}

package com.upc.relaciones.repository.oneToMany.bidirectional;

import com.upc.relaciones.model.oneToMany.bidirectional.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
}

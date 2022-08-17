package com.upc.relaciones.model.oneToMany.bidirectional;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
  //  @Column(name = "cart_id")
    private Long id;
    private String name;
    @OneToMany(
            mappedBy = "cart",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Item> items = new ArrayList<>();

    public Cart(String name) {
        this.name = name;
    }

    public Cart() {
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}

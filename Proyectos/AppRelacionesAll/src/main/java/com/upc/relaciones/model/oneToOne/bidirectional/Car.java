package com.upc.relaciones.model.oneToOne.bidirectional;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "Car")
@Data
@RequiredArgsConstructor
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String model;
    @OneToOne(mappedBy = "car")
    private Owner owner;

}

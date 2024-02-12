package com.AlfonsoMarquez.PruebaTecnica4.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Plane {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long planeId;
    private String model;
    private int capacity;
    private int touristCapacity;
    private int businessCapacity;
    @OneToMany(mappedBy = "plane")
    private List<Flight> flights;
}

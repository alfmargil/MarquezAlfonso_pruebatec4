package com.AlfonsoMarquez.PruebaTecnica4.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Person {

    @Id
    private Long id;
    private String name;
    private String email;
    @ManyToMany
    private List<RoomBooking> roomBookings;

}

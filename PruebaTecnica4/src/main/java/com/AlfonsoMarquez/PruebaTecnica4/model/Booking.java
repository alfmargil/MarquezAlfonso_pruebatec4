package com.AlfonsoMarquez.PruebaTecnica4.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int peopleQ;
    private LocalDate checkIn;
    private LocalDate checkOut;
    private String roomType;
    private int nights;
    private String place;
    @ManyToOne
    @JoinColumn(name = "hotel_code", referencedColumnName = "hotelCode")
    private Hotel hotel;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Person> hosts;

}

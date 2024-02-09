package com.AlfonsoMarquez.PruebaTecnica4.model;

import com.fasterxml.jackson.annotation.JsonFormat;
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
public class RoomBooking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int peopleQ;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate checkIn;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate checkOut;
    private int nights;
    @ManyToOne
    private Hotel hotel;
    private Room room;
    @ManyToMany
    private List<Person> hosts;

}

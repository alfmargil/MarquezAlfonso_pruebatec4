package com.AlfonsoMarquez.PruebaTecnica4.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class FlightBooking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int peopleQ;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate departureDate;
    private String origin;
    private String destination;
    private String seatType;
    @ManyToOne
    @JoinColumn(name = "flight_id")
    @JsonIgnore
    private Flight flight;
    @ManyToMany
    @JoinTable(
            name = "Booking_Passengers",
            joinColumns = @JoinColumn(name = "booking_id"),
            inverseJoinColumns = @JoinColumn(name = "person_id")
    )
    private List<Person> passengers;


}

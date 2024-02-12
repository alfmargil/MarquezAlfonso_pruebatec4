package com.AlfonsoMarquez.PruebaTecnica4.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Random;

@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Flight {

    @Id
    String flightCode;
    String origin;
    String destination;
    String seatType;
    Double pricePerPerson;
    @JsonFormat(pattern = "dd/MM/yyyy")
    LocalDate departureDate;
    @ManyToOne
    @JoinColumn(name = "plane_code")
    @JsonIgnore
    private Plane plane;
    private int capacity;
     /*
    @JsonFormat(pattern = "dd/MM/yyyy")
    LocalDate returnDate;
    */

    public Flight(String origin, String destination, String seatType, Double pricePerPerson, LocalDate departureDate) {
        this.origin = origin;
        this.destination = destination;
        this.seatType = seatType;
        this.pricePerPerson = pricePerPerson;
        this.departureDate = departureDate;
        this.flightCode = generateFlightCode(origin,destination);
    }

    public static String generateFlightCode(String origin, String destination)
    {
        String originCode = origin.substring(0, Math.min(origin.length(), 2)).toUpperCase();
        String destinationCode = destination.substring(0, Math.min(destination.length(), 2)).toUpperCase();
        Random random = new Random();
        int randomNumber = random.nextInt(10000);
        return originCode + destinationCode + String.format("%04d", randomNumber);
    }
}

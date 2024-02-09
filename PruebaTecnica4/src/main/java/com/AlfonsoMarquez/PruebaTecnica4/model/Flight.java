package com.AlfonsoMarquez.PruebaTecnica4.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

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

    /*
    @JsonFormat(pattern = "dd/MM/yyyy")
    LocalDate departureDate;
    @JsonFormat(pattern = "dd/MM/yyyy")
    LocalDate returnDate;
    */
}

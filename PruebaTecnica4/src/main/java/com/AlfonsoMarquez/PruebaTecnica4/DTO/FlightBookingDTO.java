package com.AlfonsoMarquez.PruebaTecnica4.DTO;

import com.AlfonsoMarquez.PruebaTecnica4.model.Person;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FlightBookingDTO {

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate departureDate;
    private String origin;
    private String destination;
    private String seatType;
    private String flightCode;
    private List<Person> passengers;

}

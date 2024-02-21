package com.AlfonsoMarquez.PruebaTecnica4.DTO;

import com.AlfonsoMarquez.PruebaTecnica4.model.Flight;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FlightDTO {

    String flightCode;
    String origin;
    String destination;
    String seatType;
    Double pricePerPerson;
    @JsonFormat(pattern = "dd/MM/yyyy")
    LocalDate departureDate;
    Long planeId;

    public FlightDTO(Flight flight) {
        this.flightCode = flight.getFlightCode();
        this.origin = flight.getOrigin();
        this.destination = flight.getDestination();
        this.seatType = flight.getSeatType();
        this.pricePerPerson = flight.getPricePerPerson();
        this.departureDate = flight.getDepartureDate();
        this.planeId = flight.getPlane().getPlaneId();
    }
}

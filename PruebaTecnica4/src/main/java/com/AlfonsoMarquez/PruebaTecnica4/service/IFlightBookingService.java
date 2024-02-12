package com.AlfonsoMarquez.PruebaTecnica4.service;

import com.AlfonsoMarquez.PruebaTecnica4.DTO.FlightBookingDTO;
import com.AlfonsoMarquez.PruebaTecnica4.model.Flight;
import com.AlfonsoMarquez.PruebaTecnica4.model.FlightBooking;

import java.util.List;

public interface IFlightBookingService {

    public List<FlightBooking> getFlightBookings();
    public double saveFlightBooking(FlightBookingDTO roomBooking) throws Exception;
    public void deleteFlightBooking(Long id);
    public Flight findFlightBooking(Long id);

}

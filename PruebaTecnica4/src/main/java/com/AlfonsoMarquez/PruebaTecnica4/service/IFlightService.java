package com.AlfonsoMarquez.PruebaTecnica4.service;

import com.AlfonsoMarquez.PruebaTecnica4.model.Flight;

import java.util.List;

public interface IFlightService {

    public List<Flight> getFlights();
    public void saveFlights(Flight flight);
    public void deleteFlight(String code);
    public Flight findFlight(String code);

}

package com.AlfonsoMarquez.PruebaTecnica4.service;

import com.AlfonsoMarquez.PruebaTecnica4.DTO.FlightDTO;
import com.AlfonsoMarquez.PruebaTecnica4.model.Flight;
import com.AlfonsoMarquez.PruebaTecnica4.model.Plane;

import java.time.LocalDate;
import java.util.List;

public interface IFlightService {

    public List<Flight> getFlights();
    public void saveFlight(FlightDTO flightDTO) throws Exception;
    public void deleteFlight(String code);
    public Flight findFlight(String code);
    public void savePlane(Plane plane) throws Exception;
    public List<FlightDTO> findFlightsWithDate(LocalDate dateFrom, LocalDate dateTo, String origin, String destination);

}

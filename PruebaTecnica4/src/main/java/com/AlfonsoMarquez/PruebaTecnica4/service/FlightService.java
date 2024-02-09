package com.AlfonsoMarquez.PruebaTecnica4.service;

import com.AlfonsoMarquez.PruebaTecnica4.model.Flight;
import com.AlfonsoMarquez.PruebaTecnica4.repository.IFlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class FlightService implements IFlightService{

    @Autowired
    private IFlightRepository flightRepository;


    @Override
    public List<Flight> getFlights() {
        return new ArrayList<>(flightRepository.findAll());
    }

    @Override
    public void saveFlights(Flight flight) {

        flightRepository.save(flight);
    }

    @Override
    public void deleteFlight(String code) {

        flightRepository.deleteById(code);
    }

    @Override
    public Flight findFlight(String code) {
        return flightRepository.findById(code).orElse(null);
    }
}
package com.AlfonsoMarquez.PruebaTecnica4.service;

import com.AlfonsoMarquez.PruebaTecnica4.DTO.FlightDTO;
import com.AlfonsoMarquez.PruebaTecnica4.model.Flight;
import com.AlfonsoMarquez.PruebaTecnica4.model.Plane;
import com.AlfonsoMarquez.PruebaTecnica4.repository.IFlightRepository;
import com.AlfonsoMarquez.PruebaTecnica4.repository.IPlaneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FlightService implements IFlightService{

    @Autowired
    private IFlightRepository flightRepository;
    @Autowired
    private IPlaneRepository planeRepository;


    @Override
    public List<Flight> getFlights() {
        return new ArrayList<>(flightRepository.findAll());
    }

    @Override
    public void saveFlight(FlightDTO flightDTO) throws Exception {
        if(planeRepository.findById(flightDTO.getPlaneId()).isPresent())
        {
            Flight flight = new Flight(flightDTO.getOrigin(), flightDTO.getDestination(),
                    flightDTO.getSeatType(), flightDTO.getPricePerPerson(),
                    flightDTO.getDepartureDate());
            flight.setPlane(planeRepository.findByPlaneId(flightDTO.getPlaneId()));
            flight.setCapacity(flight.getPlane().getCapacity());
            flightRepository.save(flight);
        }else{
            throw new Exception("No existe el avion para el que quiere guardar un vuelo");
        }



    }

    @Override
    public void deleteFlight(String code) {

        flightRepository.deleteById(code);
    }

    @Override
    public Flight findFlight(String code) {
        return flightRepository.findById(code).orElse(null);
    }

    @Override
    public void savePlane(Plane plane) throws Exception
    {
        if(plane.getCapacity()<(plane.getTouristCapacity()+plane.getBusinessCapacity()))
        {
            throw new Exception("La suma de asientos de turista y business excede la capacidad del avion");
        }
        planeRepository.save(plane);
    }

    @Override
    public List<FlightDTO> findFlightsWithDate(LocalDate dateFrom, LocalDate dateTo, String origin, String destination)
    {
        List<FlightDTO> availableFlights = flightRepository.findAll().stream()
                .filter(flight -> flight.getDepartureDate().isAfter(dateFrom.minusDays(1)) && flight.getDepartureDate().isBefore(dateTo.plusDays(1)))
                .filter(flight -> flight.getOrigin().equalsIgnoreCase(origin))
                .filter(flight -> flight.getDestination().equalsIgnoreCase(destination))
                .map(FlightDTO::new)
                .collect(Collectors.toList());

        return availableFlights;
    }
}
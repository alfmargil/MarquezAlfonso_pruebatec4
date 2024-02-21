package com.AlfonsoMarquez.PruebaTecnica4.service;

import com.AlfonsoMarquez.PruebaTecnica4.DTO.FlightDTO;
import com.AlfonsoMarquez.PruebaTecnica4.model.Flight;
import com.AlfonsoMarquez.PruebaTecnica4.model.FlightBooking;
import com.AlfonsoMarquez.PruebaTecnica4.model.Plane;
import com.AlfonsoMarquez.PruebaTecnica4.repository.IFlightBookingRepository;
import com.AlfonsoMarquez.PruebaTecnica4.repository.IFlightRepository;
import com.AlfonsoMarquez.PruebaTecnica4.repository.IPlaneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FlightService implements IFlightService{

    @Autowired
    private IFlightRepository flightRepository;
    @Autowired
    private IPlaneRepository planeRepository;
    @Autowired
    private IFlightBookingRepository flightBookingRepository;


    @Override
    public List<Flight> getFlights() {
        return new ArrayList<>(flightRepository.findAll());
    }

    @Override
    public void saveFlight(FlightDTO flightDTO) throws Exception {

        Plane plane = planeRepository.findByPlaneId(flightDTO.getPlaneId());
        boolean isAvailable = flightRepository.countByPlaneAndDepartureDate(plane, flightDTO.getDepartureDate()) == 0;
        if(!isAvailable)
        {
            throw new Exception("El avion ya tiene un vuelo en esa fecha");
        }

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

    // Elimina un vuelo y sus reservas
    @Override
    public void deleteFlight(String code) {
        Flight flight = flightRepository.getReferenceById(code);
        List<FlightBooking> bookings = flightBookingRepository.findByFlightFlightCode(code);
        for(FlightBooking booking : bookings)
        {
                flightBookingRepository.delete(booking);
        }
        flightRepository.deleteById(code);
    }

    @Override
    public Flight findFlight(String code)throws Exception{

        Flight flight = flightRepository.findById(code).orElse(null);

        if(flight==null)
        {
            throw new Exception("El vuelo no existe");
        }else {
            return flight;
        }

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

    //Este es el metodo que hay que usar para borrar, ya que comprueba que no haya reservas. El otro borrar es un borrado bruto

    @Override
    public void safeDeleteFlight(String code) throws Exception {
        Flight flight = flightRepository.getReferenceById(code);
        List<FlightBooking> bookings = flightBookingRepository.findByFlightFlightCode(code);
        if(!bookings.isEmpty())
        {
            throw new Exception("No se puede borrar el vuelo porque tiene reservas");
        }
        flightRepository.deleteById(code);
    }

    @Override
    public List<Plane> getPlanes() {
        return planeRepository.findAll();
    }
}
package com.AlfonsoMarquez.PruebaTecnica4.service;

import com.AlfonsoMarquez.PruebaTecnica4.DTO.FlightBookingDTO;
import com.AlfonsoMarquez.PruebaTecnica4.model.Flight;
import com.AlfonsoMarquez.PruebaTecnica4.model.FlightBooking;
import com.AlfonsoMarquez.PruebaTecnica4.model.Person;
import com.AlfonsoMarquez.PruebaTecnica4.repository.IFlightBookingRepository;
import com.AlfonsoMarquez.PruebaTecnica4.repository.IFlightRepository;
import com.AlfonsoMarquez.PruebaTecnica4.repository.IPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightBookingService implements IFlightBookingService {

    @Autowired
    private IFlightRepository flightRepository;
    @Autowired
    private IFlightBookingRepository flightBookingRepository;
    @Autowired
    private IPersonRepository personRepository;

    @Override
    public List<FlightBooking> getFlightBookings() {
        return null;
    }

    @Override
    public double saveFlightBooking(FlightBookingDTO flightBookingDTO) throws Exception {

        FlightBooking existingBooking = flightBookingRepository.findByFlightCodeAndDepartureDateAndPassengers(
                flightBookingDTO.getFlightCode(),
                flightBookingDTO.getDepartureDate(),
                flightBookingDTO.getPassengers());
        if (existingBooking != null) {
            throw new Exception("Ya existe una reserva de vuelo con los mismos datos");
        }


        if (flightBookingDTO.getPassengers().size() > flightRepository.findById(flightBookingDTO.getFlightCode()).get().getCapacity())
        {
            throw new Exception("No quedan suficientes plazas en el vuelo");
        }

        FlightBooking flightBooking = new FlightBooking();
        flightBooking.setOrigin(flightBookingDTO.getOrigin());
        flightBooking.setDestination(flightBookingDTO.getDestination());
        flightBooking.setPeopleQ(flightBookingDTO.getPassengers().size());
        flightBooking.setDepartureDate(flightBookingDTO.getDepartureDate());
        flightBooking.setSeatType(flightBookingDTO.getSeatType());
        flightBooking.setFlight(flightRepository.findByFlightCode(flightBookingDTO.getFlightCode()));
        flightBooking.setPassengers(flightBookingDTO.getPassengers());
        for(Person person : flightBooking.getPassengers())
        {
            personRepository.save(person);
        }
        int capacity = flightRepository.findByFlightCode(flightBookingDTO.getFlightCode()).getCapacity();
        double price = flightRepository.findByFlightCode(flightBookingDTO.getFlightCode()).getPricePerPerson();
        flightRepository.findByFlightCode(flightBookingDTO.getFlightCode()).setCapacity(capacity-flightBookingDTO.getPassengers().size());
        flightBookingRepository.save(flightBooking);
        return flightBooking.getPeopleQ()*price;
    }

    @Override
    public void deleteFlightBooking(Long id) {
    }

    @Override
    public Flight findFlightBooking(Long id) {
        return null;
    }
}

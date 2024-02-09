package com.AlfonsoMarquez.PruebaTecnica4.service;

import com.AlfonsoMarquez.PruebaTecnica4.model.RoomBooking;
import com.AlfonsoMarquez.PruebaTecnica4.repository.IBookingRepository;
import com.AlfonsoMarquez.PruebaTecnica4.repository.IHotelRepository;
import com.AlfonsoMarquez.PruebaTecnica4.repository.IPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService implements IBookingService {

    @Autowired
    private IBookingRepository bookingRepository;
    @Autowired
    private IPersonRepository personRepository;
    @Autowired
    private IHotelRepository hotelRepository;

    @Override
    public List<RoomBooking> getBookings() {
        return bookingRepository.findAll();
    }

    @Override
    public double makeBooking(RoomBooking roomBooking) {

    }

    @Override
    public void deleteBooking(Long id) {
    }

    @Override
    public RoomBooking findBooking(Long id) {
        return null;
    }
}

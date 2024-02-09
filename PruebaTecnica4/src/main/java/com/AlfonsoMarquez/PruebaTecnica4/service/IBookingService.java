package com.AlfonsoMarquez.PruebaTecnica4.service;

import com.AlfonsoMarquez.PruebaTecnica4.model.RoomBooking;

import java.util.List;

public interface IBookingService {

    public List<RoomBooking> getBookings();
    public double makeBooking(RoomBooking roomBooking);
    public void deleteBooking(Long id);
    public RoomBooking findBooking(Long id);

}

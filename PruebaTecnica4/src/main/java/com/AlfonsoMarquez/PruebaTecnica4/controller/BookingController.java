package com.AlfonsoMarquez.PruebaTecnica4.controller;

import com.AlfonsoMarquez.PruebaTecnica4.model.RoomBooking;
import com.AlfonsoMarquez.PruebaTecnica4.service.BookingService;
import com.AlfonsoMarquez.PruebaTecnica4.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/agency/hotel-booking")
public class BookingController {

    @Autowired
    private BookingService bookingService;
    @Autowired
    private HotelService hotelService;

    @PostMapping("/new")
    public double newBooking(@RequestBody RoomBooking roomBooking)
    {
        return bookingService.makeBooking(roomBooking);
    }

}

package com.AlfonsoMarquez.PruebaTecnica4.controller;

import com.AlfonsoMarquez.PruebaTecnica4.DTO.FlightBookingDTO;
import com.AlfonsoMarquez.PruebaTecnica4.DTO.RoomBookingDTO;
import com.AlfonsoMarquez.PruebaTecnica4.service.IFlightBookingService;
import com.AlfonsoMarquez.PruebaTecnica4.service.IRoomBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookingController {

    @Autowired
    private IRoomBookingService roomBookingService;
    @Autowired
    private IFlightBookingService flightBookingService;

    @PostMapping("/agency/hotel-booking/new")
    public ResponseEntity<?> roomBooking(@RequestBody RoomBookingDTO request)
    {
        double totalAmount = 0;
        try {
            totalAmount = roomBookingService.saveRoomBooking(request);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body(e.getMessage());
        }
        if (totalAmount != 0) {
            return new ResponseEntity<>(totalAmount, HttpStatus.OK);
        } else
            return new ResponseEntity<>(totalAmount, HttpStatus.CONFLICT);

    }

    @PostMapping("/agency/flight-booking/new")
    public ResponseEntity<?> flightBooking(@RequestBody FlightBookingDTO request)
    {
        double totalAmount = 0;
        try {
            totalAmount = flightBookingService.saveFlightBooking(request);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body(e.getMessage());
        }
        if (totalAmount != 0) {
            return new ResponseEntity<>(totalAmount, HttpStatus.OK);
        } else
            return new ResponseEntity<>(totalAmount, HttpStatus.CONFLICT);
    }
}

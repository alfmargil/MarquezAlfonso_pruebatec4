package com.AlfonsoMarquez.PruebaTecnica4.controller;

import com.AlfonsoMarquez.PruebaTecnica4.DTO.HotelDTO;
import com.AlfonsoMarquez.PruebaTecnica4.DTO.RoomDTO;
import com.AlfonsoMarquez.PruebaTecnica4.model.Hotel;
import com.AlfonsoMarquez.PruebaTecnica4.service.IHotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/agency/hotels")
public class HotelController {

    @Autowired
    private IHotelService hotelService;

    @PostMapping("/new")
    public void loadHotels(@RequestBody List<Hotel> hotels)
    {
        for (Hotel hotel : hotels) {
            hotelService.saveHotelWithRooms(hotel);
        }
    }

    @GetMapping("/listAll")
    public List<Hotel> getHotels() {
        return hotelService.getHotels();
    }

    @GetMapping()
    public ResponseEntity<List<RoomDTO>> getAvailableRooms(
            @RequestParam("dateFrom") @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate dateFrom,
            @RequestParam("dateTo") @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate dateTo,
            @RequestParam("destination") String destination) {

        List<RoomDTO> availableRooms = hotelService.findAvailableRooms(dateFrom, dateTo, destination);
        return ResponseEntity.ok(availableRooms);
    }



}

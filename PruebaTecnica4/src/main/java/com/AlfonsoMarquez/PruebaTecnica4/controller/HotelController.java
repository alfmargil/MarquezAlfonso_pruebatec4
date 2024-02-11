package com.AlfonsoMarquez.PruebaTecnica4.controller;

import com.AlfonsoMarquez.PruebaTecnica4.model.Hotel;
import com.AlfonsoMarquez.PruebaTecnica4.service.IHotelService;
import org.springframework.beans.factory.annotation.Autowired;
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


}

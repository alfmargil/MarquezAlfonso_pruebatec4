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

    @PostMapping("/loadHotels")
    public void loadHotelBatch(@RequestBody List<Hotel> hotels)
    {
        for (Hotel hotel : hotels) {
            hotelService.saveHotel(hotel);
        }
    }

    @GetMapping("/listAll")
    public List<Hotel> getHotels() {
        return hotelService.getHotels();

    }

    @GetMapping("")
    public List<Hotel> getAvailableHotels(
            @RequestParam("dateFrom") String dateFrom,
            @RequestParam("dateTo") String dateTo,
            @RequestParam("destination") String place)
    {
        LocalDate fromDate = LocalDate.parse(dateFrom);
        LocalDate toDate = LocalDate.parse(dateTo);
        return hotelService.findAvailableHotels(fromDate, toDate, place);

    }
}

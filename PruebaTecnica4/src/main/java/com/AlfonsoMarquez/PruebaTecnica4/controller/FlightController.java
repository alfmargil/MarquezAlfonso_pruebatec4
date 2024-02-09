package com.AlfonsoMarquez.PruebaTecnica4.controller;

import com.AlfonsoMarquez.PruebaTecnica4.model.Flight;
import com.AlfonsoMarquez.PruebaTecnica4.model.Hotel;
import com.AlfonsoMarquez.PruebaTecnica4.service.IFlightService;
import com.AlfonsoMarquez.PruebaTecnica4.service.IHotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agency/flights")
public class FlightController {

    @Autowired
    private IFlightService flightService;


    @PostMapping("/loadFlights")
    public void loadFlightBatch(@RequestBody List<Flight> flights)
    {
        for(Flight flight : flights)
        {
            flightService.saveFlights(flight);
        }
    }

    @GetMapping("")
    public List<Flight> getFlights(){

        return flightService.getFlights();

    }


}

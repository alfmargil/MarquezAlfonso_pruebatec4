package com.AlfonsoMarquez.PruebaTecnica4.controller;

import com.AlfonsoMarquez.PruebaTecnica4.DTO.FlightDTO;
import com.AlfonsoMarquez.PruebaTecnica4.model.Flight;
import com.AlfonsoMarquez.PruebaTecnica4.model.Hotel;
import com.AlfonsoMarquez.PruebaTecnica4.model.Plane;
import com.AlfonsoMarquez.PruebaTecnica4.repository.IPlaneRepository;
import com.AlfonsoMarquez.PruebaTecnica4.service.IFlightService;
import com.AlfonsoMarquez.PruebaTecnica4.service.IHotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/agency/flights")
public class FlightController {

    @Autowired
    private IFlightService flightService;



    @PostMapping("/loadFlights")
    public void loadFlightBatch(@RequestBody List<Flight> flights)
    {
       /* for(Flight flight : flights)
        {
            try {
                flightService.saveFlight(flight);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }*/
    }

    @GetMapping("")
    public List<Flight> getFlights(){

        return flightService.getFlights();

    }

    @PostMapping("/newPlane")
    public ResponseEntity<String> savePlane(@RequestBody Plane plane)
    {
        try {
            flightService.savePlane(plane);
            return new ResponseEntity<>("Avion guardado correctamente", HttpStatus.CREATED);
        }catch (Exception e)
        {
            return new ResponseEntity<>("Error al guardar el avion: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/new")
    public ResponseEntity<String> saveFlight(@RequestBody FlightDTO flightDTO)
    {
        try{
            flightService.saveFlight(flightDTO);
            return new ResponseEntity<>("Vuelo guardado correctamente", HttpStatus.CREATED);
        }catch (Exception e)
        {
            return new ResponseEntity<>("Error al guardar el vuelo: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/filter")
    public ResponseEntity<List<FlightDTO>> getFlightsWithDate(
            @RequestParam("dateFrom") @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate dateFrom,
            @RequestParam("dateTo") @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate dateTo,
            @RequestParam("origin") String origin,
            @RequestParam("destination") String destination)
    {

        List<FlightDTO> availableFlights = flightService.findFlightsWithDate(dateFrom,dateTo,origin,destination);
        return ResponseEntity.ok(availableFlights);
    }


}

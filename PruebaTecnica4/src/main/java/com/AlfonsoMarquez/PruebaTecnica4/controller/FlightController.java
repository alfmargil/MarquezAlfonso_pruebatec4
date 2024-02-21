package com.AlfonsoMarquez.PruebaTecnica4.controller;

import com.AlfonsoMarquez.PruebaTecnica4.DTO.FlightDTO;
import com.AlfonsoMarquez.PruebaTecnica4.model.Flight;
import com.AlfonsoMarquez.PruebaTecnica4.model.Plane;
import com.AlfonsoMarquez.PruebaTecnica4.service.IFlightService;
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
    public List<Flight> getFlights() {
        return flightService.getFlights();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getFlightById(@PathVariable String id) {
        try {
            Flight flight = flightService.findFlight(id);
            return ResponseEntity.ok(flight);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/newPlane")
    public ResponseEntity<String> savePlane(@RequestBody Plane plane)
    {
        try {
            flightService.savePlane(plane);
            return new ResponseEntity<>("Avion guardado correctamente", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al guardar el avion: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/new")
    public ResponseEntity<String> saveFlight(@RequestBody FlightDTO flightDTO)
    {
        try {
            flightService.saveFlight(flightDTO);
            return new ResponseEntity<>("Vuelo guardado correctamente", HttpStatus.CREATED);
        } catch (Exception e) {
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
        List<FlightDTO> availableFlights = flightService.findFlightsWithDate(dateFrom, dateTo, origin, destination);
        return ResponseEntity.ok(availableFlights);
    }
    // He añadido la opcion de poder cambiar un vuelo de avion de forma opcional

    @PutMapping("/edit/{id}")
    public ResponseEntity<String> updateFlight(@PathVariable String id, @RequestParam String origin,
                                               @RequestParam String destination, @RequestParam Double pricePerPerson,
                                               @RequestParam String seatType,
                                               @RequestParam @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate departureDate,
                                               @RequestParam(required = false) Long planeId)
    {
        Flight flight = null;
        try {
            FlightDTO flightDTO = new FlightDTO();
            flightDTO.setPlaneId(flightService.findFlight(id).getPlane().getPlaneId());
            flightDTO.setOrigin(origin);
            flightDTO.setDestination(destination);
            flightDTO.setDepartureDate(departureDate);
            flightDTO.setPricePerPerson(pricePerPerson);
            flightDTO.setSeatType(seatType);
            if (planeId != null) {
                flightDTO.setPlaneId(planeId);
            }
            try {
                flightService.saveFlight(flightDTO);
                if (flightDTO.getFlightCode() != id) {
                    flightService.deleteFlight(id);
                }
                return new ResponseEntity<>("Vuelo actualizado correctamente", HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>("Error al actualizar el vuelo: " + e.getMessage(), HttpStatus.NOT_FOUND);
            }

        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteFlight(@PathVariable String id)
    {
        try {
            flightService.safeDeleteFlight(id);
            return new ResponseEntity<>("Vuelo borrado correctamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al borrar el vuelo: " + e.getMessage(), HttpStatus.NOT_FOUND);

        }
    }

    @GetMapping("/planes")
    public List<Plane> getPlanes()
    {
        return flightService.getPlanes();
    }

}

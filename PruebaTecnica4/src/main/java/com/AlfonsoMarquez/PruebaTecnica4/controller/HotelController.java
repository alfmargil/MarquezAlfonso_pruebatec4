package com.AlfonsoMarquez.PruebaTecnica4.controller;

import com.AlfonsoMarquez.PruebaTecnica4.DTO.HotelDTO;
import com.AlfonsoMarquez.PruebaTecnica4.DTO.RoomDTO;
import com.AlfonsoMarquez.PruebaTecnica4.model.Hotel;
import com.AlfonsoMarquez.PruebaTecnica4.service.IHotelService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<String> newHotel(@RequestBody HotelDTO hotelDTO)
    {
        hotelService.saveHotelDTO(hotelDTO);
        return new ResponseEntity<>("Hotel guardado correctamente",HttpStatus.OK);
    }

    @PostMapping("/newList")
    public ResponseEntity<String> loadHotels(@RequestBody List<Hotel> hotels)
    {
        try{
        for (Hotel hotel : hotels) {
            hotelService.saveHotelWithRooms(hotel);
        }
                return new ResponseEntity<>("Hoteles y habitaciones guardados correctamente",HttpStatus.OK);
            } catch (Exception e){
                return new ResponseEntity<>("Error: "+e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
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
            @RequestParam("destination") String destination)
    {
        List<RoomDTO> availableRooms = hotelService.findAvailableRooms(dateFrom, dateTo, destination);
        return ResponseEntity.ok(availableRooms);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<String> updateHotel(@PathVariable String id, @RequestParam String nombre, @RequestParam String place)
    {
        Hotel hotel = hotelService.findHotel(id);
        if (hotel == null) {
            return new ResponseEntity<>("No se encontró el Hotel a editar", HttpStatus.NOT_FOUND);
        } else {
            hotel.setName(nombre);
            hotel.setPlace(place);
            hotelService.saveHotel(hotel);
            return new ResponseEntity<>("Hotel editado correctamente", HttpStatus.OK);

        }

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteHotel(@PathVariable String id)
    {
        Hotel hotel = hotelService.findHotel(id);
        if(hotel == null)
        {
            return new ResponseEntity<>("No se encontró el Hotel a eliminar", HttpStatus.NOT_FOUND);
        } else {
            try {
                hotelService.deleteHotel(id);
                return new ResponseEntity<>("Hotel eliminado correctamente",HttpStatus.OK);

            } catch (Exception e) {
                return new ResponseEntity<>("Error al eliminar el hotel: "+e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getHotel(@PathVariable String id)
    {
        Hotel hotel = hotelService.findHotel(id);
        if(hotel == null)
        {
            return new ResponseEntity<>("Error, Hotel no encontrado", HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(hotel);
    }


}

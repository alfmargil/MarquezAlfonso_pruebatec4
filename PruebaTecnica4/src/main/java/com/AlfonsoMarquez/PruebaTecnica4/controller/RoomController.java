package com.AlfonsoMarquez.PruebaTecnica4.controller;

import com.AlfonsoMarquez.PruebaTecnica4.DTO.RoomDTO;
import com.AlfonsoMarquez.PruebaTecnica4.model.Hotel;
import com.AlfonsoMarquez.PruebaTecnica4.model.Room;
import com.AlfonsoMarquez.PruebaTecnica4.service.IRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agency/rooms")
public class RoomController {

    @Autowired
    private IRoomService roomService;

    @GetMapping()
    public List<Room> getRooms(){
        return roomService.getRooms();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getRoom(@PathVariable String id)
    {
        Room room = roomService.findRoom(id);
        if(room == null)
        {
            return new ResponseEntity<>("Error, Hotel no encontrado", HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(room);
    }

    @PostMapping("/new")
    public ResponseEntity<String> newRoom(@RequestBody RoomDTO roomDTO)
    {
        try {
            roomService.saveRoom(roomDTO);
            return new ResponseEntity<>("Habitacion guardada correctamente",HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error: " + e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }


}

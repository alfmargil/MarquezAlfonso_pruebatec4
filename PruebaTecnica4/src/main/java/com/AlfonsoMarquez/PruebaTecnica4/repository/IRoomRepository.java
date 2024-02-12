package com.AlfonsoMarquez.PruebaTecnica4.repository;

import com.AlfonsoMarquez.PruebaTecnica4.model.Hotel;
import com.AlfonsoMarquez.PruebaTecnica4.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IRoomRepository extends JpaRepository<Room,String> {

    public List<Room> findByHotel(Hotel hotel);
    public Room findByRoomId(String roomId);
}

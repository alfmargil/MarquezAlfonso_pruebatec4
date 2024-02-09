package com.AlfonsoMarquez.PruebaTecnica4.repository;

import com.AlfonsoMarquez.PruebaTecnica4.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface IHotelRepository extends JpaRepository<Hotel,String> {

    @Query("SELECT h FROM Hotel h WHERE h.destination = :destination " +
            "AND h.availableFrom <= :toDate AND h.availableTo >= :fromDate")
    List<Hotel> findAvailableHotels(
            @Param("fromDate") LocalDate fromDate,
            @Param("toDate") LocalDate toDate,
            @Param("destination") String destination);
}



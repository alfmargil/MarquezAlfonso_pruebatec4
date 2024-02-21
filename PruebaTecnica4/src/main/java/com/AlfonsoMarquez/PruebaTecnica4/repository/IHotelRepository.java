package com.AlfonsoMarquez.PruebaTecnica4.repository;

import com.AlfonsoMarquez.PruebaTecnica4.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IHotelRepository extends JpaRepository<Hotel,String> {

    public List<Hotel> findByPlace(String place);
    public long countByName(String name);
    public long countByPlace(String place);

}



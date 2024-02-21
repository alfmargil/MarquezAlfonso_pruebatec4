package com.AlfonsoMarquez.PruebaTecnica4.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Hotel {

    @Id
    private String hotelCode;
    private String name;
    private String place;
    @OneToMany(mappedBy = "hotel")
    private List<Room> rooms;




}

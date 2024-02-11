package com.AlfonsoMarquez.PruebaTecnica4.model;

import com.AlfonsoMarquez.PruebaTecnica4.util.BooleanDeserializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Room {

    @Id
    private String roomId;
    private Long roomNumber;
    private String roomType;
    private Double nightPrice;
    @ManyToOne
    @JoinColumn(name = "hotel_code")
    @JsonIgnore
    private Hotel hotel;
    @OneToMany(mappedBy = "room",cascade = CascadeType.ALL)
    private List<RoomBooking> roomBookings;



}

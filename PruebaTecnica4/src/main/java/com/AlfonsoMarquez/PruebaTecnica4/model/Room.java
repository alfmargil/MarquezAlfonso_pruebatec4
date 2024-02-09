package com.AlfonsoMarquez.PruebaTecnica4.model;

import com.AlfonsoMarquez.PruebaTecnica4.util.BooleanDeserializer;
import com.fasterxml.jackson.annotation.JsonFormat;
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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long roomId;
    private String roomType;
    private Double nightPrice;
    @ManyToOne
    private Hotel hotel;
    @OneToMany
    private List<RoomBooking> roomBookings;
    /*@JsonDeserialize(using = BooleanDeserializer.class)
    private Boolean available;*/

}

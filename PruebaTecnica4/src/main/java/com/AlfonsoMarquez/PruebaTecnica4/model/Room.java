package com.AlfonsoMarquez.PruebaTecnica4.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private int roomSize;
    @ManyToOne
    @JoinColumn(name = "hotel_code")
    @JsonIgnore
    private Hotel hotel;
    @OneToMany(mappedBy = "room",cascade = CascadeType.ALL)
    private List<RoomBooking> roomBookings;

    public boolean isAvailable(LocalDate fromDate, LocalDate toDate) {
        for (RoomBooking booking : roomBookings) {
            LocalDate bookingCheckIn = booking.getCheckIn();
            LocalDate bookingCheckOut = booking.getCheckOut();
            if (fromDate.isBefore(bookingCheckOut) && toDate.isAfter(bookingCheckIn)) {
                return false;
            }
        }
        return true;
    }




}

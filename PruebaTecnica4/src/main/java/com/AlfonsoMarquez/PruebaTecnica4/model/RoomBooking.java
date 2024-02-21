package com.AlfonsoMarquez.PruebaTecnica4.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Getter@Setter
@NoArgsConstructor
@Entity
public class RoomBooking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int peopleQ;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate checkIn;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate checkOut;
    private Long nights;
    @ManyToOne
    @JoinColumn(name = "room_id")
    @JsonIgnore
    private Room room;
    @ManyToMany
    @JoinTable(
            name = "Booking_Hosts",
            joinColumns = @JoinColumn(name = "booking_id"),
            inverseJoinColumns = @JoinColumn(name = "person_id")
    )
    private List<Person> hosts;

    public RoomBooking(int peopleQ, LocalDate checkIn, LocalDate checkOut, Room room, List<Person> hosts) {
        this.peopleQ = peopleQ;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.nights = ChronoUnit.DAYS.between(checkIn, checkOut);
        this.room = room;
        this.hosts = hosts;
    }

    public void setNights() {
        this.nights = ChronoUnit.DAYS.between(checkIn, checkOut);
    }
}

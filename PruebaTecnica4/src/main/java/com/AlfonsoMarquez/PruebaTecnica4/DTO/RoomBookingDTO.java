package com.AlfonsoMarquez.PruebaTecnica4.DTO;

import com.AlfonsoMarquez.PruebaTecnica4.model.Person;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RoomBookingDTO {

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate checkIn;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate checkOut;
    private String roomId;
    private List<Person> hosts;


}

package com.AlfonsoMarquez.PruebaTecnica4.DTO;

import com.AlfonsoMarquez.PruebaTecnica4.model.Room;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HotelDTO {

    private String hotelCode;
    private String name;
    private String place;

}

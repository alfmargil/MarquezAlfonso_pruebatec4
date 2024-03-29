package com.AlfonsoMarquez.PruebaTecnica4.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RoomDTO {

    
    private int roomSize;
    private Long roomNumber;
    private String roomType;
    private Double nightPrice;
    private String hotelCode;

}

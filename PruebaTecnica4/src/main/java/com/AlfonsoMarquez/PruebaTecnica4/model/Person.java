package com.AlfonsoMarquez.PruebaTecnica4.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Person {

    @Id
    private Long id;
    @Size(min=2, max=30)
    private String name;
    @Email@NotEmpty
    private String email;
    @ManyToMany(mappedBy = "hosts")
    @JsonIgnore
    private List<RoomBooking> roomBookings;

}

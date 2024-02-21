package com.AlfonsoMarquez.PruebaTecnica4;

import com.AlfonsoMarquez.PruebaTecnica4.model.Hotel;
import com.AlfonsoMarquez.PruebaTecnica4.repository.IHotelRepository;
import com.AlfonsoMarquez.PruebaTecnica4.service.HotelService;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

public class FlightTest {


    @Mock
    private IHotelRepository hotelRepository;

    @InjectMocks
    private HotelService hotelService;
    private List<Hotel> mockList;

    @BeforeEach
    void setUp()
    {
        MockitoAnnotations.openMocks(this);
        mockList = new ArrayList<>();
    }


}

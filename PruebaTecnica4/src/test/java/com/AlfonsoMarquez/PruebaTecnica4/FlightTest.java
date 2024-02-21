package com.AlfonsoMarquez.PruebaTecnica4;

import com.AlfonsoMarquez.PruebaTecnica4.model.Flight;
import com.AlfonsoMarquez.PruebaTecnica4.repository.IFlightRepository;
import com.AlfonsoMarquez.PruebaTecnica4.service.FlightService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

public class FlightTest {


    @Mock
    private IFlightRepository flightRepository;

    @InjectMocks
    private FlightService flightService;
    private List<Flight> mockList;

    @BeforeEach
    void setUp()
    {
        MockitoAnnotations.openMocks(this);
        mockList = new ArrayList<>();
    }

    @Test
    public void getFlights()
    {
        
    }



}

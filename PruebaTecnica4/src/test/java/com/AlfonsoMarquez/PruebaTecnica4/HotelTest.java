package com.AlfonsoMarquez.PruebaTecnica4;

import com.AlfonsoMarquez.PruebaTecnica4.model.Hotel;
import com.AlfonsoMarquez.PruebaTecnica4.repository.IHotelRepository;
import com.AlfonsoMarquez.PruebaTecnica4.service.HotelService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

public class HotelTest {

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

    @Test
    public void getHotels(){
        mockList.add(new Hotel("SEV-001","Alfonso XIII","Sevilla",null));
        mockList.add(new Hotel("HUE-003","SENATOR","Huelva",null));
        when(hotelRepository.findAll()).thenReturn(mockList);

        List<Hotel> hotelList = hotelRepository.findAll();
        assertTrue(hotelList != null && !hotelList.isEmpty());

    }

}

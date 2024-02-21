package com.AlfonsoMarquez.PruebaTecnica4;

import com.AlfonsoMarquez.PruebaTecnica4.DTO.FlightDTO;
import com.AlfonsoMarquez.PruebaTecnica4.model.Plane;
import com.AlfonsoMarquez.PruebaTecnica4.repository.IFlightRepository;
import com.AlfonsoMarquez.PruebaTecnica4.repository.IPlaneRepository;
import com.AlfonsoMarquez.PruebaTecnica4.service.FlightService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

public class FlightServiceTest {

    @InjectMocks
    private FlightService flightService;

    @Mock
    private IPlaneRepository planeRepository;

    @Mock
    private IFlightRepository flightRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSaveFlight() throws Exception {
        // Arrange
        FlightDTO flightDTO = new FlightDTO();
        flightDTO.setPlaneId(1L);
        flightDTO.setDepartureDate(LocalDate.now());
        // Mock del comportamiento del repositorio de aviones
        when(planeRepository.findById(1L)).thenReturn(Optional.empty()); // Configurar para que devuelva un Optional vacío

        // Act & Assert
        assertThrows(Exception.class, () -> {
            flightService.saveFlight(flightDTO);
        });
    }


    @Test
    public void testSaveFlight_PlaneAlreadyHasFlightOnDate() {
        // Arrange
        FlightDTO flightDTO = new FlightDTO();
        flightDTO.setPlaneId(1L);
        flightDTO.setDepartureDate(LocalDate.now());
        // Mock del comportamiento del repositorio de aviones
        when(planeRepository.findByPlaneId(1L)).thenReturn(new Plane());
        when(flightRepository.countByPlaneAndDepartureDate(any(Plane.class), any(LocalDate.class))).thenReturn(1);

        // Act & Assert
        assertThrows(Exception.class, () -> {
            flightService.saveFlight(flightDTO);
        });
    }

    @Test
    public void testSaveFlight_PlaneDoesNotExist() {
        // Arrange
        FlightDTO flightDTO = new FlightDTO();
        flightDTO.setPlaneId(1L);
        // Mock del comportamiento del repositorio de aviones
        when(planeRepository.findById(1L)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(Exception.class, () -> {
            flightService.saveFlight(flightDTO);
        });
    }
}

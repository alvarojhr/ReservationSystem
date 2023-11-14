package service;
<<<<<<< HEAD
import dao.ConferenceRoomDao;
import model.ConferenceRoom;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ReservationSystemTest {

    @Test
    void testReserveRoom() {
        // Crear mock de ConferenceRoomDao
        ConferenceRoomDao roomDaoMock = mock(ConferenceRoomDao.class);

        // Crear instancia de ReservationSystem con el mock de ConferenceRoomDao
        ReservationSystem reservationSystem = new ReservationSystem(roomDaoMock);

        // Definir el ID de la sala a reservar
        String roomId = "101";

        // Simular que la sala no está reservada
        when(roomDaoMock.getRoomById(roomId)).thenReturn(new ConferenceRoom(roomId, 10));
        when(roomDaoMock.updateRoom(any(ConferenceRoom.class))).thenReturn(true);

        // Probar el método reserveRoom
        boolean result = reservationSystem.reserveRoom(roomId);

        // Verificar que el método getRoomById fue llamado con el ID correcto
        verify(roomDaoMock).getRoomById(roomId);

        // Verificar que el método updateRoom fue llamado con una instancia de ConferenceRoom
        verify(roomDaoMock).updateRoom(any(ConferenceRoom.class));

        // Assert del resultado
        assertTrue(result);
    }

    @Test
    void testCancelReservation() {
        // Crear mock de ConferenceRoomDao
        ConferenceRoomDao roomDaoMock = mock(ConferenceRoomDao.class);

        // Crear instancia de ReservationSystem con el mock de ConferenceRoomDao
        ReservationSystem reservationSystem = new ReservationSystem(roomDaoMock);

        // Definir el ID de la sala a cancelar la reserva
        String roomId = "102";

        // Simular que la sala está reservada
        when(roomDaoMock.getRoomById(roomId)).thenReturn(new ConferenceRoom(roomId, 20));
        when(roomDaoMock.updateRoom(any(ConferenceRoom.class))).thenReturn(true);

        // Probar el método cancelReservation
        boolean result = reservationSystem.cancelReservation(roomId);

        // Verificar que el método getRoomById fue llamado con el ID correcto
        verify(roomDaoMock).getRoomById(roomId);

        // Verificar que el método updateRoom fue llamado con una instancia de ConferenceRoom
        verify(roomDaoMock).updateRoom(any(ConferenceRoom.class));

        // Assert del resultado
        assertTrue(result);
        
    }
}
=======

import model.ConferenceRoom;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ReservationSystemTest {

    private ReservationSystem system;

    @BeforeEach
    public void setUp() {
        //system = new ReservationSystem();
    }

    @Test
    public void testReserveRoom() {
        // Implementar pruebas aquí
    }

    @Test
    public void testCancelReservation() {
        // Implementar pruebas aquí
    }

    // Puedes añadir más pruebas según lo consideres necesario
}
>>>>>>> 6c0e657951df74405248f1b06c5f7deafc958ab9

package service;

import dao.ConferenceRoomDao;
import model.ConferenceRoom;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

public class ReservationSystemTest {

    private ReservationSystem system;
    private ConferenceRoomDao conferenceRoomMock;

    @BeforeEach
    public void setUp() {
        conferenceRoomMock = mock(ConferenceRoomDao.class);
        system = new ReservationSystem(conferenceRoomMock);
    }

    @Test
    public void testReserveRoomIsTrue() {
        ConferenceRoom prueba1 = new ConferenceRoom("Tropical", 50);
        when(conferenceRoomMock.getRoomById("Tropical")).thenReturn(prueba1);
        assertEquals(true, system.reserveRoom("Tropical"));
    // Implementar pruebas aquí
    }

    @Test
    public void testReserveRoomIsFalse(){
        when(conferenceRoomMock.getRoomById("Tropical")).thenReturn(null);
        assertEquals(false,system.reserveRoom("Tropical"));
    }
    
    @Test
    public void testCancelReservationIsTrue() {
        // Implementar pruebas aquí
    ConferenceRoom prueba2 = new ConferenceRoom("Mango", 100);
       when(conferenceRoomMock.getRoomById("Mango")).thenReturn(prueba2);
        assertEquals(true, system.reserveRoom("Mango"));

    }
     @Test
     public void testCancelReservationIsFalse() {
        // Implementar pruebas aquí
       when(conferenceRoomMock.getRoomById("Mango")).thenReturn(null);
        assertEquals(false, system.reserveRoom("Mango"));

    }
    // Puedes añadir más pruebas según lo consideres necesario
}

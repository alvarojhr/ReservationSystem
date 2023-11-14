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
    ConferenceRoom prueba2 = new ConferenceRoom("Pera", 100);
       when(conferenceRoomMock.getRoomById("Pera")).thenReturn(prueba2);
        assertEquals(true, system.reserveRoom("Pera"));

    }
     @Test
     public void testCancelReservationIsFalse() {
        // Implementar pruebas aquí
       when(conferenceRoomMock.getRoomById("Pera")).thenReturn(null);
        assertEquals(false, system.reserveRoom("Pera"));
        
//        @Test
//    public void testCancelReservationWhenIsFalse() {
//        when(conferenceRoomMock.getRoomById("romm3")).thenReturn(null);
//        assertEquals(false, system.cancelReservation("room3"));
//    }
//
//
//    @Test
//    public void testCancelReservationWhenIsTrue() {
//        ConferenceRoom prueba3 = new ConferenceRoom("room4", 5);
//        prueba3.setReserved(true);
//        when(conferenceRoomMock.getRoomById("room4")).thenReturn(prueba3);
//        assertEquals(true, system.cancelReservation("room4"));
    //}
     }
    // Puedes añadir más pruebas según lo consideres necesario
     //holaaa
}

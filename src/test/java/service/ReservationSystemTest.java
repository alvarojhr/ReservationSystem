package service;


import dao.ConferenceRoomDao;
import model.ConferenceRoom;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.when;

import static org.junit.jupiter.api.Assertions.*;


public class ReservationSystemTest {

    private ReservationSystem system;
    private ConferenceRoomDao conferenceRoomMock;

    @BeforeEach
    public void setUp() {

        //aca va el mockito
        conferenceRoomMock = mock(ConferenceRoomDao.class);
        system = new ReservationSystem(conferenceRoomMock);

    }

    @Test
    public void testReserveRoomWhenIsTrue() {
        ConferenceRoom prueba1 = new ConferenceRoom ("Tropical", 58);
        when(conferenceRoomMock.getRoomById("Tropical")).thenReturn(prueba1);
        assertEquals(true,system.reserveRoom("Tropical"));
    }
    @Test
    public void testReserveRoomWhenIsFalse() {
        //ConferenceRoom prueba2 = new ConferenceRoom (null, 0);
        when(conferenceRoomMock.getRoomById("peo")).thenReturn(null);
        assertEquals(false,system.reserveRoom("peo"));
    }
    @Test
    public void testCancelReservationWhenIsFalse() {
        when(conferenceRoomMock.getRoomById("Papaya")).thenReturn(null);
        assertEquals(false,system.cancelReservation("Papaya"));
    }
    @Test
    public void testCancelReservationWhenIsTrue() {
        ConferenceRoom prueba3 = new ConferenceRoom ("Perro", 85);
        prueba3.setReserved(true);
        when(conferenceRoomMock.getRoomById("Perro")).thenReturn(prueba3);
        assertEquals(true,system.cancelReservation("Perro"));
    }

}

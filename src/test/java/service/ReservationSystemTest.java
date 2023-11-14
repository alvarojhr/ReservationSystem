package service;

import dao.ConferenceRoomDao;
import model.ConferenceRoom;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
public class ReservationSystemTest {

    private ReservationSystem system;
    private ConferenceRoomDao conferenceRoomMock;
    @BeforeEach
    public void setUp() {
        conferenceRoomMock = mock(ConferenceRoomDao.class);
        system = new ReservationSystem(conferenceRoomMock);
    }

    @Test
    public void testReserveRoomWhenIsFalse() {
        when(conferenceRoomMock.getRoomById("romm1")).thenReturn(null);
        assertEquals(false, system.reserveRoom("room1"));
    }
    @Test
    public void testReserveRoomWhenIsTrue() {
        ConferenceRoom prueba2 = new ConferenceRoom("room2", 5);
        when(conferenceRoomMock.getRoomById("room2")).thenReturn(prueba2);
        assertEquals(true, system.reserveRoom("room2"));
    }

    @Test
    public void testCancelReservationWhenIsFalse() {
        when(conferenceRoomMock.getRoomById("romm3")).thenReturn(null);
        assertEquals(false, system.cancelReservation("room3"));

    }


    @Test
    public void testCancelReservationWhenIsTrue() {
        ConferenceRoom prueba3 = new ConferenceRoom("room4", 5);
        prueba3.setReserved(true);
        when(conferenceRoomMock.getRoomById("room4")).thenReturn(prueba3);
        assertEquals(true, system.cancelReservation("room4"));


    }

    @Test
    void testGetAvailableRooms() {
        ConferenceRoom room1 = new ConferenceRoom("1", 10);
        ConferenceRoom room2 = new ConferenceRoom("2", 20);
        ConferenceRoom room3 = new ConferenceRoom("3", 20);
        ConferenceRoom room4 = new ConferenceRoom("4", 20);
        room2.setReserved(true);
        room3.setReserved(true);
        when(conferenceRoomMock.getAllRooms()).thenReturn(List.of(room1, room2, room3, room4));

        // Act
        List<ConferenceRoom> availableRooms = system.getAvailableRooms();

        // Assert
        assertEquals(2, availableRooms.size());
        assertEquals(room1, availableRooms.get(0));
        assertEquals(room4, availableRooms.get(1));
    }
}

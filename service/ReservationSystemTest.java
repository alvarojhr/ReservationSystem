package service;

import dao.ConferenceRoomDao;
import java.util.ArrayList;
import java.util.List;
import model.ConferenceRoom;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ReservationSystemTest {

    private ReservationSystem reservationSystem;
    private ConferenceRoomDao roomDaoMock; // Use a mock for testing

    @BeforeEach
    public void setUp() {
        // Create a mock ConferenceRoomDao for testing
        roomDaoMock = mock(ConferenceRoomDao.class);
        // Initialize the ReservationSystem with the mock Dao
        reservationSystem = new ReservationSystem(roomDaoMock);
    }

    @Test
    public void testReserveRoom() {
        // Create a mock conference room
        ConferenceRoom roomMock = mock(ConferenceRoom.class);

        // Stub the behavior of roomDaoMock.getRoomById() to return the mock room
        when(roomDaoMock.getRoomById("roomId")).thenReturn(roomMock);

        // Stub the behavior of roomMock.isReserved() to return false initially
        when(roomMock.isReserved()).thenReturn(false);

        // Attempt to reserve the room
        boolean reservationResult = reservationSystem.reserveRoom("roomId");

        // Assert that the reservation was successful
        assertTrue(reservationResult);

        // Verify that the setReserved() method was called with the correct argument
        verify(roomMock).setReserved(true);
    }

    @Test
    public void testCancelReservation() {
        // Create a mock conference room
        ConferenceRoom roomMock = mock(ConferenceRoom.class);

        // Stub the behavior of roomDaoMock.getRoomById() to return the mock room
        when(roomDaoMock.getRoomById("roomId")).thenReturn(roomMock);

        // Stub the behavior of roomMock.isReserved() to return true initially
        when(roomMock.isReserved()).thenReturn(true);

        // Attempt to cancel the reservation
        boolean cancellationResult = reservationSystem.cancelReservation("roomId");

        // Assert that the cancellation was successful
        assertTrue(cancellationResult);

        // Verify that the setReserved() method was called with the correct argument
        verify(roomMock).setReserved(false);
    }

    @Test
    public void testGetAvailableRooms() {
        // Create a list of mock conference rooms
        List<ConferenceRoom> roomsMock = new ArrayList<>();
        ConferenceRoom room1 = mock(ConferenceRoom.class);
        ConferenceRoom room2 = mock(ConferenceRoom.class);
        roomsMock.add(room1);
        roomsMock.add(room2);

        // Stub the behavior of roomDaoMock.getAllRooms() to return the list of mock rooms
        when(roomDaoMock.getAllRooms()).thenReturn(roomsMock);

        // Stub the behavior of roomMock.isReserved() to return false for all rooms
        when(room1.isReserved()).thenReturn(false);
        when(room2.isReserved()).thenReturn(false);

        // Retrieve the list of available rooms
        List<ConferenceRoom> availableRooms = reservationSystem.getAvailableRooms();

        // Assert that the list of available rooms matches the expected mock rooms
        assertEquals(roomsMock, availableRooms);
    }
}

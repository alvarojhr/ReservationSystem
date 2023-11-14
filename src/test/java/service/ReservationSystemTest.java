package service;

import dao.ConferenceRoomDao;
import java.util.List;
import model.ConferenceRoom;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

public class ReservationSystemTest {
    
    private ReservationSystem system;

    @Mock
    private ConferenceRoomDao roomDao;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        system = new ReservationSystem(roomDao);
    }

    @Test
    public void testReserveRoom_Success() {
        // Arrange
        ConferenceRoom room = new ConferenceRoom("1", 10);
        when(roomDao.getRoomById("1")).thenReturn(room);

        // Act
        boolean success = system.reserveRoom("1");

        // Assert
        assertTrue(success);
        assertTrue(room.isReserved());
    }

    @Test
    public void testReserveRoom_RoomNotFound() {
        // Arrange
        when(roomDao.getRoomById("1")).thenReturn(null);

        // Act
        boolean success = system.reserveRoom("1");

        // Assert
        assertFalse(success);
    }

    @Test
    public void testReserveRoom_RoomAlreadyReserved() {
        // Arrange
        ConferenceRoom room = new ConferenceRoom("1", 10);
        room.setReserved(true);
        when(roomDao.getRoomById("1")).thenReturn(room);

        // Act
        boolean success = system.reserveRoom("1");

        // Assert
        assertFalse(success);
        assertTrue(room.isReserved());
    }

    @Test
    public void testCancelReservation_Success() {
        // Arrange
        ConferenceRoom room = new ConferenceRoom("1", 10);
        room.setReserved(true);
        when(roomDao.getRoomById("1")).thenReturn(room);

        // Act
        boolean success = system.cancelReservation("1");

        // Assert
        assertTrue(success);
        assertFalse(room.isReserved());
    }

    @Test
    public void testCancelReservation_RoomNotFound() {
        // Arrange
        when(roomDao.getRoomById("1")).thenReturn(null);

        // Act
        boolean success = system.cancelReservation("1");

        // Assert
        assertFalse(success);
    }

    @Test
    public void testCancelReservation_RoomNotReserved() {
        // Arrange
        ConferenceRoom room = new ConferenceRoom("1", 10);
        room.setReserved(false);
        when(roomDao.getRoomById("1")).thenReturn(room);

        // Act
        boolean success = system.cancelReservation("1");

        // Assert
        assertFalse(success);
        assertFalse(room.isReserved());
    }

    @Test
    public void testGetAvailableRooms() {
        // Arrange
        ConferenceRoom room1 = new ConferenceRoom("1", 10);
        ConferenceRoom room2 = new ConferenceRoom("2", 20);
        room2.setReserved(true);
        when(roomDao.getAllRooms()).thenReturn(List.of(room1, room2));

        // Act
        List<ConferenceRoom> availableRooms = system.getAvailableRooms();

        // Assert
        assertEquals(1, availableRooms.size());
        assertEquals(room1, availableRooms.get(0));
    }
    
    @Test
    public void testGetConferenceRoom(){
        ConferenceRoom room = new ConferenceRoom("1", 10);
        assertEquals ("1", room.getId());
        assertEquals(10, room.getCapacity());
        assertFalse(!room.isReserved());
    }
}

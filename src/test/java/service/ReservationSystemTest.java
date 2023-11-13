package service;

import dao.ConferenceRoomDao;
import model.ConferenceRoom;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

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
    public void testReserveRoom() {
        ConferenceRoom room = new ConferenceRoom("1", 10);
        when(roomDao.getRoomById("1")).thenReturn(room);

        boolean succes = system.reserveRoom("1");

        assertTrue(succes);
        assertTrue(room.isReserved());

    }

    @Test
    public void testCancelReservation() {
        // Implementar pruebas aquí
        ConferenceRoom room = new ConferenceRoom("1", 10);
        room.setReserved(true);
        when(roomDao.getRoomById("1")).thenReturn(room);

        boolean succes = system.cancelReservation("1");

        assertTrue(succes);
        assertFalse(room.isReserved());
    }
    @Test
    void testReserveRoom_CuandoEstaOcupada() {
        ConferenceRoom room2 = new ConferenceRoom("2", 12);
        room2.setReserved(true);
        when(roomDao.getRoomById("2")).thenReturn(room2);

        boolean ocupada = system.reserveRoom("2");

        assertFalse(ocupada);
        assertTrue(room2.isReserved());
    }

    @Test
    void testGetAvailableRooms() {
        ConferenceRoom room1 = new ConferenceRoom("1", 10);
        ConferenceRoom room2 = new ConferenceRoom("2", 20);
        ConferenceRoom room3 = new ConferenceRoom("3", 20);
        ConferenceRoom room4 = new ConferenceRoom("4", 20);
        room2.setReserved(true);
        room3.setReserved(true);
        when(roomDao.getAllRooms()).thenReturn(List.of(room1, room2, room3, room4));

        // Act
        List<ConferenceRoom> availableRooms = system.getAvailableRooms();

        // Assert
        assertEquals(2, availableRooms.size());
        assertEquals(room1, availableRooms.get(0));
        assertEquals(room4, availableRooms.get(1));
    }



    // Puedes añadir más pruebas según lo consideres necesario
}

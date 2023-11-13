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
    void testgetsalas() {
        ConferenceRoom room1 = new ConferenceRoom("1", 10);
        ConferenceRoom room2 = new ConferenceRoom("2", 20);
        ConferenceRoom room3 = new ConferenceRoom("3", 35);
        ConferenceRoom room4 = new ConferenceRoom("4", 49);
        room2.setReserved(true);

        assertEquals ("1", room1.getId());
        assertEquals(10, room1.getCapacity());
        assertFalse(room1.isReserved());

        assertEquals ("2", room2.getId());
        assertEquals(20, room2.getCapacity());
        assertTrue(room2.isReserved());
    }

    @Test
    public void testReserveRoom() {
        // Implementar pruebas aquí
        ConferenceRoom room = new ConferenceRoom("1", 10);
        when(roomDao.getRoomById("1")).thenReturn(room);
        boolean serviseTrue = system.reserveRoom("1");

        assertTrue(serviseTrue);
        assertTrue(room.isReserved());
    }

    @Test
    public void testCancelReservation() {
        // Implementar pruebas aquí
        ConferenceRoom room2 = new ConferenceRoom("2", 12);
        room2.setReserved(true);
        when(roomDao.getRoomById("2")).thenReturn(room2);

        boolean cancellationService = system.cancelReservation("2");

        assertTrue(cancellationService);
        assertFalse(room2.isReserved());
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

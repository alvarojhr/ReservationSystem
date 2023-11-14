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
import org.mockito.stubbing.OngoingStubbing;

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
        // Implementar pruebas aquí\
        ConferenceRoom room = new ConferenceRoom("2",11);
        when(roomDao.getRoomById("2")).thenReturn(room);
         boolean success = system.reserveRoom("2");
        // Assert
        assertTrue(success);
        assertTrue(room.isReserved());
    }

    @Test
    public void testCancelReservation() {
        // Implementar pruebas aquí
    }
    @Test
    public void conferenceRoom() {
        ConferenceRoom room = new ConferenceRoom("1", 5);
        //assert.assertEquals(1, room.getId());
        assertEquals("1",room.getId());
        assertEquals(5, room.getCapacity());
    }

    // Puedes añadir más pruebas según lo consideres necesario
    @Test 
    public void roomIsReserved(){
        ConferenceRoom room = new ConferenceRoom("1", 5);
        assertEquals(false,room.isReserved());
        assertFalse(room.isReserved());
    }
    @Test
    public void roomsetReserved(){
      ConferenceRoom room = new ConferenceRoom("1", 5);
      room.setReserved(true);
      assertEquals(true,room.isReserved());
    }
    @Test
    public void listRoom(){
        ConferenceRoom room = new ConferenceRoom("1", 5);
        ConferenceRoom room1 = new ConferenceRoom("2", 6);
        room1.setReserved(true);
        when(roomDao.getAllRooms()).thenReturn(List.of(room,room1));
         
        List<ConferenceRoom> habitacionesDisponibles = system.getAvailableRooms();
        assertEquals(1,habitacionesDisponibles.size());
        assertEquals(room,habitacionesDisponibles.get(0));
    
    }
    }


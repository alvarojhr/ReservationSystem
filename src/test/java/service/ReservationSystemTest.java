package service;

import model.ConferenceRoom;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ReservationSystemTest {

    private ReservationSystem system;

    @BeforeEach
    public void setUp() {
        system = new ReservationSystem();
    }

    @Test
    public void testReserveRoom() {
        assertEquals(true, system.reserveRoom("A1"));
        assertEquals(false, system.reserveRoom("A1"));
        assertEquals(false, system.reserveRoom("B1"));
    }

    @Test
    public void testCancelReservation() {
        assertEquals(false, system.cancelReservation("A1"));    
        system.reserveRoom("A1");
        assertEquals(true, system.cancelReservation("A1"));
        assertEquals(false, system.cancelReservation("B1"));
    }

    // Puedes añadir más pruebas según lo consideres necesario
}

package service;

import model.ConferenceRoom;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ReservationSystemTest {

    private ReservationSystem system;

    @BeforeEach
    public void setUp() {
        //system = new ReservationSystem();
    }

    @Test
    public void testReserveRoom() {
        // Habitación válida
        assertEquals(true, system.reserveRoom("A1"));
        // Intentar reservar la misma habitación nuevamente (debería devolver falso)
        assertEquals(false, system.reserveRoom("A1"));
        // Intentar reservar una habitación inexistente (debería devolver falso)
        assertEquals(false, system.reserveRoom("B1"));
    }

    @Test
    public void testCancelReservation() {
        // Intentar cancelar la reserva de una habitación no reservada (debería devolver falso)
        assertEquals(false, system.cancelReservation("A1"));
        // Reservar una habitación y luego cancelar la reserva (debería devolver true)
        system.reserveRoom("A1");
        assertEquals(true, system.cancelReservation("A1"));
        // Intentar cancelar la reserva de una habitación inexistente (debería devolver falso)
        assertEquals(false, system.cancelReservation("B1"));
    }

    // Puedes añadir más pruebas según lo consideres necesario
}

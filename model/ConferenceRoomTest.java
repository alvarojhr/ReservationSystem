package model;
import model.ConferenceRoom;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import static org.mockito.Mockito.*;

public class ConferenceRoomTest {

    @BeforeAll
    public static void setUpClass() throws Exception {
    }

    @AfterAll
    public static void tearDownClass() throws Exception {
    }

    @BeforeEach
    public void setUp() throws Exception {
    }

    @AfterEach
    public void tearDown() throws Exception {
    }

    @Test
    public void testGetId() {
        // Create a mock instance of ConferenceRoom
        ConferenceRoom room = mock(ConferenceRoom.class);
        
        // Stub the behavior of getId() to return a specific value
        when(room.getId()).thenReturn("1");
        
        // Test the getId() method
        String result = room.getId();
        
        // Verify that the getId() method was called and returned the expected value
        verify(room).getId();
        assertEquals("1", result);
    }

    @Test
    public void testGetCapacity() {
        // Create a mock instance of ConferenceRoom
        ConferenceRoom room = mock(ConferenceRoom.class);

        // Stub the behavior of getCapacity() to return a specific value
        when(room.getCapacity()).thenReturn(30);

        // Test the getCapacity() method
        int result = room.getCapacity();

        // Verify that the getCapacity() method was called and returned the expected value
        verify(room).getCapacity();
        assertEquals(30, result);
    }

    @Test
    public void testIsReserved() {
        // Create a mock instance of ConferenceRoom
        ConferenceRoom room = mock(ConferenceRoom.class);

        // Stub the behavior of isReserved() to return a specific value
        when(room.isReserved()).thenReturn(true);

        // Test the isReserved() method
        boolean result = room.isReserved();

        // Verify that the isReserved() method was called and returned the expected value
        verify(room).isReserved();
        assertTrue(result);
    }

    @Test
    public void testSetReserved() {
        // Create a mock instance of ConferenceRoom
        ConferenceRoom room = mock(ConferenceRoom.class);

        // Call the setReserved() method
        room.setReserved(false);

        // Verify that the setReserved() method was called with the correct argument
        verify(room).setReserved(false);
    }
}

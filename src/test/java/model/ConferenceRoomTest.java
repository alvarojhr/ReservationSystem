/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author hector
 */
public class ConferenceRoomTest {
    
    public ConferenceRoomTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getId method, of class ConferenceRoom.
     */
    @Test
    public void testGetId() {
        System.out.println("testing getId");
        ConferenceRoom conferenceRoom= new ConferenceRoom("1", 20);
        
        String expResult = conferenceRoom.getId();
        assertEquals("1", expResult);
    }

    /**
     * Test of getCapacity method, of class ConferenceRoom.
     */
    @Test
    public void testGetCapacity() {
        System.out.println(" test getCapacity");
        ConferenceRoom conferenceRoom = new ConferenceRoom("2", 40);
        int expResult =conferenceRoom.getCapacity();
        assertEquals(40, expResult);
    }

    /**
     * Test of isReserved method, of class ConferenceRoom.
     */
    @Test
    public void testIsReserved() {
        System.out.println("test isReserved");
        ConferenceRoom conferenceRoom= new ConferenceRoom("3", 30);
        assertFalse(conferenceRoom.isReserved());
        conferenceRoom.setReserved(true);
        assertTrue(true);
    }

    /**
     * Test of setReserved method, of class ConferenceRoom.
     */
    @Test
    public void testSetReserved() {
        System.out.println("test setReserved");
        ConferenceRoom conferenceRoom= new ConferenceRoom("5", 23);
        assertFalse(conferenceRoom.isReserved());
        conferenceRoom.setReserved(true);
        assertTrue(true);
    }
    
}

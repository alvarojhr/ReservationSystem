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
    public void before(){
        System.out.println("before");
        MockitoAnnotations.openMocks(this);
        system = new ReservationSystem(roomDao);
    }
    
    @Test
    public void isIdRoomCorrect(){
        System.out.println("Practice");
        ConferenceRoom romnt = new ConferenceRoom("1", 20);
        String process = romnt.getId();
        assertEquals("1", process);
    }
  // cuando el id del metodo getRoomById del roomDao sea "1", el cuarto del "1" sea roomt predeterminadamente
    @Test
    public void reserveroom(){
        System.out.println("Practice");
        ConferenceRoom romnt = new ConferenceRoom("1", 20);
        when(roomDao.getRoomById("1")).thenReturn(romnt);
        boolean process = system.reserveRoom("1");
        assertTrue(romnt.isReserved());
    }
    @Test
    public void cancelreservation(){
        System.out.println("Practice");
        ConferenceRoom romnt = new ConferenceRoom("1", 20);
        romnt.setReserved(true);
        when(roomDao.getRoomById("1")).thenReturn(romnt);
        boolean process = system.cancelReservation("1");
        assertFalse(romnt.isReserved());
    }
    @Test
    public void ListRoom(){
        System.out.println("Practice");
        ConferenceRoom romnt = new ConferenceRoom("1", 20);
        ConferenceRoom romnt2 = new ConferenceRoom("2", 30);
        when(roomDao.getAllRooms()).thenReturn(List.of(romnt,romnt2));        
        List<ConferenceRoom> process = system.getAvailableRooms();
        assertEquals(romnt, process.get(0));
    }
    @Test
    public void Aviablerooms(){
        System.out.println("Practice");
        ConferenceRoom romnt = new ConferenceRoom("1", 20);
        ConferenceRoom romnt2 = new ConferenceRoom("2", 30);
        romnt2.setReserved(false);
        romnt2.setReserved(true);
        when(roomDao.getAllRooms()).thenReturn(List.of(romnt,romnt2));
        List<ConferenceRoom> process = system.getAvailableRooms();
        assertEquals(romnt, process.get(0));
    }
}

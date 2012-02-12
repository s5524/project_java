
package mpr.java.project.test;

import java.util.ArrayList;
import java.util.List;
import mpr.java.project.model.Reservation;
import mpr.java.project.model.Guest;
import mpr.java.project.model.Hotel;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class GuestTest {
    
    private Guest guest; 
    
    @Before
    public void setUp() {
        guest = new Guest();
    }
    
    @Test
    public void isExists() {
        assertNotNull(guest);
    }
    
    @Test
    public void id() {
        guest.setId(new Long(1));
        assertEquals(new Long(1), guest.getId());
    }
    
    @Test
    public void name() {
        guest.setName("Jan");
        assertEquals("Jan", guest.getName());
    }
    
    @Test
    public void surname() {
        guest.setSurname("Kowalski");
        assertEquals("Kowalski", guest.getSurname());
    }
    
    @Test
    public void phone() {
        guest.setPhone("123456789");
        assertEquals("123456789", guest.getPhone());
    }
    
    @Test
    public void hotel() {
        Hotel hotel = new Hotel();
        guest.setHotel(hotel);
        assertSame(hotel, guest.getHotel());
    }
    
    @Test
    public void reservations() {
        List<Reservation> reservations = new ArrayList<Reservation>();
        guest.setReservations(reservations);
        assertSame(reservations, guest.getReservations());
    }
}

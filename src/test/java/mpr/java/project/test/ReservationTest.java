
package mpr.java.project.test;

import mpr.java.project.model.Guest;
import mpr.java.project.model.Reservation;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class ReservationTest {
    
    private Reservation reservation;
    
    @Before
    public void setUp() {
        reservation = new Reservation();
    }

    @Test
    public void isExists() {
        assertNotNull(reservation);
    }
    
    @Test
    public void id() {
        reservation.setId(new Long(1));
        assertEquals(new Long(1), reservation.getId());
    }
    
    @Test
    public void roomNuber() {
        reservation.setRoomNumber(1);
        assertEquals(1 , reservation.getRoomNumber());
    }
    
    @Test
    public void resDate() {
        reservation.setResDate("2012-01-01");
        assertEquals("2012-01-01", reservation.getResDate());
    }
    
    @Test
    public void guest() {
        Guest guest = new Guest();
        reservation.setGuest(guest);
        assertSame(guest, reservation.getGuest());
    }
}

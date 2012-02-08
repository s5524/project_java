
package mpr.java.project;

import java.util.ArrayList;
import java.util.List;
import mpr.java.project.model.Guest;
import mpr.java.project.model.Hotel;
import mpr.java.project.model.Reservation;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hsql.db.HibernateUtil;

public class Main {
    public static void main( String[] args )
    {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session s = sf.openSession();
        
        Transaction tx = s.beginTransaction();
            
        Hotel hotel = new Hotel();
        hotel.setAdress("Klonowa 9, Poznań");
        hotel.setName("Panteon");
        hotel.setPhone("123443");
        
        List<Guest> guests = new ArrayList<Guest>();
        
        Guest guest1 = new Guest();
        guest1.setName("Jan");
        guest1.setSurname("Prądzyński");
        guest1.setPhone("324657980");
        guest1.setHotel(hotel);
        guests.add(guest1);
        
        Guest guest2 = new Guest();
        guest2.setName("Piotr");
        guest2.setSurname("Lewandowski");
        guest2.setPhone("224657980");
        guest2.setHotel(hotel);
        guests.add(guest2);
        
        Guest guest3 = new Guest();
        guest3.setName("Wojciech");
        guest3.setSurname("Wojmos");
        guest3.setPhone("890657980");
        guest3.setHotel(hotel);
        guests.add(guest3);
        
        hotel.setGuests(guests);
        
        List<Reservation> reservations1 = new ArrayList<Reservation>();
        List<Reservation> reservations2 = new ArrayList<Reservation>();
        
        Reservation reservation1 = new Reservation();
        reservation1.setRoomNumber(1);
        reservation1.setResDate("2012-12-12");
        reservation1.setGuest(guest3);
        reservations1.add(reservation1);
        
        Reservation reservation2 = new Reservation();
        reservation2.setRoomNumber(2);
        reservation2.setResDate("2012-12-21");
        reservation2.setGuest(guest3);
        reservations1.add(reservation2);
        
        Reservation reservation3 = new Reservation();
        reservation3.setRoomNumber(3);
        reservation3.setResDate("2012-06-05");
        reservation3.setGuest(guest1);
        reservations2.add(reservation3);
        
        guest3.setReservations(reservations1);
        guest1.setReservations(reservations2);
        
        s.save(hotel);
        s.save(guest1);
        s.save(guest2);
        s.save(guest3);
        s.save(reservation1);
        s.save(reservation2);
        s.save(reservation3);
        
        tx.commit();
        s.close();
    }
}


package mpr.java.project.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hsql.db.HibernateUtil;

@Entity
public class Hotel implements Serializable {
    
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String adress;
    private String phone;
    @OneToMany(mappedBy = "hotel")
    private List<Guest> guests = new ArrayList<Guest>();
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Guest> getGuests() {
        return guests;
    }

    public void setGuests(List<Guest> guests) {
        this.guests = guests;
    }
    
    public static List<Guest> searchByName(String name) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();

        Criteria criteria = session.createCriteria(Guest.class);
        criteria.add(Restrictions.eq("name", name));
        List<Guest> guestsResult = criteria.list();
        
        transaction.commit();
        
        return guestsResult;
    }
    
    public static List<Guest> searchByPhone (String phone){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();

        Criteria criteria = session.createCriteria(Guest.class);
        criteria.add(Restrictions.eq("phone", phone));
        List<Guest> guestsResult = criteria.list();
        
        transaction.commit();
        
        return guestsResult;
    }
    
    public static List<Guest> searchBySurname(String surname) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();

        Criteria criteria = session.createCriteria(Guest.class);
        criteria.add(Restrictions.eq("surname", surname));
        List<Guest> guestsResult = criteria.list();
        
        transaction.commit();
        
        return guestsResult;
    }
}

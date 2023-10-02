package ru.aston.tarakanov_aa.task9;
import ru.aston.tarakanov_aa.task9.Entity.*;
import ru.aston.tarakanov_aa.task9.Enum.*;

import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.SelectionQuery;

public class Main {

	public static void main(String[] args) {
		Configuration configuration = new Configuration();
	    configuration.configure("ru/aston/tarakanov_aa/task9/resources/hibernate.cfg.xml");

	    // map ENTITY !!
	    configuration.addAnnotatedClass(User.class);
	    configuration.addAnnotatedClass(Order.class);
	    configuration.addAnnotatedClass(Courier.class);
	    configuration.addAnnotatedClass(Region.class);
	    configuration.addAnnotatedClass(UserContacts.class);
	    
	    // Get Session
	    try (SessionFactory sessionFactory = configuration.buildSessionFactory();
	    		Session session = sessionFactory.openSession()) {
	            // Transaction !!
	            session.beginTransaction();

	            // build users and orders - One to Many
	            User user1 = new User("Bibo1", "lala1");
	            User user2 = new User("Bibo2", "lala12");
	            session.persist(user1);
	            session.persist(user2);
	            
	            Order order1 = new Order("product1", 10);
	            Order order2 = new Order("product2", 20);	  
	            
	            order1.setUser(user1);
	            order2.setUser(user2);
	            
	            session.persist(order1);
	            session.persist(order2);
	            session.flush();
	            
	            
	            // build Couriers and Regions - Many to Many	            
	            Courier courier1 = new Courier("Courier1", CourierType.AUTO);
	            Courier courier2 = new Courier("Courier2", CourierType.BIKE);
	            
	            Region region1 = new Region("Region1", 101);
	            Region region2 = new Region("Region2", 202);
	            
	            Set<Region> setR1 = courier1.getRegions();
	            Set<Region> setR2 = courier2.getRegions();	            
	            
	            setR1.add(region1);
	            setR2.add(region2);
	            
	            courier1.setRegions(setR1);
	            courier2.setRegions(setR2);
	            
	            session.persist(courier1);
	            session.persist(courier2);
	            session.flush();
	            
	            
	            // build User Contacts - One to One
	            UserContacts userContacts1 = new UserContacts("st. Green", user1);
	            UserContacts userContacts2 = new UserContacts("st. Red", user2);
	            
	            session.persist(userContacts1);
	            session.persist(userContacts2);
	            
	            //session.saveOrUpdate(new User(20, "Ivan", "Kovalev"));

	            // native query example
//	            SelectionQuery<Order> sqlQuery = session.createSelectionQuery("from Order", Order.class);
//	            List<Order> list = sqlQuery.list();
//	            for (Order o : list) {
//	                System.out.println(o.getUser());
//	            	//session.save( new Order(o.getSour_name(), 10, CourierType.AUTO, o));	            	
//	            }

	            // Get user
	            //System.out.println((User) session.get(User.class, 1));

	            // HQL example
//	            int id = 1;
//	            Query query = session.createQuery("from User where id = :id");
//	            query.setParameter("id", id);
//	            User u = (User) query.uniqueResult();
//	            System.out.println(u);

	            // commit
	            session.getTransaction().commit();


	     }

	}

}

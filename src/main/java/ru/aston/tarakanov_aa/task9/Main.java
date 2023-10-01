package ru.aston.tarakanov_aa.task9;
import ru.aston.tarakanov_aa.task9.Entity.Order;
import ru.aston.tarakanov_aa.task9.Entity.User;
import ru.aston.tarakanov_aa.task9.Enum.*;

import java.util.List;

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

	    // Get Session
	    try (SessionFactory sessionFactory = configuration.buildSessionFactory();
	    		Session session = sessionFactory.openSession()) {
	            // Transaction !!
	            session.beginTransaction();

	            // build user
	            User user = new User("Bibo1", "lala1");
	            
	                        
	            // save data
	            session.persist(user);
	           
	         
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

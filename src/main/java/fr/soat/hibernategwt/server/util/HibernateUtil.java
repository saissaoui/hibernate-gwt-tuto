package fr.soat.hibernategwt.server.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static SessionFactory sessionFactory;

	private static SessionFactory buildSessionFactory() {
	
			
			// Create the SessionFactory from hibernate.cfg.xml
			
			return new Configuration().configure("hibernate.cfg.xml")
					.buildSessionFactory();
			
			

		
	}

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null)
			sessionFactory = buildSessionFactory();
		return sessionFactory;
	}

	public static void shutdown() {
		// Close caches and connection pools
		getSessionFactory().close();
	}

}

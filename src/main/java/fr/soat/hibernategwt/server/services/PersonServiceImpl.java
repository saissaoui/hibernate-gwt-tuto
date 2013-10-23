package fr.soat.hibernategwt.server.services;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import fr.soat.hibernategwt.client.services.PersonService;
import fr.soat.hibernategwt.server.util.HibernateUtil;
import fr.soat.hibernategwt.shared.model.Person;

public class PersonServiceImpl extends RemoteServiceServlet implements
		PersonService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public List<Person> getAll() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		List<Person> records = new ArrayList<Person>(session.createQuery(
				"from Person").list());
		session.getTransaction().commit();
		return records;

	}

	public void add(Person person) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(person);
		session.getTransaction().commit();

	}

}

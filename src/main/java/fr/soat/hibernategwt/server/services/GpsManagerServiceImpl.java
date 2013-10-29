package fr.soat.hibernategwt.server.services;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.context.internal.ThreadLocalSessionContext;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import fr.soat.hibernategwt.client.services.GpsManagerService;
import fr.soat.hibernategwt.server.util.HibernateUtil;
import fr.soat.hibernategwt.shared.model.Consultant;
import fr.soat.hibernategwt.shared.model.Gps;

public class GpsManagerServiceImpl extends RemoteServiceServlet implements
		GpsManagerService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Session session;

	public GpsManagerServiceImpl() {
		session = HibernateUtil.getSessionFactory().openSession();
		ThreadLocalSessionContext.bind(session);
	}

	public void addConsultantToGps(Consultant consultant, Gps gps) {

		
	
		session.getTransaction().begin();
		gps = (Gps) session.load(Gps.class, gps.getIdGps());
		gps.getConsultantsList().add(consultant);
		session.save(consultant);
		session.save(gps);
		session.getTransaction().commit();

	}

	public List<Gps> getAllGps() {

		
		session.getTransaction().begin();
		List<Gps> gpsList = new ArrayList<Gps>(session.createQuery("from Gps")
				.list());
		session.getTransaction().commit();
		return gpsList;
	}

	public List<Consultant> getAllConsultants() {

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.getTransaction().begin();
		List<Consultant> consultantsList = new ArrayList<Consultant>(session
				.createQuery("from Consultant").list());
		session.getTransaction().commit();
		return consultantsList;
	}

}

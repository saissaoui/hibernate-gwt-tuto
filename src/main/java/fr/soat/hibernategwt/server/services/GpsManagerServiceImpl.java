package fr.soat.hibernategwt.server.services;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import fr.soat.hibernategwt.client.services.GpsManagerService;
import fr.soat.hibernategwt.server.util.HibernateUtil;
import fr.soat.hibernategwt.shared.model.Consultant;
import fr.soat.hibernategwt.shared.model.Gps;

public class GpsManagerServiceImpl extends RemoteServiceServlet implements GpsManagerService {

	public void addConsultantToGps(Consultant consultant, Gps gps) {
		 Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		    session.beginTransaction();
		    consultant = (Consultant) session.load(Consultant.class, consultant.getIdConsultant());
		    gps = (Gps) session.load(Gps.class, gps.getIdGps());
		    gps.getConsultantsList().add(consultant);
		    session.save(consultant);
		    session.save(gps);
		    session.getTransaction().commit();
		
	}

	public List<Gps> getAllGps() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		List<Gps> gpsList = new ArrayList<Gps>(session.createQuery(
				"from gps").list());
		return gpsList;
	}
	
	public List<Consultant> getAllConsultants() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		List<Consultant> consultantsList = new ArrayList<Consultant>(session.createQuery(
				"from consultant").list());
		return consultantsList;
	}

	
	

}

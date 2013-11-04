package fr.soat.hibernategwt.server.services;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.context.internal.ThreadLocalSessionContext;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import fr.soat.hibernategwt.client.services.GpsManagerService;
import fr.soat.hibernategwt.server.model.Consultant;
import fr.soat.hibernategwt.server.model.Gps;
import fr.soat.hibernategwt.server.util.HibernateUtil;
import fr.soat.hibernategwt.shared.model.ConsultantDTO;
import fr.soat.hibernategwt.shared.model.GpsDTO;

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

	public void addConsultantToGps(ConsultantDTO consultantDto, GpsDTO gpsDto) {

		session.getTransaction().begin();
		
		
		Gps gps = (Gps) session.load(Gps.class, gpsDto.getIdGps());
		Consultant consultant = new Consultant(consultantDto);
		gps.getConsultantsList().add(consultant);
		consultant.setGps(gps);
		session.save(consultant);
		session.save(gps);
		session.getTransaction().commit();

	}

	public List<GpsDTO> getAllGps() {

		session.getTransaction().begin();
		List<Gps> gpsList = new ArrayList<Gps>(session.createQuery("from Gps")
				.list());
		session.getTransaction().commit();
		List<GpsDTO> gpsDtos = new ArrayList<GpsDTO>();

		for (Gps gps : gpsList)
			gpsDtos.add(new GpsDTO(gps.getIdGps(), gps.getNom()));

		return gpsDtos;
	}

	public List<ConsultantDTO> getAllConsultants() {

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.getTransaction().begin();
		List<Consultant> consultantsList = new ArrayList<Consultant>(session
				.createQuery("from Consultant").list());
		session.getTransaction().commit();
		List<ConsultantDTO> consultantDtos = new ArrayList<ConsultantDTO>();
		for (Consultant consultant : consultantsList)
			consultantDtos.add(new ConsultantDTO(consultant.getIdConsultant(),
					consultant.getNom(), new GpsDTO(consultant.getGps().getIdGps(),consultant.getGps().getNom())));

		return consultantDtos;
	}

}

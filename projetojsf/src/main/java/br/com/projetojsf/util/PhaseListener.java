package br.com.projetojsf.util;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;

import org.hibernate.Session;

public class PhaseListener implements javax.faces.event.PhaseListener {

	
	@Override
	public void beforePhase(PhaseEvent fase) {
	   	if (fase.getPhaseId().equals(PhaseId.RESTORE_VIEW)){
	   		
	   		Session session = HibernateUtil.getSessionFactory().openSession(); 
	   		session.beginTransaction();
	   		FacesContextUtil.setRequestSession(session);
	   		
	   		
	   	}
		
	}
	
	@Override
	public void afterPhase(PhaseEvent fase) {
		if (fase.getPhaseId().equals(PhaseId.RENDER_RESPONSE)){
			Session session = FacesContextUtil.getRequestSession();
			try {
				session.getTransaction().commit();
			} catch (Exception e) {
				if (session.getTransaction().isActive()){
					session.getTransaction().rollback();
					
				}
			}finally {
				session.close();
			}
			
		}
		
	}

	
	@Override
	public PhaseId getPhaseId() {
		return PhaseId.ANY_PHASE;
	}
         
	    
}

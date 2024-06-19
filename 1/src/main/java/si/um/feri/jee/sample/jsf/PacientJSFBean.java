package si.um.feri.jee.sample.jsf;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;

import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import si.um.feri.jee.sample.Mail;
import si.um.feri.jee.sample.dao.IPacientDao;
import si.um.feri.jee.sample.dao.IZdravnikDao;
import si.um.feri.jee.sample.dao.PacientDao;
import si.um.feri.jee.sample.dao.ZdravnikDao;
import si.um.feri.jee.sample.vao.Pacient;
import si.um.feri.jee.sample.vao.Zdravnik;

@Named("pacient")
@SessionScoped

public class PacientJSFBean implements Serializable {
@EJB
	IPacientDao pacientEJB;

@EJB
IZdravnikDao zdravnikEJB;
	Logger log = Logger.getLogger(PacientJSFBean.class.toString());

	//private static PacientDao pacientEJB = PacientDao.getInstance();
	private Pacient selectedPacient = new Pacient();



	private String zdravnikEmail;
	private String selectedEmail;


	public Pacient getSelectedPacient() {
		return selectedPacient;
	}

	public List<Pacient> getAllPacients() throws Exception {
		return pacientEJB.getAll();
	}

	public String getZdravnikEmail() {
		return zdravnikEmail;
	}

	public void setZdravnikEmail(String zdravnikEmail) {
		this.zdravnikEmail = zdravnikEmail;
	}

	public String getSelectedEmail() {
		return selectedEmail;
	}

	public void setSelectedEmail(String selectedEmail) {
		this.selectedEmail = selectedEmail;
		selectedPacient = pacientEJB.find(selectedEmail);
		if(selectedPacient == null)
			selectedPacient = new Pacient();

	}

	public void savePacient() throws Exception {
		log.info("zdravnikov email: " + zdravnikEmail);
		selectedPacient.setOsebniZdravnik(zdravnikEJB.find(zdravnikEmail));
		//log.info(zdravnikDao.find(zdravnikEmail).toString());
		pacientEJB.save(selectedPacient);
		selectedPacient = new Pacient();
		Mail m=new Mail();
		try {
			m.send();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public void deletePacient(String email) {
		pacientEJB.delete(email);
	}

	public List<Pacient> getPacientiWithDoctor(String emailZdravnika) {
		//klic v dao, kjer vrne zahtevano
		return pacientEJB.getPacientsWithDoctor(emailZdravnika);
	}

	public List<Pacient> getPacientiNoDoctor() {
		return pacientEJB.getPacientiNoDoctor();
	}
	
}

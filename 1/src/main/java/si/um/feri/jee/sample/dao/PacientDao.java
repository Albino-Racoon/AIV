package si.um.feri.jee.sample.dao;

import jakarta.ejb.Local;
import jakarta.ejb.Stateless;
import si.um.feri.jee.sample.vao.Pacient;
import java.util.*;
import java.util.logging.Logger;
@Stateless
@Local(IPacientDao.class)
public class PacientDao implements IPacientDao {

    Logger log = Logger.getLogger(PacientDao.class.toString());
    private List<Pacient> pacienti;
  //  private static PacientDao instance = null;

    private PacientDao() {
        this.pacienti = new ArrayList<Pacient>();
    }

  /*  public static synchronized PacientDao getInstance() {
        if (instance == null) {
            instance = new PacientDao();
        }
        return instance;
    }*/
@Override
    public List<Pacient> getAll() {
        log.info("PacientDao: poisci vse paciente");
        return pacienti;
    }
@Override
    public void save(Pacient p) {
        log.info("PacientDao: shrani");
        boolean edited = false;
        if (pacienti.size() != 0) {
            for (int i = 0; i < pacienti.size(); i++) {
                if (pacienti.get(i).getEmail().equals(p.getEmail())) {
                    pacienti.add(i,p);
                    pacienti.remove(i+1);
                    edited = true;
                    break;
                }
            }
        }
        if (!edited) {
            log.info("added pacient");
            pacienti.add(p);
        }
    }
@Override
    public Pacient find(String email) {
        if (pacienti != null) {
            for (int i = 0; i < pacienti.size(); i++) {
                Pacient temp = pacienti.get(i);
                if (temp.getEmail().equals(email)) {
                    return temp;
                }
            }
        }
        return null;
    }
@Override
    public void delete(String email) {
        pacienti.remove(find(email));
    }
    @Override
    public List<Pacient> getPacientsWithDoctor(String emailZdravnika) {
        ArrayList<Pacient> iskani = new ArrayList<Pacient>();
        for (int i = 0; i < pacienti.size(); i++) {
            if (pacienti.get(i).getOsebniZdravnik() != null && pacienti.get(i).getOsebniZdravnik().getEmail().equals(emailZdravnika)) {
                log.info(pacienti.get(i).getOsebniZdravnik().getEmail());
                iskani.add(pacienti.get(i));
            }
        }
        log.info(iskani.toString());
        return iskani;
    }
    @Override

    public List<Pacient> getPacientiNoDoctor() {
        ArrayList<Pacient> iskani = new ArrayList<Pacient>();
        for (int i = 0; i < pacienti.size(); i++) {
            if (pacienti.get(i).getOsebniZdravnik() == null) {
                log.info(pacienti.get(i).toString());
                iskani.add(pacienti.get(i));
            }
        }
        return iskani;
    }

}

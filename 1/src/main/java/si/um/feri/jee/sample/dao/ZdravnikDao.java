package si.um.feri.jee.sample.dao;

import jakarta.ejb.Local;
import jakarta.ejb.Stateless;
import jakarta.persistence.criteria.CriteriaBuilder;
import si.um.feri.jee.sample.vao.Zdravnik;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;
@Stateless
@Local(IZdravnikDao.class)
public class ZdravnikDao implements IZdravnikDao {

    Logger log = Logger.getLogger(ZdravnikDao.class.toString());
    private List<Zdravnik> zdravniki ;
    //private static ZdravnikDao instance = null;

    private ZdravnikDao() {
        this.zdravniki = new ArrayList<Zdravnik>();
    }



    /*
        public static synchronized ZdravnikDao getZdravnikDao() {
            if (instance == null) {
                instance = new ZdravnikDao();
            }
            return instance;
        }
    */
    @Override
    public List<Zdravnik> getAll() {
        log.info("ZdravnikDao: poisci vse zdravnike");
        return zdravniki;
    }
@Override
    public void save(Zdravnik z) {
        log.info("ZdravnikDao: shrani zdravnika");
        boolean edited = false;
        if (zdravniki.size() != 0) {
            for (int i = 0; i < zdravniki.size(); i++) {
                if (zdravniki.get(i).getEmail().equals(z.getEmail())) {
                    zdravniki.add(i, z);
                    zdravniki.remove(i+1);
                    edited = true;
                    break;
                }
            }
        }
        if (!edited) {
            log.info("added");
            zdravniki.add(z);
        }

        for (Zdravnik dr : zdravniki) {
            log.info(dr.toString());
        }
    }
@Override
    public Zdravnik find(String email) {
        log.info("param email: " + email);
        log.info("email of first: " + zdravniki.get(0).getEmail());
        for (Zdravnik temp : zdravniki) {
            log.info(temp.getEmail());
            log.info(email);
            if (temp.getEmail().equals(email)) {
                return temp;
            }
        }
        return null;
    }
@Override
    public void delete(String email) {
        zdravniki.remove(find(email));
    }
@Override
    public List<String> getAllEmails() {
        ArrayList<String> emails = new ArrayList<String>();
        for (int i = 0; i < zdravniki.size(); i++) {
            emails.add(zdravniki.get(i).getEmail());
        }
        return emails;
    }

    public Logger getLog() {
        return log;
    }

    public List<Zdravnik> getZdravniki() {
        return zdravniki;
    }
    public Zdravnik getZdravnik(int i) {
        return zdravniki.get(i);
    }
}

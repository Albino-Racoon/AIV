package si.um.feri.jee.sample.jsf;

import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import si.um.feri.jee.sample.dao.IZdravnikDao;
import si.um.feri.jee.sample.dao.ZdravnikDao;
import si.um.feri.jee.sample.vao.Zdravnik;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;

@Named("zdravnik")
@SessionScoped
public class ZdravnikJSFBean implements Serializable {
    @EJB
    IZdravnikDao zdravnikEJB;


    Logger log = Logger.getLogger(ZdravnikJSFBean.class.toString());
    //private ZdravnikDao zdravnikEJB = ZdravnikDao.getZdravnikDao();
    private Zdravnik selected = new Zdravnik();
    private String selectedEmail;

    public void setSelectedEmail(String email) throws Exception {
        selectedEmail = email;
        selected = zdravnikEJB.find(email);
        if(selected == null) {
            selected = new Zdravnik();
        }
    }

    public String getSelectedEmail() {
        return selectedEmail;
    }

    public List<Zdravnik> getAllZdravniki() throws Exception {
        return zdravnikEJB.getAll();
    }

    public Zdravnik getSelected() throws Exception{
        return selected;
    }

    public void saveZdravnik() {
        zdravnikEJB.save(selected);
        selected = new Zdravnik();
    }

    public void deleteZdravnik(String email) {
        zdravnikEJB.delete(email);
    }

    public List<String> getAllZdravnikiEmail() {
        return zdravnikEJB.getAllEmails();
    }

    public ZdravnikDao getZdravnikEJB() {
        return (ZdravnikDao) this.zdravnikEJB;
    }
}

package si.um.feri.jee.sample.dao;

import jakarta.ejb.Remote;
import si.um.feri.jee.sample.vao.Zdravnik;

import java.util.List;
@Remote
public interface IZdravnikDao {
    public List<Zdravnik> getAll();
    public void save(Zdravnik z);
    public Zdravnik find(String email);
    public void delete(String email);
    public List<String> getAllEmails();
}

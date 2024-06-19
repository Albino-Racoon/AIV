package si.um.feri.jee.sample.dao;

import jakarta.ejb.Remote;
import si.um.feri.jee.sample.vao.Pacient;

import java.util.List;
@Remote

public interface IPacientDao {
    public List<Pacient> getPacientsWithDoctor(String emailZdravnika);
    public List<Pacient> getPacientiNoDoctor();
    public List<Pacient> getAll();

    public void save(Pacient p);
    public Pacient find(String email);
    public void delete(String email);
}

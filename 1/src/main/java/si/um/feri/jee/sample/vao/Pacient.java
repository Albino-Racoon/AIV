package si.um.feri.jee.sample.vao;

import jakarta.ejb.Local;

import java.time.LocalDate;
import java.util.Date;

public class Pacient {

    private String ime;
    private String priimek;
    private String email;
    private String posebnosti;
    private Date datumRojstva;
    private Zdravnik osebniZdravnik;


    public Pacient() {}

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPriimek() {
        return priimek;
    }

    public void setPriimek(String priimek) {
        this.priimek = priimek;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPosebnosti() {
        return posebnosti;
    }

    public void setPosebnosti(String posebnosti) {
        this.posebnosti = posebnosti;
    }

    public Date getDatumRojstva() {
        return datumRojstva;
    }

    public void setDatumRojstva(Date datumRojstva) {
        this.datumRojstva = datumRojstva;
    }

    public Zdravnik getOsebniZdravnik() {
        return osebniZdravnik;
    }

    public void setOsebniZdravnik(Zdravnik osebniZdravnik) {
        this.osebniZdravnik = osebniZdravnik;
    }

    @Override
    public String toString() {
        return "Pacient{" +
                "ime='" + ime + '\'' +
                ", priimek='" + priimek + '\'' +
                ", email='" + email + '\'' +
                ", posebnosti='" + posebnosti + '\'' +
                ", datumRojstva=" + datumRojstva +
                ", osebniZdravnik=" + osebniZdravnik +
                '}';
    }
}

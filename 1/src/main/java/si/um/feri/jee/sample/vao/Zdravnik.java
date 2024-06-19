package si.um.feri.jee.sample.vao;

import java.util.List;

public class Zdravnik {

    private String ime;
    private String priimek;
    private String email;
    private int stPacientov;

    public Zdravnik() {}

    public Zdravnik(String ime, String priimek, String email, int stPacientov) {
        this.ime = ime;
        this.priimek = priimek;
        this.email = email;
        this.stPacientov = stPacientov;
    }

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

    public int getStPacientov() {
        return stPacientov;
    }

    public void setStPacientov(int stPacientov) {
        this.stPacientov = stPacientov;
    }

    @Override
    public String toString() {
        return "Zdravnik{" +
                "ime='" + ime + '\'' +
                ", priimek='" + priimek + '\'' +
                ", email='" + email + '\'' +
                ", stPacientov='" + stPacientov + '\'' +
                '}';
    }
}

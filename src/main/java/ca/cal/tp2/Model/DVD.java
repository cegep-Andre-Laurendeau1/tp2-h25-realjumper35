package ca.cal.tp2.Model;

import jakarta.persistence.Entity;

@Entity
public class DVD extends Document {
    private String realisateur;
    private int duree;
    private String note;

    public DVD(String titre, int nombreExemplaires, String realisateur, int duree, String note) {
        super(titre, nombreExemplaires);
        this.realisateur = realisateur;
        this.duree = duree;
        this.note = note;
    }

    public DVD() {

    }

    public String getRealisateur() {
        return realisateur;
    }

    public void setRealisateur(String realisateur) {
        this.realisateur = realisateur;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}

package ca.cal.tp2.Model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class Emprunt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int borrowID;
    @Temporal(TemporalType.DATE)
    private String dateEmprunt;
    private String status;

    @ManyToOne
    @JoinColumn(name = "emprunteur_id")
    private Emprunteur emprunteur;

    @OneToMany(mappedBy = "emprunt")
    private List<EmpruntDetail> getItems;



    public Emprunt() {

    }

    public Emprunt(String dateEmprunt, String status, Emprunteur emprunteur) {
        this.dateEmprunt = dateEmprunt;
        this.status = status;
        this.emprunteur = emprunteur;
    }

    public int getBorrowID() {
        return borrowID;
    }

    public void setBorrowID(int borrowID) {
        this.borrowID = borrowID;
    }

    public String getDateEmprunt() {
        return dateEmprunt;
    }

    public void setDateEmprunt(String dateEmprunt) {
        this.dateEmprunt = dateEmprunt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Emprunteur getEmprunteur() {
        return emprunteur;
    }

    public void setEmprunteur(Emprunteur emprunteur) {
        this.emprunteur = emprunteur;
    }

    public List<EmpruntDetail> getGetItems() {
        return getItems;
    }

    public void setGetItems(List<EmpruntDetail> getItems) {
        this.getItems = getItems;
    }
}

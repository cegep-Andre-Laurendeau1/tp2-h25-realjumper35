package ca.cal.tp2.Model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Amende {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int fineID;
    private double montant;
    @Temporal(TemporalType.DATE)
    private Date dateCreation;
    private boolean status;

    @ManyToOne
    @JoinColumn(name = "emprunteur_id")
    private Emprunteur emprunteur;

    public Amende(int fineID, double montant, Date dateCreation, boolean status) {
        this.fineID = fineID;
        this.montant = montant;
        this.dateCreation = dateCreation;
        this.status = status;
    }

    public Amende() {

    }
}

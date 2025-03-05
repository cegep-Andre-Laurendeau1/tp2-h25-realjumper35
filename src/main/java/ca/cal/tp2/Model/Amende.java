package ca.cal.tp2.Model;

import java.util.Date;

public class Amende {
    private int fineID;
    private double montant;
    private Date dateCreation;
    private boolean status;

    public Amende(int fineID, double montant, Date dateCreation, boolean status) {
        this.fineID = fineID;
        this.montant = montant;
        this.dateCreation = dateCreation;
        this.status = status;
    }
}

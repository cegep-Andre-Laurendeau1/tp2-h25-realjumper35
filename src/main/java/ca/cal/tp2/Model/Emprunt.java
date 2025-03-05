package ca.cal.tp2.Model;

import java.util.Date;

public class Emprunt {
    private int empruntID;
    private Date dateEmprunt;
    private String status;


    public Emprunt(int empruntID, Date dateEmprunt, String status) {
        this.empruntID = empruntID;
        this.dateEmprunt = dateEmprunt;
        this.status = status;
    }

}

package ca.cal.tp2.Model;

import java.util.Date;

public class EmpruntDetail {
    private int lineItemID;
    private Date dateRetourPrevue;
    private Date dateRetourActuelle;
    private String status;

    public EmpruntDetail(int lineItemID, Date dateRetourPrevue, Date dateRetourActuelle, String status) {
        this.lineItemID = lineItemID;
        this.dateRetourPrevue = dateRetourPrevue;
        this.dateRetourActuelle = dateRetourActuelle;
        this.status = status;
    }
}

package ca.cal.tp2.Model;

import jakarta.persistence.*;

@Entity
public class EmpruntDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int lineItemID;
    @Temporal(TemporalType.DATE)
    private String dateRetourPrevue;
    @Temporal(TemporalType.DATE)
    private String dateRetourActuelle;
    private String status;

    @ManyToOne
    @JoinColumn(name = "emprunt_id")
    private Emprunt emprunt;

    @ManyToOne
    @JoinColumn(name = "document_id")
    private Document document;


    public EmpruntDetail() {

    }

    public int getLineItemID() {
        return lineItemID;
    }

    public void setLineItemID(int lineItemID) {
        this.lineItemID = lineItemID;
    }

    public String getDateRetourPrevue() {
        return dateRetourPrevue;
    }

    public void setDateRetourPrevue(String dateRetourPrevue) {
        this.dateRetourPrevue = dateRetourPrevue;
    }

    public String getDateRetourActuelle() {
        return dateRetourActuelle;
    }

    public void setDateRetourActuelle(String dateRetourActuelle) {
        this.dateRetourActuelle = dateRetourActuelle;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Emprunt getEmprunt() {
        return emprunt;
    }

    public void setEmprunt(Emprunt emprunt) {
        this.emprunt = emprunt;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }
}

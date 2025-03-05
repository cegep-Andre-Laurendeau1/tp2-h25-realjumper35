package ca.cal.tp2.Model;

public class DVD extends Document {
    private String realisateur;
    private int duree;
    private String note;

    public DVD(int documentID, String titre, int nombreExemplaires, String realisateur, int duree, String note) {
        super(documentID, titre, nombreExemplaires);
        this.realisateur = realisateur;
        this.duree = duree;
        this.note = note;
    }
}

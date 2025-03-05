package ca.cal.tp2.Model;

public abstract class Document {
    private int documentID;
    private String titre;
    private int nombreExemplaires;

    public Document(int documentID, String titre, int nombreExemplaires) {
        this.documentID = documentID;
        this.titre = titre;
        this.nombreExemplaires = nombreExemplaires;
    }
}

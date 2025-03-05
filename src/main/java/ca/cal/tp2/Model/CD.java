package ca.cal.tp2.Model;

public class CD extends Document {
    private String artiste;
    private int duree;
    private String genre;

    public CD(int documentID, String titre, int nombreExemplaires, String artiste, int duree, String genre) {
        super(documentID, titre, nombreExemplaires);
        this.artiste = artiste;
        this.duree = duree;
        this.genre = genre;
    }
}
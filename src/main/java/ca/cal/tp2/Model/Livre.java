package ca.cal.tp2.Model;

public class Livre extends Document {
    private String ISBN;
    private String auteur;
    private String editeur;
    private int nombrePages;

    public Livre( String titre, int nombreExemplaires, String ISBN, String auteur, String editeur, int nombrePages) {
        super( titre, nombreExemplaires);
        this.ISBN = ISBN;
        this.auteur = auteur;
        this.editeur = editeur;
        this.nombrePages = nombrePages;
    }
}

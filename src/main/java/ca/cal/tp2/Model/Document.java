package ca.cal.tp2.Model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int documentID;
    private String titre;
    private int nombreExemplaires;

//    @OneToMany(mappedBy = "document")
//    private List<EmpruntDetail> references;

    public Document( String titre, int nombreExemplaires) {

        this.titre = titre;
        this.nombreExemplaires = nombreExemplaires;
    }

    public Document() {
        super();
    }

    public int getDocumentID() {
        return documentID;
    }

    public void setDocumentID(int documentID) {
        this.documentID = documentID;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public int getNombreExemplaires() {
        return nombreExemplaires;
    }

    public void setNombreExemplaires(int nombreExemplaires) {
        this.nombreExemplaires = nombreExemplaires;
    }
}

package ca.cal.tp2.Model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Emprunteur extends Utilisateur {

    public Emprunteur(String nom, String email, String phoneNumber) {
        super(nom, email, phoneNumber);
    }




    @OneToMany(mappedBy = "emprunteur")
    private List<Document> retourneDocuments;

    @OneToMany(mappedBy = "emprunteur")
    private List<Amende> payeAmendes;

    @OneToMany(mappedBy = "emprunteur")
    private List<Emprunt> rapportHistoriqueEmprunt;


    public Emprunteur() {

    }
}

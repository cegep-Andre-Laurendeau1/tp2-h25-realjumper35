package ca.cal.tp2.Repository;

import ca.cal.tp2.Model.Emprunteur;
import ca.cal.tp2.Model.Utilisateur;

public interface IAdminRepository {
    Emprunteur CreerEmprunteur(Emprunteur emprunteur);

    public abstract Utilisateur CreerEmprunteur(Utilisateur user);

    public abstract Utilisateur getEmprunteur(int userID);

    void ajouterCD(String titre, int NE, String artiste, int duree, String genre);
}

package ca.cal.tp2.Repository;

import ca.cal.tp2.Model.Emprunteur;
import ca.cal.tp2.Model.Utilisateur;

public interface IPreposeRepository {
    void CreerEmprunteur(Emprunteur emprunteur);

    void CreerUtilisateur(Utilisateur utilisateur);

    void CreerEmprunteur(String name, String email, String phoneNumber);

    void CreerPrepose(String name, String email, String phoneNumber);

    public abstract Utilisateur getEmprunteur(int userID);

    void CreerCD(String titre, int NE, String artiste, int duree, String genre);

    void CreerDVD(String titre, int NE, String realisateur, int duree, String genre);

    void CreerLivre(String titre, int nombreExemplaires, String ISBN, String auteur, String editeur, int nombrePages);
}

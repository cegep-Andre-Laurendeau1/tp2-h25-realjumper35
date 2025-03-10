package ca.cal.tp2.Service;

import ca.cal.tp2.Model.Emprunteur;
import ca.cal.tp2.Model.Utilisateur;
import ca.cal.tp2.Repository.IPreposeRepository;

public class PreposeServices {
    private final IPreposeRepository adminRepository;

    public PreposeServices(IPreposeRepository adminRepository) {
        this.adminRepository = adminRepository;
    }


    public void CreerEmprunteur(String name, String email, String phoneNumber) {
        Emprunteur emprunteur = new Emprunteur(name, email, phoneNumber);

        adminRepository.CreerEmprunteur(name, email, phoneNumber);
    }

    public Utilisateur TrouverEmprunteur(int userID) {
        return adminRepository.getEmprunteur(userID);
    }

    public void AjouterCD(String titre, int NE, String artiste, int duree, String genre) {
        adminRepository.CreerCD(titre, NE, artiste, duree, genre);
    }
    public void AjouterDVD(String titre, int NE, String realisateur, int duree, String genre) {
        adminRepository.CreerDVD(titre, NE, realisateur, duree, genre);
    }
    public void AjouterLivre(String titre, int nombreExemplaires, String ISBN, String auteur, String editeur, int nombrePages) {
        adminRepository.CreerLivre(titre, nombreExemplaires, ISBN, auteur, editeur, nombrePages);
    }
}

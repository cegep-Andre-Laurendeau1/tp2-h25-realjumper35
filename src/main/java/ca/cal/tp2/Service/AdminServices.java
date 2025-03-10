package ca.cal.tp2.Service;

import ca.cal.tp2.Model.Emprunteur;
import ca.cal.tp2.Model.Utilisateur;
import ca.cal.tp2.Repository.IPreposeRepository;

public class AdminServices {
    private final IPreposeRepository adminRepository;

    public AdminServices(IPreposeRepository adminRepository) {
        this.adminRepository = adminRepository;
    }


    public void AjouterEmprunteur(String name, String email, String phoneNumber) {
        Emprunteur emprunteur = new Emprunteur(name, email, phoneNumber);

        adminRepository.CreerEmprunteur(emprunteur);
    }

    public Utilisateur TrouverEmprunteur(int userID) {
        return adminRepository.getEmprunteur(userID);
    }

    public void AjouterCD(String titre, int NE, String artiste, int duree, String genre) {
        adminRepository.ajouterCD(titre, NE, artiste, duree, genre);
    }
    public void AjouterDVD(String titre, int NE, String realisateur, int duree, String genre) {
        adminRepository.ajouterDVD(titre, NE, realisateur, duree, genre);
    }
    public void AjouterLivre(String titre, int nombreExemplaires, String ISBN, String auteur, String editeur, int nombrePages) {
        adminRepository.ajouterLivre(titre, nombreExemplaires, ISBN, auteur, editeur, nombrePages);
    }
}

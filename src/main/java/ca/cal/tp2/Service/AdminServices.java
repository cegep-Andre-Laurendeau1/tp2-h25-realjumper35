package ca.cal.tp2.Service;

import ca.cal.tp2.Model.Emprunteur;
import ca.cal.tp2.Model.Utilisateur;
import ca.cal.tp2.Repository.IAdminRepository;

public class AdminServices {
    private final IAdminRepository adminRepository;

    public AdminServices(IAdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }



    public Emprunteur AjouterEmprunteur(String name, String email, String phoneNumber) {
        Emprunteur emprunteur = new Emprunteur(name, email, phoneNumber);

        return adminRepository.CreerEmprunteur(emprunteur);
    }

    public  Utilisateur TrouverEmprunteur(int userID) {
        return adminRepository.getEmprunteur(userID);
    }
}

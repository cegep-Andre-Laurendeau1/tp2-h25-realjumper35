package ca.cal.tp2.Service;

import ca.cal.tp2.Model.Utilisateur;
import ca.cal.tp2.Repository.IAdminRepository;

public class AdminServices {
    private final IAdminRepository adminRepository;

    public AdminServices(IAdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }



    public  Utilisateur AjouterEmprunteur(String name, String email, String phoneNumber) {
        Utilisateur utilisateur = new Utilisateur(name, email, phoneNumber);

        return adminRepository.CreerEmprunteur(utilisateur);
    }

    public  Utilisateur TrouverEmprunteur(int userID) {
        return adminRepository.getEmprunteur(userID);
    }
}

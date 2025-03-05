package ca.cal.tp2.Service;

import ca.cal.tp2.Model.Utilisateur;
import ca.cal.tp2.Repository.AdminRepositoryJDBC;

public class AdminServices {
    private final AdminRepositoryJDBC AdminRepositoryJDBC;

    public AdminServices(AdminRepositoryJDBC adminRepositoryJDBC) {
        this.AdminRepositoryJDBC = adminRepositoryJDBC;
    }

    public  Utilisateur AjouterEmprunteur(String name, String email, String phoneNumber) {
        Utilisateur utilisateur = new Utilisateur(0, name, email, phoneNumber);

        return AdminRepositoryJDBC.CreerEmprunteur(utilisateur);
    }

    public  Utilisateur TrouverEmprunteur(int userID) {
        return AdminRepositoryJDBC.getEmprunteur(userID);
    }
}

package ca.cal.tp2.Repository;

import ca.cal.tp2.Model.Utilisateur;

public interface IAdminRepository {
    public abstract Utilisateur CreerEmprunteur(Utilisateur user);

    public abstract Utilisateur getEmprunteur(int userID);
}

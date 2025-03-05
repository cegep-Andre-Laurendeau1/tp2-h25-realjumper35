package ca.cal.tp2.Repository;

import ca.cal.tp2.Model.Utilisateur;

public abstract class IRepository {
    public abstract Utilisateur CreerEmprunteur(Utilisateur user);

    public abstract Utilisateur getEmprunteur(int userID);
}

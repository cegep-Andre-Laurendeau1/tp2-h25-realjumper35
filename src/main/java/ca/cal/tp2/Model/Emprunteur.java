package ca.cal.tp2.Model;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "user_type",discriminatorType = DiscriminatorType.STRING)
public class Emprunteur extends Utilisateur {
    public Emprunteur(String name, String email, String phoneNumber) {
        super(name, email, phoneNumber);
    }

    public Emprunteur() {
        super();

    }

    public void emprunte(Document doc) {}
    public void retourneDocument(Document doc) {}
    public void payeAmende(double montant) {}
    public void rapportHistoriqueEmprunt() {}


}

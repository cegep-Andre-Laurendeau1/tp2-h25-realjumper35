package ca.cal.tp2.Model;

import ca.cal.tp2.Model.Utilisateur;

public class Prepose extends Utilisateur {
    public Prepose(int userID, String name, String email, String phoneNumber) {
        super(userID, name, email, phoneNumber);
    }

    public void entreNouveauDocument(Document doc) {
    }

    public void collecteAmende(Emprunteur emprunteur, double montant) {
    }

    public void rapportAmendes() {
    }

    public void rapportEmprunts() {
    }
}

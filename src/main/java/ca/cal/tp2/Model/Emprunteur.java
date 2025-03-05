package ca.cal.tp2.Model;

public class Emprunteur extends Utilisateur {
    public Emprunteur(int userID, String name, String email, String phoneNumber) {
        super(userID, name, email, phoneNumber);
    }
    public void emprunte(Document doc) {}
    public void retourneDocument(Document doc) {}
    public void payeAmende(double montant) {}
    public void rapportHistoriqueEmprunt() {}


}

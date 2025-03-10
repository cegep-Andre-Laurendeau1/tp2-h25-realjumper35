package ca.cal.tp2.Model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Emprunteur extends Utilisateur {

    public Emprunteur(String nom, String email, String phoneNumber) {
        super(nom, email, phoneNumber);
    }


    public Emprunteur() {

    }

    public String getNom() {
        return super.getName();
    }


}

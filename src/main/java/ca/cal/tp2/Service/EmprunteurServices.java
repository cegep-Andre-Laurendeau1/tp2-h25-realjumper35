package ca.cal.tp2.Service;

import ca.cal.tp2.Execption.DataBaseErrorException;
import ca.cal.tp2.Model.Livre;
import ca.cal.tp2.Repository.EmprunteurRepository;

import java.util.List;

public class EmprunteurServices {
    private final EmprunteurRepository emprunteurRepository;

    public EmprunteurServices(EmprunteurRepository emprunteurRepository) {
        this.emprunteurRepository = emprunteurRepository;
    }


    public void NouvelEmprunt(int emprunteurId, int documentId, String dateEmprunt, String status) {
        try {
            emprunteurRepository.NouvelEmprunt(emprunteurId, documentId, dateEmprunt, status);
        } catch (DataBaseErrorException e) {
            System.err.println(e.getMessage());
        }
    }

    public void TrouverLivre(String titre, String auteur) {
        try {


            List<Livre> livresTrouves = emprunteurRepository.rechercherLivre(titre, auteur);

            System.out.println("Livres trouvés :");

            for (Livre livre : livresTrouves) {
                System.out.println(livre.getISBN() + " - " + livre.getTitre() + " - " + livre.getAuteur() + " - " + livre.getEditeur() + " - " + livre.getNombrePages());

            }
            System.out.println("");
        } catch (DataBaseErrorException e) {
            System.err.println(e.getMessage());
        }
    }
}

package ca.cal.tp2.Service;

import ca.cal.tp2.Execption.DataBaseErrorException;
import ca.cal.tp2.Repository.EmprunteurRepository;

public class EmprunteurServices {
    private final EmprunteurRepository emprunteurRepository;

    public EmprunteurServices(EmprunteurRepository emprunteurRepository) {
        this.emprunteurRepository = emprunteurRepository;
    }


    public void NouvelEmprunt(int emprunteurId, int documentId, String dateEmprunt, String status) {
        try {
            emprunteurRepository.NouvelEmprunt(emprunteurId, documentId, dateEmprunt, status);
        } catch (DataBaseErrorException e) {
            System.err.println("Erreur BD" + e.getMessage());
        }
    }
}

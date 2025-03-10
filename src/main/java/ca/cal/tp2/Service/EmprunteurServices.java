package ca.cal.tp2.Service;

import ca.cal.tp2.Repository.EmprunteurRepository;

public class EmprunteurServices {
    private final EmprunteurRepository emprunteurRepository;

    public EmprunteurServices(EmprunteurRepository emprunteurRepository) {
        this.emprunteurRepository = emprunteurRepository;
    }


    public void AjouterEmprunt(int emprunteurId, int documentId, String dateEmprunt, String status) {
        emprunteurRepository.NouvelEmprunt(emprunteurId, documentId, dateEmprunt, status);
    }
}

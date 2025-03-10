package ca.cal.tp2.Service;

import ca.cal.tp2.Execption.DataBaseErrorException;
import ca.cal.tp2.Model.*;
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
            System.out.println("");
            System.err.println(" ERREUR D'EMPRUNT !!!!");
            System.out.println(e.getMessage());
        }
    }

    public void TrouverLivre(String titre, String auteur) {
        try {


            List<Livre> livresTrouves = emprunteurRepository.rechercherLivre(titre, auteur);

            System.out.println("Livres trouvés :");

            for (Livre livre : livresTrouves) {
                System.out.println(livre.getISBN() + " - " + livre.getTitre() + " - " + livre.getAuteur() + " - " + livre.getEditeur() + " - " + livre.getNombrePages());

            }
        } catch (DataBaseErrorException e) {


            System.out.println("");
            System.out.println(" LIVRE NON TROUVE !!!!");
            System.out.println(e.getMessage());
        }
    }

    public void TrouverCD(String titre, String artiste) {

        List<CD> cdTrouves = emprunteurRepository.rechercherCD(titre, artiste);
        System.out.println("CD trouvés :");
        for (CD cd : cdTrouves) {
            System.out.println(cd.getTitre() + " - " + cd.getArtiste() + " - " + cd.getDuree() + " - " + cd.getGenre());
        }
        System.out.println("");

    }

    public void TrouverDVD(String titre, String realisateur) {

        List<DVD> dvdTrouves = emprunteurRepository.rechercherDVD(titre, realisateur);
        System.out.println("DVD trouvés :");
        for (DVD dvd : dvdTrouves) {
            System.out.println(dvd.getTitre() + " - " + dvd.getRealisateur() + " - " + dvd.getDuree() + " - " + dvd.getNote());
        }
        System.out.println("");
    }


    public void AvoirListEmprunt(int emprunteurId) {
        try {
            List<EmpruntDetail> emprunts = emprunteurRepository.listeEmpruntDetails(emprunteurId);
            System.out.println("Liste des emprunts :");
            for (EmpruntDetail empruntDetail : emprunts) {
                System.out.println("Nom de l'emprunteur: " + empruntDetail.getEmprunt().getEmprunteur().getNom() + " - " + "Titre du document: " + empruntDetail.getDocument().getTitre() + " - " + " Date d'emprunt ; "+ empruntDetail.getEmprunt().getDateEmprunt() +" - "+ " Date de retour prévue: " + empruntDetail.getDateRetourPrevue());
            }
        } catch (DataBaseErrorException e) {
            System.out.println("");
            System.out.println(" ERREUR D'EMPRUNT !!!!");
            System.out.println(e.getMessage());
        }

    }
}

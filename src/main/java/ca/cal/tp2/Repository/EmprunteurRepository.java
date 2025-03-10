package ca.cal.tp2.Repository;

import ca.cal.tp2.Execption.DataBaseErrorException;
import ca.cal.tp2.Model.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class EmprunteurRepository {
    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hibernate2.TP2");

    public void NouvelEmprunt(int emprunteurId, int documentId, String dateEmprunt, String status) throws DataBaseErrorException {

        try (EntityManager em = entityManagerFactory.createEntityManager()) {


            em.getTransaction().begin();

            List<Emprunteur> emprunteurs = em.createQuery(
                            "SELECT e FROM Emprunteur e " +
                                    "WHERE e.userID = :emprunteurId", Emprunteur.class)
                    .setParameter("emprunteurId", emprunteurId)
                    .getResultList();

            if (emprunteurs.isEmpty()) {
                throw new IllegalArgumentException("Emprunteur non trouvé avec l'ID: " + emprunteurId);
            }
            Emprunteur emprunteur = emprunteurs.get(0);

            List<Document> documents = em.createQuery(
                            "SELECT d FROM Document d " +
                                    "WHERE d.documentID = :documentId", Document.class)
                    .setParameter("documentId", documentId)
                    .getResultList();

            if (documents.isEmpty()) {
                throw new IllegalArgumentException("Document non trouvé avec l'ID: " + documentId);
            }
            Document document = documents.get(0);
            document.setEmprunteur(emprunteur);

            if (document.getNombreExemplaires() == 0) {
                throw new DataBaseErrorException(" Il n'y a plus d'exemplaires disponibles pour le document: " + document.getTitre() +
                        " , Emprunt impossible pour : " + emprunteur.getNom() + " id : " + emprunteurId);
            }

            Emprunt emprunt = new Emprunt(dateEmprunt, status, emprunteur);
            em.persist(emprunt);


            EmpruntDetail empruntDetail = new EmpruntDetail(emprunt, document, "2026-11-30", "disponible");
            //a voir pour la date de retour

            em.persist(empruntDetail);

            document.setNombreExemplaires(document.getNombreExemplaires() - 1);

            em.merge(document);

            em.getTransaction().commit();

        }

    }

    public List<Livre> rechercherLivre(String titre, String auteur) throws DataBaseErrorException {
        try (EntityManager em = entityManagerFactory.createEntityManager()) {

            em.getTransaction().begin();
            List<Livre> Livres = em.createQuery(
                            "SELECT d FROM Livre d " +
                                    "WHERE lower(d.titre) LIKE lower(:titre) " +
                                    "AND d.auteur = :auteur ", Livre.class)
                    .setParameter("titre", "%" + titre.toLowerCase() + "%")
                    .setParameter("auteur", auteur)
                    .getResultList();

            if (Livres.isEmpty()) {
                throw new DataBaseErrorException("Aucun livre trouvé avec le titre: " + titre + " et l'auteur: " + auteur);
            } else {
                return Livres;
            }


//
        }
    }
}

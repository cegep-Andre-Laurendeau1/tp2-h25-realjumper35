package ca.cal.tp2.Repository;

import ca.cal.tp2.Execption.DataBaseErrorException;
import ca.cal.tp2.Model.Document;
import ca.cal.tp2.Model.Emprunt;
import ca.cal.tp2.Model.EmpruntDetail;
import ca.cal.tp2.Model.Emprunteur;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class EmprunteurRepository  {
    public void NouvelEmprunt(int emprunteurId, int documentId, String dateEmprunt, String status) throws DataBaseErrorException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate2.TP2");
        EntityManager em = emf.createEntityManager();

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
            throw new DataBaseErrorException("Il n'y a plus d'exemplaires disponibles pour le document: " + document.getTitre());
        }

        Emprunt emprunt = new Emprunt(dateEmprunt, status, emprunteur);
        em.persist(emprunt);


        EmpruntDetail empruntDetail = new EmpruntDetail(emprunt, document, "2026-11-30", "disponible");
        //a voir pour la date de retour

        em.persist(empruntDetail);

        document.setNombreExemplaires(document.getNombreExemplaires() - 1);

        em.merge(document);

        em.getTransaction().commit();

        em.close();

    }
}

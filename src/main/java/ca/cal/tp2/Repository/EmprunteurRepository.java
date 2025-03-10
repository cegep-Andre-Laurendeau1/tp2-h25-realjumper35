package ca.cal.tp2.Repository;

import ca.cal.tp2.Model.Document;
import ca.cal.tp2.Model.Emprunt;
import ca.cal.tp2.Model.EmpruntDetail;
import ca.cal.tp2.Model.Emprunteur;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.Date;
import java.util.List;

public class EmprunteurRepository {
    public void ajouterEmprunt(int emprunteurId, int documentId, String dateEmprunt, String status) {
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
                                "LEFT JOIN FETCH d.references " +
                                "WHERE d.documentID = :documentId", Document.class)
                .setParameter("documentId", documentId)
                .getResultList();

        if (documents.isEmpty()) {
            throw new IllegalArgumentException("Document non trouvé avec l'ID: " + documentId);
        }
        Document document = documents.get(0);

        Emprunt emprunt = new Emprunt(dateEmprunt, status, emprunteur);
        em.persist(emprunt);


        EmpruntDetail empruntDetail = new EmpruntDetail();
        empruntDetail.setEmprunt(emprunt);
        empruntDetail.setDocument(document);
        //a voir pour la date de retour
        empruntDetail.setDateRetourPrevue("2026-11-30");
        empruntDetail.setStatus("disponible");

        em.persist(empruntDetail);

        em.getTransaction().commit();

        em.close();

    }
}

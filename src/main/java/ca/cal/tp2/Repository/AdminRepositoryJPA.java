package ca.cal.tp2.Repository;

import ca.cal.tp2.Model.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class AdminRepositoryJPA implements IAdminRepository {
    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hibernate2.TP2");

    @Override
    public void CreerEmprunteur(Emprunteur emprunteur) {
        String nom = emprunteur.getName();
        String email = emprunteur.getEmail();
        String phone = emprunteur.getPhoneNumber();

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate2.TP2");
        try (EntityManager em = entityManagerFactory.createEntityManager()) {


            em.getTransaction().begin();

//        final Query query = em.createQuery("SELECT u FROM Utilisateur u WHERE u.name = :name");
//        query.setParameter("name", nom);
//        final List<Utilisateur> utilisateurs = query.getResultList();
//        if (utilisateurs.isEmpty()) {
//            em.persist(new Utilisateur(nom, email, phone));
//        }

            em.persist(new Emprunteur(nom, email, phone));

            em.getTransaction().commit();

            em.close();
            emf.close();
        } catch (RuntimeException e) {
            System.out.println("erreur BD" + e.getMessage());
        }
//        return emprunteur;
    }


    @Override
    public Utilisateur getEmprunteur(int userID) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate2.TP2");
        EntityManager em = emf.createEntityManager();

        Utilisateur utilisateur = em.find(Utilisateur.class, userID);

        em.close();
        emf.close();

        return utilisateur;
    }


    @Override
    public void ajouterCD(String titre, int NE, String artiste, int duree, String genre) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate2.TP2");
        EntityManager em = emf.createEntityManager();


        List<Document> Documents = em.createQuery("SELECT d FROM Document d" +
                        " WHERE d.titre = :titre", Document.class)
                .setParameter("titre", titre).getResultList();
        if (!Documents.isEmpty()) {
            Document DocumentExistant = Documents.get(0);
            DocumentExistant.setNombreExemplaires(DocumentExistant.getNombreExemplaires() + NE);
            em.merge(DocumentExistant);
        } else {
            em.getTransaction().begin();
            em.persist(new CD(titre, NE, artiste, duree, genre));
        }

        em.getTransaction().commit();

        em.close();
        emf.close();
    }

    @Override
    public void ajouterDVD(String titre, int NE, String realisateur, int duree, String genre) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate2.TP2");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(new DVD(titre, NE, realisateur, duree, genre));
        em.getTransaction().commit();
        em.close();
        emf.close();
    }

    @Override
    public void ajouterLivre(String titre, int nombreExemplaires, String ISBN, String auteur, String editeur, int nombrePages) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate2.TP2");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(new Livre(titre, nombreExemplaires, ISBN, auteur, editeur, nombrePages));
        em.getTransaction().commit();
        em.close();
        emf.close();
    }


}

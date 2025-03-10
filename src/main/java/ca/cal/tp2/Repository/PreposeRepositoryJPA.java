package ca.cal.tp2.Repository;

import ca.cal.tp2.Model.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class PreposeRepositoryJPA implements IPreposeRepository {
    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hibernate2.TP2");


    @Override
    public void CreerEmprunteur(Emprunteur emprunteur) {
//        String nom = emprunteur.getName();
//        String email = emprunteur.getEmail();
//        String phone = emprunteur.getPhoneNumber();
//
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate2.TP2");
//        try (EntityManager em = entityManagerFactory.createEntityManager()) {
//
//
//            em.getTransaction().begin();
//
//            List<Utilisateur> Utilisateurs = em.createQuery("SELECT u FROM Utilisateur u WHERE u.name = :name")
//                    .setParameter("name", nom).getResultList();
//            if (Utilisateurs.isEmpty()) {
////                em.persist(new Utilisateur(nom, email, phone));
//            }
//
//            em.persist(new Emprunteur(nom, email, phone));
//
//            em.getTransaction().commit();
//
//            em.close();
//            emf.close();
//        } catch (RuntimeException e) {
//            System.out.println("erreur BD" + e.getMessage());
//        }
//
//    / /        return emprunteur;
    }
    @Override
    public void CreerUtilisateur(Utilisateur utilisateur) {
        try (EntityManager em = entityManagerFactory.createEntityManager()) {
            em.getTransaction().begin();
            em.persist(utilisateur);
            em.getTransaction().commit();
        }


    }
    @Override
    public void CreerEmprunteur(String name, String email, String phoneNumber) {
        Emprunteur emprunteur = new Emprunteur(name, email, phoneNumber);
        CreerUtilisateur(emprunteur);
    }
    @Override
    public void CreerPrepose(String name, String email, String phoneNumber) {
        Prepose prepose = new Prepose(name, email, phoneNumber);
        CreerUtilisateur(prepose);
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

    public void CreerDocument(Document document) {
        try (EntityManager em = entityManagerFactory.createEntityManager()) {

            List<Document> Documents = em.createQuery("SELECT d FROM Document d" +
                            " WHERE d.titre = :titre", Document.class)
                    .setParameter("titre", document.getTitre()).getResultList();

            if (!Documents.isEmpty()) {
                Document DocumentExistant = Documents.get(0);
                DocumentExistant.setNombreExemplaires(DocumentExistant.getNombreExemplaires() + document.getNombreExemplaires());
                em.getTransaction().begin();
                em.merge(DocumentExistant);
                em.getTransaction().commit();
            } else {

                em.getTransaction().begin();
                em.persist(document);
                em.getTransaction().commit();
            }
        }
    }

    @Override
    public void CreerCD(String titre, int NE, String artiste, int duree, String genre) {
        CD cd = new CD(titre, NE, artiste, duree, genre);
        CreerDocument(cd);
    }

    @Override
    public void CreerDVD(String titre, int NE, String realisateur, int duree, String genre) {
        DVD dvd = new DVD(titre, NE, realisateur, duree, genre);
        CreerDocument(dvd);
    }

    @Override
    public void CreerLivre(String titre, int nombreExemplaires, String ISBN, String auteur, String editeur, int nombrePages) {
        Livre livre = new Livre(titre, nombreExemplaires, ISBN, auteur, editeur, nombrePages);
        CreerDocument(livre);
    }


}

package ca.cal.tp2.Repository;

import ca.cal.tp2.Model.Utilisateur;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.List;

public class AdminRepositoryJPA implements IAdminRepository {
    @Override
    public Utilisateur CreerEmprunteur(Utilisateur user) {
        String nom = user.getName();
        String email = user.getEmail();
        String phone = user.getPhoneNumber();

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate2.TP2");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

//        final Query query = em.createQuery("SELECT u FROM Utilisateur u WHERE u.name = :name");
//        query.setParameter("name", nom);
//        final List<Utilisateur> utilisateurs = query.getResultList();
//        if (utilisateurs.isEmpty()) {
//            em.persist(new Utilisateur(nom, email, phone));
//        }

        em.persist(new Utilisateur(nom, email, phone));

        em.getTransaction().commit();

        em.close();
        emf.close();

        return user;
    }

    @Override
    public Utilisateur getEmprunteur(int userID) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate2.TP1");
        EntityManager em = emf.createEntityManager();

        Utilisateur utilisateur = em.find(Utilisateur.class, userID);

        em.close();
        emf.close();

        return utilisateur;
    }
}

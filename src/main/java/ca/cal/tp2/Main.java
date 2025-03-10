package ca.cal.tp2;

import ca.cal.tp2.Repository.PreposeRepositoryJPA;
import ca.cal.tp2.Repository.EmprunteurRepository;
import ca.cal.tp2.Service.PreposeServices;
import ca.cal.tp2.Service.EmprunteurServices;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws InterruptedException, SQLException {

        final PreposeServices preposeServices = new PreposeServices(new PreposeRepositoryJPA());
        final EmprunteurServices emprunteurServices = new EmprunteurServices(new EmprunteurRepository());


        TcpServer.startTcpServer();
//        JDBCclass.createDatabase();
        System.out.println("");


//        System.out.println("JDBC");
//        System.out.println("Ajouter un utilisateur, retour de l'id :");
//
//        Utilisateur Usercree = adminServices.AjouterEmprunteur("Yohan", "Le Gal", "23212365522");
//        System.out.println( "id creer pendant l'operation : "+ Usercree.getUserID());
//        System.out.println(Usercree.getName());
//        System.out.println(Usercree.getEmail());
//        System.out.println(Usercree.getPhoneNumber());
//
//        System.out.println("");
//
//
//
//        System.out.println("Trouver un utilisateur :");
//        Utilisateur utilisateurTrouve = adminServices.TrouverEmprunteur(1);
//        System.out.println(utilisateurTrouve.getUserID());
//        System.out.println(utilisateurTrouve.getName());
//        System.out.println(utilisateurTrouve.getEmail());
//        System.out.println(utilisateurTrouve.getPhoneNumber());
//
//
//        System.out.println("");
//        System.out.println("Test de l'utilisateur 2 n'existe pas ");
//        adminServices.TrouverEmprunteur(2);
//
//
//        Thread.currentThread().join();


        System.out.println("JPA/Hibernate");
        System.out.println("Ajouter un empruteur :");
        preposeServices.CreerEmprunteur("Yohan", "Le Gal", "23212365522");
        preposeServices.CreerEmprunteur("Briac", "poogman", "45656456456");

        preposeServices.AjouterCD("CD1", 6, "Artiste1", 60, "Genre1");
        preposeServices.AjouterCD("CD1", 7, "Artiste1", 60, "Genre1");

        preposeServices.AjouterCD("CD2", 7, "Artiste2", 70, "Genre2");
        preposeServices.AjouterDVD("DVD1", 7, "Realisateur1", 120, "Genre1");
        preposeServices.AjouterDVD("DVD2", 8, "Realisateur2", 130, "Genre2");
        preposeServices.AjouterLivre("Livre1", 8, "ISBN1", "Auteur1", "Editeur1", 100);
        preposeServices.AjouterLivre("Livre2", 1, "ISBN2", "Auteur2", "Editeur2", 110);

        emprunteurServices.NouvelEmprunt(1, 1, "2020-01-01", "ok");
        emprunteurServices.NouvelEmprunt(1, 2, "2020-01-02", "ok");
        //emprunteurServices.NouvelEmprunt(1, 6, "2020-01-03", "ok");
        emprunteurServices.NouvelEmprunt(2, 6, "2020-01-04", "ok");

        System.out.println("FIN");
    }
}

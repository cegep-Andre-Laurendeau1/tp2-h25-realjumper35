package ca.cal.tp2;

import ca.cal.tp2.Repository.AdminRepositoryJPA;
import ca.cal.tp2.Service.AdminServices;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws InterruptedException, SQLException {

        final AdminServices adminServices = new AdminServices(new AdminRepositoryJPA());


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
        System.out.println("Ajouter un utilisateur, retour de l'id :");
        adminServices.AjouterEmprunteur("Yohan", "Le Gal", "23212365522");
        adminServices.AjouterEmprunteur("Briac", "puagman", "45656456456");

        adminServices.AjouterCD("CD1", 6, "Artiste1", 60, "Genre1");
        adminServices.AjouterCD("CD2", 7, "Artiste2", 70, "Genre2");
        adminServices.AjouterDVD("DVD1", 7, "Realisateur1", 120, "Genre1");
        adminServices.AjouterDVD("DVD2", 8, "Realisateur2", 130, "Genre2");
        adminServices.AjouterLivre("Livre1", 8, "ISBN1", "Auteur1", "Editeur1", 100);
        adminServices.AjouterLivre("Livre2", 9, "ISBN2", "Auteur2", "Editeur2", 110);


    }
}

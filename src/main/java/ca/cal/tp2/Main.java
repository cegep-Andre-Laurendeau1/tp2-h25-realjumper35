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

        adminServices.AjouterCD("CD1", 1, "Artiste1", 60, "Genre1");


    }
}

package ca.cal.tp2;

import ca.cal.tp2.Execption.DataBaseErrorException;
import ca.cal.tp2.Model.Livre;
import ca.cal.tp2.Repository.PreposeRepositoryJPA;
import ca.cal.tp2.Repository.EmprunteurRepository;
import ca.cal.tp2.Service.PreposeServices;
import ca.cal.tp2.Service.EmprunteurServices;

import java.sql.SQLException;
import java.util.List;

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

//        ajoute 2 fois meme cd1 = addition des quantités
        preposeServices.AjouterCD("Racine Carré", 6, "Stromae", 130, "POP");
        preposeServices.AjouterCD("Racine Carré", 8, "Stromae", 130, "POP");

        preposeServices.AjouterCD("breakfast in america", 7, "Supertramp", 120, "ROCK");

        preposeServices.AjouterDVD("SpiderMan", 7, "Sam Raimi", 260, "SF");
        preposeServices.AjouterDVD("DUNE: Partie 1", 8, "Denis Villeneuve", 500, "SF");
        preposeServices.AjouterLivre("1984", 8, "ISBN1", "George Orwell", "la petite maison", 100);
        preposeServices.AjouterLivre("Game of thrones : Volume 1", 1, "ISBN2", "martins", "la gros maison", 158);
        preposeServices.AjouterLivre("Game of thrones : Volume 1500", 156, "ISBN3", "martins", "la gros maison", 15820);


        emprunteurServices.NouvelEmprunt(1, 1, "2020-01-01", "ok");
        emprunteurServices.NouvelEmprunt(1, 2, "2020-01-02", "ok");
        // emprunteurServices.NouvelEmprunt(1, 1, "2020-01-03", "ok");


        emprunteurServices.NouvelEmprunt(2, 6, "2020-01-04", "ok");
//        nb exemplaire = 0

        emprunteurServices.NouvelEmprunt(1, 6, "2020-01-03", "ok");

//Trouver Livre TEST
        emprunteurServices.TrouverLivre("1984", "George Orwell");

        emprunteurServices.TrouverLivre("dmaldmalk", "asdmklamdlkas");

        emprunteurServices.TrouverLivre("game", "martins");

//TrouverCD
        emprunteurServices.TrouverCD("Racine Carré", "Stromae");
//TrouverDVD
        emprunteurServices.TrouverDVD("SpiderMan", "Sam Raimi");


        System.out.println("FIN");
    }
}

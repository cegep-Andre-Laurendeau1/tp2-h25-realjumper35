package ca.cal.tp2;

import org.h2.jdbc.JdbcSQLSyntaxErrorException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCclass {

    static final String DB_URL = "jdbc:h2:mem:TP2;DB_CLOSE_DELAY=-1";
    static final String USER = "sa";
    static final String PASS = "";

    static {
        // STEP 1: Register JDBC driver
        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public static void createDatabase() {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement statement = conn.createStatement()) {

            System.out.println("Connexion à la base de données...");

            //  table Utilisateur
            String sqlUtilisateur = "CREATE TABLE Utilisateur ("
                    + "user_id INT AUTO_INCREMENT PRIMARY KEY, "
                    + "name VARCHAR(100) NOT NULL, "
                    + "email VARCHAR(100) UNIQUE NOT NULL, "
                    + "phone_number VARCHAR(20))";
            statement.executeUpdate(sqlUtilisateur);

            // table Emprunteur
            String sqlEmprunteur = "CREATE TABLE Emprunteur ("
                    + "emprunteur_id INT PRIMARY KEY, "
                    + "FOREIGN KEY (emprunteur_id) REFERENCES Utilisateur(user_id) ON DELETE CASCADE)";
            statement.executeUpdate(sqlEmprunteur);

            // table Prepose
            String sqlPrepose = "CREATE TABLE Prepose ("
                    + "prepose_id INT PRIMARY KEY, "
                    + "FOREIGN KEY (prepose_id) REFERENCES Utilisateur(user_id) ON DELETE CASCADE)";
            statement.executeUpdate(sqlPrepose);

        } catch (SQLException e) {
            System.err.println("Erreur lors de la création des tables : " + e.getMessage());
            e.printStackTrace();
        }
        System.out.println("Tables créées avec succès");
    }
}




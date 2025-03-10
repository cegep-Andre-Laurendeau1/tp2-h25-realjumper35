package ca.cal.tp2.Repository;

import ca.cal.tp2.Model.Emprunteur;
import ca.cal.tp2.Model.Utilisateur;

import java.sql.*;

public class PreposeRepositoryJDBC implements IPreposeRepository {
    static final String DB_URL = "jdbc:h2:mem:TP1;DB_CLOSE_DELAY=-1";
    static final String USER = "sa";
    static final String PASS = "";

    static Connection conn = null;
    static Statement statement = null;


    @Override
    public void CreerEmprunteur(Emprunteur user) {
        String sqlInsertUser = "INSERT INTO Utilisateur (name, email, phone_number) VALUES (?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement prepStmt = conn.prepareStatement(sqlInsertUser, Statement.RETURN_GENERATED_KEYS)) {

            prepStmt.setString(1, user.getName());
            prepStmt.setString(2, user.getEmail());
            prepStmt.setString(3, user.getPhoneNumber());
            prepStmt.executeUpdate();

            ResultSet rs = prepStmt.getGeneratedKeys();

            if (rs.next()) {
                int userId = rs.getInt(1);
                user.setUserID(userId);

                String sqlInsertEmprunteur = "INSERT INTO Emprunteur (emprunteur_id) VALUES (?)";
                try (PreparedStatement pstmtRole = conn.prepareStatement(sqlInsertEmprunteur)) {
                    pstmtRole.setInt(1, userId);
                    pstmtRole.executeUpdate();
                }
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de l'insertion de l'utilisateur : " + e.getMessage());
//            return null;
        }

//        return user;
    }


    @Override
    public void CreerUtilisateur(Utilisateur utilisateur) {

    }

    @Override
    public void CreerEmprunteur(String name, String email, String phoneNumber) {

    }

    @Override
    public void CreerPrepose(String name, String email, String phoneNumber) {

    }

    @Override
    public Utilisateur getEmprunteur(int userID) {
        String sql = "SELECT * FROM Utilisateur WHERE user_id = ?";
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement prepStmt = conn.prepareStatement(sql)) {

            prepStmt.setInt(1, userID);
            ResultSet rs = prepStmt.executeQuery();

            if (rs.next()) {
                Utilisateur user = new Emprunteur(
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("phone_number")
                );
                return user;
            } else {
                System.out.println("Aucun utilisateur trouvé avec l'ID : " + userID);
                return null;
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la récupération de l'utilisateur : " + e.getMessage());
            return null;
        }
    }

    @Override
    public void CreerCD(String titre, int NE, String artiste, int duree, String genre) {

    }

    @Override
    public void CreerDVD(String titre, int NE, String realisateur, int duree, String genre) {

    }

    @Override
    public void CreerLivre(String titre, int nombreExemplaires, String ISBN, String auteur, String editeur, int nombrePages) {

    }


}

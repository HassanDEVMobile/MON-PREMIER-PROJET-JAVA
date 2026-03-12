package dao;

import models.Joueur;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class JoueurDAO {
    private static String Joueur_INSERT = "INSERT INTO Joueur (Nationnalite_ID,Nom_Prenom, age,poste,club) VALUES (?,?,?,?,?)";
    private static String Joueur_UPDATE ="UPDATE Joueur SET JoueurID = ?,Nationnalite_ID = ?,Nom_Prenom = ?,age = ?,poste = ?,club = ? WHERE JoueurID = ?";
    private static String Joueur_FINDALL ="SELECT * FROM Joueur ";
    private static String Joueur_FINDONE ="SELECT * FROM Joueur WHERE JoueurID = ? ";
    private static String Joueur_DELETE ="DELETE FROM Joueur WHERE JoueurID = ?";

    private static final String URL_DATABASE="jdbc:mysql://193.203.169.18:3306:/mon_etab_IIT-0410";
    private static final String USERNAME_DATABASE ="root";
    private static final String password_DATABASE ="iit-bassam";
    Connection connection;
    public JoueurDAO(){
        try {
            connection = DriverManager.getConnection(URL_DATABASE,USERNAME_DATABASE,password_DATABASE);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    /**
     * Cette methode nous permettra d'ajouter un Joueur dans la competitions
     * @param Nationnalite_ID
     * @return
     */
    public Joueur add(int Nationnalite_ID, String Nom_Prenom, int age, String poste, String club){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(Joueur_INSERT);
            preparedStatement.setInt(1,Nationnalite_ID);
            preparedStatement.setString(2,Nom_Prenom);
            preparedStatement.setInt(3,age);
            preparedStatement.setString(4,poste);
            preparedStatement.setString(5,club);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }


    /**
     * Cette methode nous permettra de modifier un joueur grace a son identifiant
     * @param Nationnalite_ID
     */
    public void update(int JoueurID,int Nationnalite_ID,String Nom_Prenom,int age,String poste,String club){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(Joueur_UPDATE);
            preparedStatement.setInt(1,JoueurID);
            preparedStatement.setInt(2,Nationnalite_ID);
            preparedStatement.setString(3,Nom_Prenom);
            preparedStatement.setInt(4,age);
            preparedStatement.setString(5,poste);
            preparedStatement.setString(6,club);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * Cette methode nous permettra de recherher un joueur
     * @param JoueurID
     * @return
     */
    public Joueur findOne(int JoueurID){

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(Joueur_FINDONE);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                JoueurID = resultSet.getInt("JoueurID");
                int Nationnalite_ID = resultSet.getInt("Nationnalite_ID");
                String Nom_Prenom = resultSet.getNString("Nom_Prenom");
                int age = resultSet.getInt("age");
                String poste = resultSet.getNString("poste");
                String club = resultSet.getNString("club");
                Joueur joueur = new Joueur( JoueurID, Nationnalite_ID, Nom_Prenom, age, poste, club);
                return joueur;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    /**
     * Cette methode nous permettra d'afficher la liste des joueurs de la competition
     * @return
     */
    public List<Joueur> findAll(){
        List<Joueur> joueurs = new LinkedList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(Joueur_FINDALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int JoueurID = resultSet.getInt("JoueurID");
                int Nationnalite_ID = resultSet.getInt("Nationnalite_ID");
                String Nom_Prenom = resultSet.getNString("Nom_Prenom");
                int age = resultSet.getInt("age");
                String poste = resultSet.getNString("poste");
                String club = resultSet.getNString("club");
                Joueur joueur = new Joueur( JoueurID, Nationnalite_ID, Nom_Prenom, age, poste, club);
                joueurs.add(joueur);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return joueurs;
    }

    /**
     * Cette methode nous permattra de supprimé un joueur grace a son identifiant
     * @param JoueurID
     */
    public void delete(int JoueurID){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(Joueur_DELETE);
            preparedStatement.setInt(1,JoueurID);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

package dao;

import models.Encadreur;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;


public class EncadreurDAO {
    private static String Encadreur_INSERT ="INSERT INTO Encadreur (Nationnalite_ID, Nom_Prenom, age, role) VALUES (?,?,?,?)";
    private static String Encadreur_UPDATE ="UPDATE Encadreur SET Encad_ID = ?,Nationnalite_ID = ?,Nom_Prenom = ?,age = ?,role = ? WHERE Encad_ID = ?";
    private static String Encadreur_FINDALL ="SELECT * FROM Encadreur";
    private static String Encadreur_FINDONE ="SELECT * FROM Encadreur WHERE Encad_ID = ?";
    private static String Encadreur_DELETE ="DELETE FROM Encadreur WHERE Encad_ID = ?";

    private static final String URL_DATABASE ="jdbc:mysql://193.203.169.18:3306/mon_etab_IIT-0410";
    private static final String USERNAME_DATABASE ="root";
    private static final String password_DATABASE ="iit-bassam";

    Connection connection;
    public EncadreurDAO(){
        try {
            connection = DriverManager.getConnection(URL_DATABASE,USERNAME_DATABASE,password_DATABASE);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    /**
     * Cette methode nous permettra d'ajouter un encadreur
     * @param Nationnalite_ID
     * @param Nom_Prenom
     * @param age
     * @param role
     * @return
     */
    public Encadreur add( int  Nationnalite_ID,String Nom_Prenom,int age,String role){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(Encadreur_INSERT);
            preparedStatement.setInt(1,Nationnalite_ID);
            preparedStatement.setString(2,Nom_Prenom);
            preparedStatement.setInt(3,age);
            preparedStatement.setString(4,role);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }


    /**
     * Cette methode nous permettra de modifier un encadreur
     * @param Encad_ID
     * @param Nationnalite_ID
     * @param Nom_Prenom
     * @param age
     * @param role
     */
    public void update(int Encad_ID, int  Nationnalite_ID,String Nom_Prenom,int age,String role){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(Encadreur_UPDATE);
            preparedStatement.setInt(1,Encad_ID);
            preparedStatement.setInt(2,Nationnalite_ID);
            preparedStatement.setString(3,Nom_Prenom);
            preparedStatement.setInt(4,age);
            preparedStatement.setString(5,role);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    /**
     * Cette methode nous permettra de supprimer un encadreur grace a sont identifiant
     * @param  Encad_ID
     */
    public void delete(int  Encad_ID){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(Encadreur_DELETE);
            preparedStatement.setInt(1,Encad_ID);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * Cette methode nous permettra de lister tous les encadreurs de la competition
     * @return
     */
    public List<Encadreur> findAll(){
        List<Encadreur> encadreurList = new LinkedList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(Encadreur_FINDALL);
            ResultSet resultSet = preparedStatement.getResultSet();
            while(resultSet.next()){
                int Encad_ID = resultSet.getInt("Encad_ID");
                int  Nationnalite_ID = resultSet.getInt("Nationnalite_ID");
                String Nom_Prenom = resultSet.getNString("Nom_Prenom");
                int age = resultSet.getInt("age");
                String role = resultSet.getNString("role");
                Encadreur encadreur = new Encadreur(Encad_ID, Nationnalite_ID, Nom_Prenom, age, role);
                encadreurList.add(encadreur);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return encadreurList;
    }


    /**
     * Cette methode nous permettra de rechercher un encadreur
     * @param  Encad_ID
     * @return
     */
    public Encadreur findOne(int  Encad_ID) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(Encadreur_FINDONE);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Encad_ID = resultSet.getInt("Encad_ID");
                int Nationnalite_ID = resultSet.getInt("Nationnalite_ID");
                String Nom_Prenom = resultSet.getNString("Nom_Prenom");
                int age = resultSet.getInt("age");
                String role = resultSet.getNString("role");
                Encadreur encadreur = new Encadreur(Encad_ID, Nationnalite_ID, Nom_Prenom, age, role);
                return encadreur;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }
}



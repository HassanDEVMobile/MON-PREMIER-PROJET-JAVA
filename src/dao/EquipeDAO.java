package dao;

import models.Equipe;
import models.Match;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class EquipeDAO {

    private static String Equipe_INSERT = "INSERT INTO Equipe (Nom) VALUES (?)";
    private static String Equipe_UPDATE = "UPDATE Equipe SET Nom = ? WHERE id = ?";
    private static String Equipe_FINDALL = "SELECT * FROM Equipe ";
    private static String Equipe_FINDONE = "SELECT * FROM Equipe WHERE id = ";
    private static String Equipe_DELETE = "DELETE FROM Equipe WHERE id = ?";

    private static final String URL_DATABASE ="jdbc:mysql://193.203.169.18:3306:/mon_etab_IIT-0410";
    private static final String USERNAME_DATABASE ="root";
    private static final String password_DATABASE ="iit-bassam";

    Connection connection;
    public EquipeDAO(){
        try {
            connection = DriverManager.getConnection(URL_DATABASE,USERNAME_DATABASE,password_DATABASE);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    /**
     * Ce DAO represente la logique de notre entiteEQUIPE
     * @author Diabagate
     * @Version 1.0
     */
    /**
     * Ctte methode permet de lister les equipes
     * @return List<EQUIEPE>
     */
    public List<Equipe> findALL(){
        List<Equipe> equipesList = new LinkedList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(Equipe_FINDALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                int id = resultSet.getInt("id");
                String Nom = resultSet.getNString("Nom");
                Equipe equipe = new Equipe(id,Nom);
                equipesList.add(equipe);
            }
            return equipesList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * Cette methode permet de supprimer une equipe a partir de son identifiant
     * @param id ce paramettre represente l'identifiant d'une equipe
     */
    public void Delete(int id){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(Equipe_DELETE);
            preparedStatement.setInt(1,id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Cette methode permet d'enregistrer une equipe
     * @param name ce paramettre le nom de l'equipe
     * @return EQUIPE
     */
    public Equipe add(String name){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(Equipe_INSERT);
            preparedStatement.setString(1,name);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public void update(String Nom){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(Equipe_UPDATE);
            preparedStatement.setString(1,Nom);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Equipe findOne(int id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(Equipe_FINDONE);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                id = resultSet.getInt("id");
                String Nom = resultSet.getNString("Nom");
                Equipe equipe = new Equipe(id, Nom);
                return equipe;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

}


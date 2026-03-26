package dao;

import models.Hotel;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class HotelDAO {
    private static String Hotel_INSERT ="INSERT INTO Hotel (Nationnalite_ID, Nom,email,Localisation) VALUES (?,?,?,?)";
    private static String Hotel_UPDATE ="UPDATE Hotel SET Nationnalite_ID = ?,Nom = ?,email = ?,Localisation = ? WHERE HotelID = ?";
    private static String Hotel_FINDALL ="SELECT * FROM Hotel";
    private static String Hotel_FINDONE ="SELECT * FROM Hotel WHERE HotelID = ?";
    private static String Hotel_DELETE ="DELETE FROM Hotel WHERE HotelID = ?";

    private static final String URL_DATABASE="jdbc:mysql://localhost:3306/AppCan2024";
    private static final String USERNAME_DATABASE ="root";
    private static final String password_DATABASE ="";
    Connection connection;
    public HotelDAO(){
        try {
            connection = DriverManager.getConnection(URL_DATABASE,USERNAME_DATABASE,password_DATABASE);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    /**
     * Cette methode nous permettra d'ajouter un hotel
     * @param Nationnalite_ID
     * @param Nom
     * @param email
     * @param Localisation
     * @return
     */
    public Hotel add(int Nationnalite_ID, String Nom, String email, String Localisation){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(Hotel_INSERT);
            preparedStatement.setInt(1,Nationnalite_ID);
            preparedStatement.setString(2,Nom);
            preparedStatement.setString(3,email);
            preparedStatement.setString(4,Localisation);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    /**
     * Cette methode nous permettra de rechercher un hotel
     * @param HotelID
     * @return
     */
    public Hotel findOne(int HotelID){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(Hotel_FINDONE);
            preparedStatement.setInt(1,HotelID);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                HotelID = resultSet.getInt("HotelID");
                int Nationnalite_ID = resultSet.getInt("Nationnalite_ID");
                String Nom = resultSet.getNString("Nom");
                String email = resultSet.getNString("email");
                String Localisation = resultSet.getNString("Localisation");
                Hotel hotel = new Hotel(HotelID,Nationnalite_ID, Nom,email,Localisation);
                return hotel;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }


    /**
     * Cette methode nous permettra de lister tous les Hotels de la competitions
     * @return
     */
    public List<Hotel> findAll(){
        List<Hotel> hotels = new LinkedList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(Hotel_FINDALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                int HotelID = resultSet.getInt("HotelID");
                int Nationnalite_ID = resultSet.getInt("Nationnalite_ID");
                String Nom = resultSet.getNString("Nom");
                String email = resultSet.getNString("email");
                String Localisation = resultSet.getNString("Localisation");
                Hotel hotel = new Hotel(HotelID,Nationnalite_ID, Nom,email,Localisation);
                hotels.add(hotel);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return hotels;
    }


    /***
     * Cettte methode nous permettra de modifier les attributs d'un hotels
     * @param HotelID
     * @param Nationnalite_ID
     * @param Nom
     * @param email
     * @param Localisation
     */
    public void update(int HotelID,int Nationnalite_ID,String Nom,String email,String Localisation){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(Hotel_UPDATE);
            preparedStatement.setInt(1,HotelID);
            preparedStatement.setInt(2,Nationnalite_ID);
            preparedStatement.setString(3,Nom);
            preparedStatement.setString(4,email);
            preparedStatement.setString(5,Localisation);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    /**
     * Cette methode nous permattra de supprimer un Hotel grace a son identifiant
     * @param HotelID
     */
    public void delete(int HotelID){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(Hotel_DELETE);
            preparedStatement.setInt(1,HotelID);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}

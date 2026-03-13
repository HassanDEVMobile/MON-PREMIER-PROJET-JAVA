package dao;
import models.Equipe;
import models.Match;

import java.sql.*;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class MatchDAO {
    private static final String Match_INSERT = "INSERT INTO Match (EquipeDomicileID,EquipeExterieurID,stade,date,poule) VALUES(?,?,?,?,?)";
    private static final String Match_UPDATE = "UPDATE Match SET id = ?,poule = ?,EquipeDomicileID = ?,EquipeExterieurID = ?,stade = ?,date = ? WHERE id= ?";
    private static final String Match_FINDALL = "SELECT*FROM Match";
    private static final String Match_FINDONE = "SELECT*FROM Match WHERE id = ?";
    private static final String Match_DELETE = "DELETE FROM Match WHERE id = ?";

    private static final String URL_DATABASE ="jdbc:mysql://193.203.169.18:3306/mon_etab_IIT-0410";
    private static final String USERNAME_DATABASE ="root";
    private static final String password_DATABASE ="iit-bassam";


    private Connection connection;
    public MatchDAO(){
        try {
             connection = DriverManager.getConnection(URL_DATABASE,USERNAME_DATABASE,password_DATABASE);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    /**
     * Ctte methode permet de lister les Matchs
     * @return List<MATCH>
     */
    public List<Match> findAll(){
        List<Match> Match = new LinkedList<>() ;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(Match_FINDALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String poule = resultSet.getNString("poule");
                int EquipeDomicileID = resultSet.getInt("EquipeDomicileID");
                int EquipeExterieurID = resultSet.getInt("EquipeExterieurID");
                String stade = resultSet.getNString("stade");
                Date date = resultSet.getDate("date");
                Match match = new Match( id ,poule , EquipeDomicileID,EquipeExterieurID ,stade ,date);
                Match.add(match);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Match;
    }

    /**
     * cette methode nous permettra de rechercher une occurence dans la liste
     * @param id
     * @return
     */
    public Match findDone(int id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(Match_FINDONE);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                id = resultSet.getInt("id");
                String poule = resultSet.getNString("poule");
                int EquipeDomicileID = resultSet.getInt("EquipeDomicileID");
                int EquipeExterieurID = resultSet.getInt("EquipeExterieurID");
                String stade = resultSet.getNString("stade");
                Date date = resultSet.getDate("date");
                Match match = new Match(id, poule, EquipeDomicileID, EquipeExterieurID, stade, date);
                return match;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    /**
     * Cette methode permet d'ajouter les Match
     * @param date ce paramettre represente  la date du match
     * @param stade ce paramettre represente la stade de l'equipe
     * @param poule ce paramettre represente la poule de l'equipe
     * @return Ce paramettre permet de returner les Match
     */
    public Match add(int EquipeDomicileID,int EquipeExterieurID , Date date, String stade, String poule){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(Match_INSERT);
            preparedStatement.setInt(1,EquipeDomicileID);
            preparedStatement.setInt(2,EquipeExterieurID);
            preparedStatement.setString(5,poule);
            preparedStatement.setDate(4, (java.sql.Date) date);
            preparedStatement.setString(3,stade);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    /**
     * Cette methode permet de supprimer un Match a partir de son identifiant
     * @param id ce paramettre represente l'identifiant d'un Match
     */
    public void delete(int id){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(Match_DELETE);
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void update(int EquipeDomicileID,int EquipeExterieurID , Date date, String stade, String poule){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(Match_UPDATE);
            preparedStatement.setString(2,poule);
            preparedStatement.setInt(3,EquipeDomicileID);
            preparedStatement.setInt(4,EquipeExterieurID);
            preparedStatement.setString(5,stade);
            preparedStatement.setDate(6, (java.sql.Date) date);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

package dao;
import models.Equipe;
import models.Match;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class MatchDAO {
     private static final String Match_INSERT = "INSERT INTO Match (id,poule,EquipeDomicileID,EquipeExterieurID,stade,date) VALUES(?,?,?,?,?,?)";
     private static final String Match_UPDATE = "UPDATE Match SET id = ?,poule = ?,EquipeDomicileID = ?,EquipeExterieurID = ?,stade = ?,date = ? WHERE id= ?";
     private static final String Match_FINDALL = "SELECT*FROM Match";
     private static final String Match_FINDONE = "SELECT*FROM Match WHERE id = ?";

     private static final String URL_DATABASE ="jdbc:mysql://localhost:3306:/CAN2024";
     private static final String USERNAME_DATABASE ="admin";
     private static final String password_DATABASE ="admin";

     private Connection connection ;

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
            preparedStatement.setString(2,poule.getPoule());
            preparedStatement.setInt(3,EquipeDomicileID.getEquipeExterieurID());
            preparedStatement.setInt(4,EquipeExterieurID.getEquipeExterieurID());
            preparedStatement.setString(5,stade.getStade());
            preparedStatement.setDate(6,date.getDate());
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

    }
    public void update(int EquipeDomicileID,int EquipeExterieurID , Date date, String stade, String poule){

    }
}

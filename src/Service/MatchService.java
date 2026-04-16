package Service;

import dao.MatchDAO;
import models.Match;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

/**
 * Ce service represente la logique de notre entite MATCH
 * @author Diabagate
 * @Version 1.0
 */

public class MatchService {
     MatchDAO matchDOA;

   public MatchService(){
       matchDOA = new MatchDAO();
   }

    /**
     * Cette methode permet de lister les Matchs
     * @return List<MATCH>
     */
    public List<Match> findAll(){

        return matchDOA .findAll();
    }

    public Match findDone(int id){
        return matchDOA .findDone(id);
    }

    /**
     * Cette methode permet d'ajouter les Match
     * @param date ce paramettre represente  la date du match
     * @param stade ce paramettre represente la stade de l'equipe
     * @param poule ce paramettre represente la poule de l'equipe
     * @return Ce paramettre permet de returner les Match
     */
    public Match add(int EquipeDomicileID, int EquipeExterieurID , String stade, String poule, String date){
        return matchDOA.add( EquipeDomicileID,EquipeExterieurID ,stade,poule,date);
    }

    /**
     * Cette methode permet de supprimer un Match a partir de son identifiant
     * @param id ce paramettre represente l'identifiant d'un Match
     */
    public void delete(int id){

        matchDOA .delete(id);
    }

    public void update(int EquipeDomicileID,int EquipeExterieurID,String poule , String stade,String date,int id){
        matchDOA .update( EquipeDomicileID,EquipeExterieurID, poule,stade,date,id);
    }
}

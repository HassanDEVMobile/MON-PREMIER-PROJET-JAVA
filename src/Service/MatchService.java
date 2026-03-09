package Service;

import dao.MatchDAO;
import models.Equipe;
import models.Match;
import java.util.Date;
import java.util.List;

/**
 * Ce service represente la logique de notre entite MATCH
 * @author Diabagate
 * @Version 1.0
 */

public class MatchService {
    private MatchDAO macthDAO = new MatchDAO();
    /**
     * Cette methode permet de lister les Matchs
     * @return List<MATCH>
     */
    public List<Match> findAll(){

        return macthDAO.findAll();
    }

    public Match findDone(int id){
        return macthDAO.findDone(id);
    }

    /**
     * Cette methode permet d'ajouter les Match
     * @param date ce paramettre represente  la date du match
     * @param stade ce paramettre represente la stade de l'equipe
     * @param poule ce paramettre represente la poule de l'equipe
     * @return Ce paramettre permet de returner les Match
     */
    public Match add( int EquipeDomicileID,int EquipeExterieurID , Date date, String stade, String poule){
        return macthDAO.add( EquipeDomicileID,EquipeExterieurID ,date,stade,poule);
    }

    /**
     * Cette methode permet de supprimer un Match a partir de son identifiant
     * @param id ce paramettre represente l'identifiant d'un Match
     */
    public void delete(int id){

        macthDAO.delete(id);
    }

    public void update(int EquipeDomicileID,int EquipeExterieurID , Date date, String stade, String poule){
        macthDAO.update( EquipeDomicileID,EquipeExterieurID ,date,stade,poule);
    }
}

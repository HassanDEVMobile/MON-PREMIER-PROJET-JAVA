package dao;

import models.Equipe;
import models.Match;

import java.util.Date;
import java.util.List;

public class MatchDAO {

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

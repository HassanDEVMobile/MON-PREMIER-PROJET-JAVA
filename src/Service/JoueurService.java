package Service;

import dao.JoueurDAO;
import models.Joueur;

import java.util.List;

public class JoueurService {

    JoueurDAO joueurDAO = new JoueurDAO();
    /**
     * Cette methode nous permettra d'ajouter un Joueur dans la competitions
     * @param Nationnalite_ID
     * @return
     */
    public Joueur add(int Nationnalite_ID,String Nom_Prenom,int age,String poste,String club){
        return joueurDAO.add(Nationnalite_ID,Nom_Prenom, age,poste,club);
    }


    /**
     * Cette methode nous permettra de modifier un joueur grace a son identifiant
     * @param Nationnalite_ID
     */
    public void update(int JoueurID,int Nationnalite_ID,String Nom_Prenom,int age,String poste,String club){
        joueurDAO.update(JoueurID,Nationnalite_ID,Nom_Prenom, age,poste,club);
    }

    /**
     * Cette methode nous permettra de recherher un joueur
     * @param JoueurID
     * @return
     */
    public Joueur findOne(int JoueurID){

        return joueurDAO.findOne(JoueurID);
    }

    /**
     * Cette methode nous permettra d'afficher la liste des joueurs de la competition
     * @return
     */
    public List<Joueur> findAll(){

        return joueurDAO.findAll();
    }

    /**
     * Cette methode nous permattra de supprimé un joueur grace a son identifiant
     * @param JoueurID
     */
    public void delete(int JoueurID){
        joueurDAO.delete(JoueurID);
    }
}

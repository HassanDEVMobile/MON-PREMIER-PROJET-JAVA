package Service;

import dao.EncadreurDAO;
import models.Encadreur;

import java.util.List;

public class EncadreurService {

    EncadreurDAO encadreurDAO;
    public EncadreurService(){
        encadreurDAO = new EncadreurDAO();
    }

    /**
     * Cette methode nous permettra d'ajouter un encadreur
     *
     * @param Nationnalite_ID
     * @param Nom_Prenom
     * @param age
     * @param role
     * @return
     */
    public Encadreur add(int Nationnalite_ID, String Nom_Prenom, int age, String role) {
        return encadreurDAO.add(Nationnalite_ID, Nom_Prenom, age, role);
    }


    /**
     * Cette methode nous permettra de modifier un encadreur
     *
     * @param Encad_ID
     * @param Nationnalite_ID
     * @param Nom_Prenom
     * @param age
     * @param role
     */
    public void update(int Encad_ID, int Nationnalite_ID, String Nom_Prenom, int age, String role) {
        encadreurDAO.update(Encad_ID,Nationnalite_ID, Nom_Prenom, age,role );
    }


    /**
     * Cette methode nous permettra de supprimer un encadreur grace a sont identifiant
     *
     * @param Encad_ID
     */
    public void delete(int Encad_ID) {
        encadreurDAO.delete(Encad_ID);
    }


    /**
     * Cette methode nous permettra de lister tous les encadreurs de la competition
     *
     * @return
     */
    public List<Encadreur> findAll() {

        return encadreurDAO.findAll();
    }


    /**
     * Cette methode nous permettra de rechercher un encadreur
     *
     * @param Encad_ID
     * @return
     */
    public Encadreur findOne(int Encad_ID) {
        return encadreurDAO.findOne(Encad_ID);
    }

}

package Service;

import dao.HotelDAO;
import models.Hotel;

import java.util.List;

public class HotelService {

   HotelDAO hotelDAO = new HotelDAO();
    /**
     * Cette methode nous permettra d'ajouter un hotel
     * @param Nationnalite_ID
     * @param Nom
     * @param email
     * @param Localisation
     * @return
     */
    public Hotel add(int Nationnalite_ID,String Nom,String email,String Localisation){

        return hotelDAO.add(Nationnalite_ID, Nom,email,Localisation);
    }

    /**
     * Cette methode nous permettra de rechercher un hotel
     * @param HotelID
     * @return
     */
    public Hotel findOne(int HotelID){

        return hotelDAO.findOne(HotelID);
    }


    /**
     * Cette methode nous permettra de lister tous les Hotels de la competitions
     * @return
     */
    public List<Hotel> findAll(){

        return hotelDAO.findAll();
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
         hotelDAO.update(HotelID,Nationnalite_ID, Nom,email,Localisation);
    }


    /**
     * Cette methode nous permattra de supprimer un Hotel grace a son identifiant
     * @param HotelID
     */
    public void delete(int HotelID){
        hotelDAO.delete(HotelID);
    }
}

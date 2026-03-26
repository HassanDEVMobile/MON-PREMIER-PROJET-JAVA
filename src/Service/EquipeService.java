package Service;

import dao.EquipeDAO;
import models.Equipe;
import java.util.List;

public class EquipeService {
     EquipeDAO equipeDAO;
     public EquipeService(){
         equipeDAO = new EquipeDAO();
     }

    /**
     * Ce service represente la logique de notre entiteEQUIPE
     * @author Diabagate
     * @Version 1.0
     */
        /**
         * Ctte methode permet de lister les equipes
         * @return List<EQUIEPE>
         */
        public List<Equipe> findALL(){

            return equipeDAO.findALL();
        }

        /**
         * Cette methode permet de supprimer une equipe a partir de son identifiant
         * @param id ce paramettre represente l'identifiant d'une equipe
         */
        public void Delete(int id){
            equipeDAO.Delete(id);
        }

        /**
         * Cette methode permet d'enregistrer une equipe
         * @param name ce paramettre le nom de l'equipe
         * @return EQUIPE
         */
        public Equipe add(String name){

            return equipeDAO.add(name);
        }

      public void update(int id,String Nom){
            equipeDAO.update(id,Nom);
      }

      public Equipe findOne(int id){
            return equipeDAO.findOne(id);
      }
}

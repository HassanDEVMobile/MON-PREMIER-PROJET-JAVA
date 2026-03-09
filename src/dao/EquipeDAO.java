package dao;

import models.Equipe;

import java.util.List;

public class EquipeDAO {

    private static String Equipe_INSERT = "INSERT INTO Equipe (id,Nom) VALUES (?,?)";
    private static String Equipe_UPDATE = "UPDATE Equipe SET id = ? , Nom = ? WHERE id = ?";
    private static String Equipe_FINDALL = "SELECT * FROM Equipe ";
    private static String Equipe_FINDONE = "SELECT * FROM Equipe WHERE id = ";
    private static String Equipe_DELETE = "DELETE FROM Equipe";
    /**
     * Ce DAO represente la logique de notre entiteEQUIPE
     * @author Diabagate
     * @Version 1.0
     */
    /**
     * Ctte methode permet de lister les equipes
     * @return List<EQUIEPE>
     */
    public List<Equipe> findALL(){
        return null;
    }

    /**
     * Cette methode permet de supprimer une equipe a partir de son identifiant
     * @param id ce paramettre represente l'identifiant d'une equipe
     */
    public void Delete(int id){

    }

    /**
     * Cette methode permet d'enregistrer une equipe
     * @param name ce paramettre le nom de l'equipe
     * @return EQUIPE
     */
    public Equipe add(String name){

        return null;
    }

    public void update(String name){

    }

}

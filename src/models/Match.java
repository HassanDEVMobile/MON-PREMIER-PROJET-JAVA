package models;

import java.time.LocalDate;
import java.util.Date;

public class Match {


     int id;
     String poule;
     int EquipeDomicileID;
     int EquipeExterieurID;
     String stade;
     String date;

     public Match(int EquipeDomicileID,int EquipeExterieurID ,String poule,String stade,String date){
         this.EquipeDomicileID = EquipeDomicileID;
         this.EquipeExterieurID = EquipeExterieurID;
         this.poule = poule;
         this.stade = stade;
         this.date = date;
     }

     public Match(int id ,int EquipeDomicileID,int EquipeExterieurID ,String poule,String stade,String date){
         this.id = id;
         this.EquipeDomicileID = EquipeDomicileID;
         this.EquipeExterieurID = EquipeExterieurID;
         this.poule = poule;
         this.stade = stade;
         this.date = date;
     }

    @Override
    public String toString() {
        return """
                """.formatted();
    }

    public Match(int i, String poule, int equipeDomicileID, int id, String stade, Date date){
         this.id = id;
     }

}
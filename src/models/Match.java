package models;

import java.util.Date;

public class Match {


     int id;
     String poule;
     int EquipeDomicileID;
     int EquipeExterieurID;
     String stade;
     Date date;

     public Match(int id ,String poule , int EquipeDomicileID,int EquipeExterieurID ,String stade ,Date date){
         this.id = id;
         this.poule = poule;
         this.EquipeDomicileID = EquipeDomicileID;
         this.EquipeExterieurID = EquipeExterieurID;
         this.stade = stade;
         this.date = date;
     }

}
package models;

import java.util.Date;
import java.util.List;

public class Match {


   private int id;
   private  String poule;
   private int EquipeDomicileID ;
   private int EquipeExterieurID;
   private String stade;
   private Date date;

    public int getId() {
        return id;
    }
    public String getPoule(){
        return poule;
    }
    public int getEquipeDomicileID(){
        return EquipeDomicileID;
    }
    public int getEquipeExterieurID(){
        return EquipeExterieurID;
    }

    public String getStade() {
        return stade;
    }

    public Date getDate() {
        return date;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPoule(String poule) {
        this.poule = poule;
    }

    public void setEquipeDomicileID(int equipeDomicileID) {
        this.EquipeDomicileID = equipeDomicileID;
    }

    public void setEquipeExterieurID(int equipeExterieurID) {
        this.EquipeExterieurID = EquipeExterieurID;
    }

    public void setStade(String stade) {
        this.stade = stade;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}

package models;

public class Hotel {
    int HotelID;
    int Nationnalite_ID;
    String Nom;
    String emails;
    String Localisation;

    public Hotel(int HotelID,int Nationnalite_ID,String Nom,String email,String Localisation){
        this.HotelID = HotelID;
        this.Nationnalite_ID = Nationnalite_ID;
        this.Nom = Nom;
        this.emails = emails;
        this.Localisation = Localisation;
    }

    public String toString(){
        return """
                ID : %s
                NATION ID : %s 
                HOTEL NOM : %s
                EMAILS : %s 
                LOCALISATION : %s
                """.formatted(HotelID,Nationnalite_ID,Nom,emails,Localisation);
    }


}

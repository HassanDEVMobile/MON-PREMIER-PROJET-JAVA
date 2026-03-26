package models;

public class Joueur {
    int JoueurID;
    int Nationnalite_ID;
    String Nom_Prenom;
    int age;
    String poste;
    String club;

    public Joueur(int JoueurID,int Nationnalite_ID,String Nom_Prenom,int age,String poste,String club){
        this.JoueurID = JoueurID;
        this.Nationnalite_ID = Nationnalite_ID;
        this.Nom_Prenom = Nom_Prenom;
        this.age = age;
        this.club = club;
        this.poste = poste;
        this.club = club;
    }

    public String toString(){
        return """
                ID :%s
                NATION ID : %s
                NOM ET PRENOM : %s
                age : %s
                poste : %s
                club : %s
                """.formatted(JoueurID,Nationnalite_ID, Nom_Prenom,age,poste, club);
    }



}

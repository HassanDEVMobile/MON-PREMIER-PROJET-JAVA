package models;

public class Encadreur {
    int Encad_ID;
    int  Nationnalite_ID;
    String Nom_Prenom;
    int age;
    String role;

    public Encadreur(int Encad_ID, int Nationnalite_ID, String Nom_Prenom, int age, String role){
        this.Encad_ID =Encad_ID;
        this.Nationnalite_ID = Nationnalite_ID;
        this.Nom_Prenom = Nom_Prenom;
        this.age = age;
        this.role = role;
    }
}

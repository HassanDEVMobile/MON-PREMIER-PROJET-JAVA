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

    public String toString(){
        return """
                ID : %s
                NATION ID : %s
                Nom_PRENOM : %s
                AGE : %s
                ROLE : %s
                """.formatted(Encad_ID,Nationnalite_ID,Nom_Prenom,age,role);
    }
}

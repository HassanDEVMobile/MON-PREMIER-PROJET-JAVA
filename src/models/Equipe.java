package models;

public class Equipe {

   int id;
   String Nom;
   public Equipe(int id , String Nom){
      this.id = id;
      this.Nom = Nom;
   }
   public Equipe(String Nom){
      this.Nom = Nom;
   }
   public Equipe(){

   }
   public String toString(){
      return """
              ID : %s , Nom : %s
              """.formatted(id,Nom);

   }
}

import Service.EquipeService;
import Service.MatchService;
import models.Equipe;
import models.Match;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Scanner;


public class Main {
    Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int choix = -1;

            do {
                String MenuPrincipal = """
                    ==================================
                            MENU PRINCIPAL 
                    ==================================
                    1-MATCHS
                    2-EQUIPES
                    3-QUITTER LE PROGRAMME    
                    """;
                System.out.println(MenuPrincipal);
                List<Integer> choixpossibles = Arrays.asList(1, 2, 3);
                do{
                    try {
                        Scanner sc = new Scanner(System.in);
                        System.out.println("Veuillez faire un choix :");
                        choix = sc.nextInt();
                        if(!choixpossibles.contains(choix)){
                            System.out.println("Choix invalide");
                        }

                    } catch (Exception e) {
                        System.out.println("Merci De saisir une valeur numérique");
                    }
                }while(! choixpossibles.contains(choix));
                if (choix==1){
                    sousmenuMatchs();
                } else if (choix==2) {
                    sousmenuEQUIPES();
                }
            } while (choix != 3);
    }
    static void sousmenuMatchs() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        int choix1 = -1;
        do {
            String MenuMatchs = """
                    =======================================
                                 MENU MATCHS
                    =======================================
                    1-Ajouter un Matchs
                    2-Supprimer un Matchs
                    3-Afficher tous les matchs
                    4-Modifier Match
                    0-Retour Au Menu principal
                    """;
            System.out.println(MenuMatchs);
            List<Integer> choixpossibles1 = Arrays.asList(1,2,3,4,0);
            MatchService matchs = new MatchService();
            do {
                Scanner sc = new Scanner(System.in);
                try {
                    System.out.println("Veuillez faire un choix :");
                    choix1 = sc.nextInt();
                    if(!choixpossibles1.contains(choix1)){
                        System.out.println("Choix invalide");
                    }
                } catch (Exception e) {
                    System.out.println("Merci De saisir une valeur numérique");
                }
            } while (!choixpossibles1.contains(choix1));
            Scanner sc = new Scanner(System.in);
            if(choix1==1){
                Matchaddandupdate();
                System.out.println("ENREGISTREMENT EFFECTUER AVEC SUCCES");
            } else if (choix1 == 2) {
                System.out.println("Veuillez saisir l'Id du Match a supprimer :");
                int Id = 0;
                VERIFICATIONSAISIE(Id);
                matchs.delete(Id);
                System.out.println("Matchs Supprimer avec succes");
            }
             else if(choix1==3){
              List<Match> match = matchs.findAll();
                System.out.println(match);
            }
             else if(choix1==4){
                System.out.println("Veuillez saisir l'Id du Matchs a Modifier :");
                int ID = 0;
                VERIFICATIONSAISIE(ID);
                Matchaddandupdate();
                System.out.println("MODIFICATION EFFECTUER AVEC SUCCES");
            }
        }while(choix1 != 0);
    }

    static void sousmenuEQUIPES(){
          int choix2=-1;
          do{
              String sousmenuEquipes= """
                      ====================================
                               MENU EQUIPES
                      ====================================
                      1-Ajouter une Equipe
                      2-Supprimer une Equipe
                      3-Lister toutes les Equipes
                      4-Modifier une Equipe
                      5-Retour Au Menu principal
                      """;
              System.out.println(sousmenuEquipes);
              List<Integer> choixpossibles2 = Arrays.asList(1,2,3,4,5);
              EquipeService equipe = new EquipeService();
              do{
                  try {
                      Scanner sc = new Scanner(System.in);
                      System.out.println("Veuillez faire un choix :");
                      choix2 = sc.nextInt();
                      if(!choixpossibles2.contains(choix2)){
                          System.out.println("Choix invalide");
                      }

                  } catch (Exception e) {
                      System.out.println("Merci De saisir une valeur numérique");
                  }
              }while(! choixpossibles2.contains(choix2));
              Scanner sc = new Scanner(System.in);
              if(choix2==1){
                  System.out.println("Veuillez saisir le nom de l'équipe");
                  String Nom = sc.nextLine();
                  equipe.add(Nom);
                  System.out.println("Equipe ajouter avec succes");
              }
               else if(choix2==2){

                  System.out.println("Veuillez saisir l'Id de l'equipe a supprimer :");
                  int Id = 0;
                  VERIFICATIONSAISIE(Id);
                  equipe. Delete(Id);
                  System.out.println("Equipe Supprimer avec succes ");
              }
               else if(choix2==3){
                  List<Equipe> equipes = equipe.findALL();
                  System.out.println(equipes);
              }
               else if(choix2==4){
                  System.out.println("Veuillez saisir l'Identifiant de l'equipe a Modifier:");
                  int Id =0;
                  VERIFICATIONSAISIE(Id);
                  System.out.println("Veuillez saisir le nouveau nom de l'equipe :");
                  String name = sc.nextLine();
                  equipe.update(name);
                  System.out.println("MODIFICATION EFFECTUER AVEC SUCCES");
              }
          }while(choix2 != 5);
    }

    /**
     * Cette methode represente le formulaire d'ajout de Match ou de modififcationd d'un match
     */
     static void Matchaddandupdate(){
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
         MatchService matchs = new MatchService();
          Scanner sc = new Scanner(System.in);
         System.out.println("Veuillez saisir l'Identifiant de l'équipe Domicile :");
         int EquipeDomicileID=0;
         VERIFICATIONSAISIE( EquipeDomicileID);
         System.out.println("Veuillez saisir l'Identifiant de l'équipe Extérieur :");
         int EquipeExterieurID = 0;
         VERIFICATIONSAISIE(EquipeExterieurID);
         System.out.println("Veuillez saisir la poule du match :");
         String poule = sc.nextLine();
         System.out.println("Veuillez saisir le Nom du stade :");
         String stade = sc.nextLine();
         try {
             System.out.println("Veuillez saisir la date du Match(yyyy-MM-dd) :");
             String date = sc.nextLine();
             Date maDate = sdf.parse(date);
             matchs.add(EquipeDomicileID, EquipeExterieurID, maDate, poule, stade);
         } catch (Exception e) {
             System.out.println("Erreur le format saisir est incorrect");
         }
     }

    /**
     * Cette methode nous permettra de verifier que l'utilisateur Une valeur de type entier
     * @param id ce parametre represente la variable a la quelle nous devrons affeccter la bonne saisie
     */
        private static void VERIFICATIONSAISIE(int id) {
         Scanner sc = new Scanner(System.in);
          while (!sc.hasNextInt()){
              System.out.println("Erreur vous devez saisir un nombre entier");
              System.out.println("Veuillez ressayer :");
              sc.next();
          }
          id = sc.nextInt();
      }

    /**
     *
     */
    private static void VERIFICATIONSAISIEDETYPECHAINE (String name){
        Scanner sc = new Scanner(System.in);
        while(!sc.hasNextLine()){
            System.out.println("La saisie ne doit contenir que des caractere");
            System.out.println("Veuillez ressayer :");
            sc.next();
        }
        name = sc.nextLine();
    }
}


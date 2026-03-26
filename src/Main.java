import Service.*;
import models.*;

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
                    3-JOUEURS
                    4-ENCADREURS
                    5-HOTELS
                    6-QUITTER LE PROGRAMME    
                    """;
                System.out.println(MenuPrincipal);
                List<Integer> choixpossibles = Arrays.asList(1,2,3,4,5,6);
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
                } else if (choix == 3) {
                    sousmenuJoueur();
                } else if (choix == 4) {
                    sousmenuEncadreur();
                }
                else if(choix==5){
                    sousmenuHotel();
                }
            } while (choix != 6);
    }
    static void sousmenuMatchs() {
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
                System.out.println("Veuillez saisir l'Identifiant de l'équipe Domicile :");
                int EquipeDomicileID=sc.nextInt();
                System.out.println("Veuillez saisir l'Identifiant de l'équipe Extérieur :");
                int EquipeExterieurID = sc.nextInt();
                sc.nextLine();
                System.out.println("Veuillez saisir la poule du match :");
                String poule = sc.nextLine();
                System.out.println("Veuillez saisir le Nom du stade :");
                String stade = sc.nextLine();
                System.out.println("Veuillez saisir la date du Match(yyyy-MM-dd) :");
                sc.nextLine();
                String date = sc.nextLine();
                System.out.println("la date est :"+date);

                try {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    Date maDate = sdf.parse(date);
                    matchs.add(EquipeDomicileID, EquipeExterieurID, maDate, poule, stade);
                } catch (Exception e) {
                    System.out.println("Erreur le format saisir est incorrect");
                }

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
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    System.out.println("Veuillez saisir la date du Match(yyyy-MM-dd) :");
                    String date = sc.nextLine();
                    Date maDate = sdf.parse(date);
                    matchs.update(EquipeDomicileID, EquipeExterieurID, maDate, poule, stade);
                } catch (Exception e) {
                    System.out.println("Erreur le format saisir est incorrect");
                }
                System.out.println("Veuillez saisir l'Id du Matchs a Modifier :");
                int ID = 0;
                VERIFICATIONSAISIE(ID);
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
                  int id = sc.nextInt();
                  equipe.Delete(id);
                  System.out.println("Equipe Supprimer avec succes ");
              }
               else if(choix2==3){
                  List<Equipe> equipes = equipe.findALL();
                  System.out.println(equipes);
              }
               else if(choix2==4){
                  System.out.println("Veuillez saisir l'identifiant de l'equipe :");
                  int id = sc.nextInt();
                  sc.nextLine();
                  System.out.println("Veuillez saisir le nouveau nom de l'equipe :");
                  String name = sc.nextLine();
                  equipe.update(id,name);
                  System.out.println("MODIFICATION EFFECTUER AVEC SUCCES");
              }
          }while(choix2 != 5);
    }

    static void sousmenuJoueur(){
        int choix3 = -1;

        do{
            String menuJoueur= """
                =========================================================
                                     MENU JOUEURS 
                =========================================================
                1-AJOUTER UN JOUEURS
                2-MODIFIER UN JOUEUR 
                3-SUPPRIMER UN JOUEUR 
                4-LISTER TOUS LES JOUEURS DE LA COMPETIONS
                5-RECHERCHER UN JOUEUR
                6-Quitter
                """;
            System.out.println(menuJoueur);
            Scanner sc = new Scanner(System.in);
            List<Integer> choixpossible3 = Arrays.asList(1,2,3,4,5,6);
            JoueurService joueurService = new JoueurService();
            do{
                try{
                    System.out.println("Veuillez faire votre choix ;");
                    choix3 = sc.nextInt();
                    if( !choixpossible3.contains(choix3)){
                        System.out.println("Choix invalide");
                    }
                } catch (Exception e) {
                    System.out.println("Ce champ ne doit pas contenir de chaine de caractere");
                }
            }while(!choixpossible3.contains(choix3));
              if(choix3 == 1){
                  System.out.println("Veuillez saisir l'ID de la nation du joueur :");
                  int Nationnalite_ID = 0;
                  VERIFICATIONSAISIE(Nationnalite_ID);
                  sc.nextLine();
                  System.out.println("Veuillez saisir le nom et le prenom du joueur :");
                  String Nom_Prenom = sc.nextLine();
                  System.out.println("Veuillez saisir l'age du joueur :");
                  int age =0;
                  VERIFICATIONSAISIE(age);
                  System.out.println("Veuillez saisir le poste du joueur :");
                  String poste = sc.nextLine();
                  System.out.println("Veuillez saisir le club dub joueur :");
                  String club = sc.nextLine();
                  joueurService.add(Nationnalite_ID,Nom_Prenom,age,poste,club);
              }
               else if(choix3 == 2){
                  System.out.println("Veuillez saisir l'ID du joueur a Modifier :");
                  int JoueurID = sc.nextInt();
                  System.out.println("Veuillez saisir l'ID de la nation du joueur :");
                  int Nationnalite_ID = sc.nextInt();
                  sc.nextLine();
                  System.out.println("Veuillez saisir le nom et le prenom du joueur :");
                  String Nom_Prenom = sc.nextLine();
                  System.out.println("Veuillez saisir l'age du joueur :");
                  int age = sc.nextInt();
                  sc.nextLine();
                  System.out.println("Veuillez saisir le poste du joueur :");
                  String poste = sc.nextLine();
                  System.out.println("Veuillez saisir le club dub joueur :");
                  String club = sc.nextLine();
                  joueurService.update(JoueurID,Nationnalite_ID,Nom_Prenom,age,poste,club);

              } else if (choix3 == 3) {
                  System.out.println("Veuillez saisir l'ID du joueur a supprimer :");
                  int JoueurID = sc.nextInt();
                  joueurService.delete(JoueurID);
              } else if (choix3 == 4) {
                  List<Joueur> joueurs = joueurService.findAll();
                  System.out.println(joueurs.toString());

              } else if (choix3==5) {
                  System.out.println("Veuillez saisir l'ID du joueur que vous voulez recherché :");
                  int JoueurID = sc.nextInt();
                  Joueur joueur = joueurService.findOne(JoueurID);
                  System.out.println(joueur.toString());
              }
        }while(choix3 != 6);

    }

    static void sousmenuEncadreur(){
        int choix4 =-1;
        do{
            String sousmenuencadreur = """
                ===================================================
                                 MENU ENCADREUR 
                ===================================================
    
                1-AJOUTER UN ENCADREUR 
                2-MODIFIER UN ENCADREUR 
                3-SUPPRIMER UN ENCADREUR 
                4-LISTER TOUS LES ENCADREURS
                5-RECHERCHER UN ENCADREUR
                6-QUITTER
                """;
            System.out.println(sousmenuencadreur);
            List<Integer> choixposssibles4 = Arrays.asList(1,2,3,4,5,6);
            Scanner sc = new Scanner(System.in);
            EncadreurService encadreurService = new EncadreurService();
            do{
                try{
                    System.out.println("Veuillez faire un choix :");
                    choix4 = sc.nextInt();
                    if( ! choixposssibles4.contains(choix4)){
                        System.out.println("Choix invalide");
                    }
                } catch (Exception e) {
                    System.out.println("Ce champs ne doit pas contenir des caractere");
                }
            }while(!choixposssibles4.contains(choix4));
            if(choix4 == 1){
                System.out.println("Veuillez saisir l'ID du pays de l'encadreur:");
                int Nationnalite_ID = sc.nextInt();
                sc.nextLine();
                System.out.println("Veuillez entrer le nom et prenom de l'encadreur :");
                String Nom_Prenom = sc.nextLine();
                System.out.println("Veuillez saisir l'age de l'encadreur :");
                int age = sc.nextInt();
                sc.nextLine();
                System.out.println("Veuillez saisir le role de l'encadreur :");
                String role = sc.nextLine();
                encadreurService.add(Nationnalite_ID, Nom_Prenom, age, role);
            }else if(choix4 == 2){
                System.out.println("Veuillez saisir l'ID de l'encadreur a modifier :");
                int Encad_ID = sc.nextInt();
                sc.nextLine();
                System.out.println("Veuillez saisir l'ID du pays de l'encadreur:");
                int Nationnalite_ID = sc.nextInt();
                sc.nextLine();
                System.out.println("Veuillez entrer le nom et prenom de l'encadreur :");
                String Nom_Prenom = sc.nextLine();
                System.out.println("Veuillez saisir l'age de l'encadreur :");
                int age = sc.nextInt();
                System.out.println("Veuillez saisir le role de l'encadreur :");
                String role = sc.nextLine();
                encadreurService.update(Encad_ID,Nationnalite_ID, Nom_Prenom, age,role );

            }else if(choix4 == 3){
                System.out.println("Veuillez saisir L'ID de l'encadreur a supprimer :");
                int  Encad_ID = sc.nextInt();
                encadreurService.delete(Encad_ID);
            }else if(choix4 == 4){
                List<Encadreur> encadreurList = encadreurService.findAll();
                System.out.println(encadreurList);
            }else if(choix4 == 5){
                System.out.println("Veuillez saisir l'ID de l'encadreur a rechercher :");
                int Encad_ID = sc.nextInt();
                Encadreur  encadreur = encadreurService.findOne(Encad_ID);
                System.out.println(encadreur);
            }
        }while(choix4 != 6);


}

    /**
     * Cette methode represente le formulaire d'ajout de Match ou de modififcationd d'un match
     */


     static void sousmenuHotel(){
        int choix5 = -1;
        do{
            String sousmenuHotel = """
                ==============================================
                              MENU HOTELS 
                ==============================================
                1-AJOUTER UN HOTEL
                2-MODIFIER UN HOTEL
                3-SUPPRIMER UN HOTEL
                4-LISTER TOUS LES HOTELS
                5-RECHERCHER UN HOTEL
                6-Quitter
                """;
            System.out.println(sousmenuHotel);
            List<Integer> choixposssibles5 = Arrays.asList(1,2,3,4,5,6);
            Scanner sc = new Scanner(System.in);
             HotelService hotel = new HotelService();
            do{
                try{
                    System.out.println("Veuillez faire un choix :");
                    choix5 = sc.nextInt();
                    if( ! choixposssibles5.contains(choix5)){
                        System.out.println("Choix invalide");
                    }
                } catch (Exception e) {
                    System.out.println("Ce champs ne doit pas contenir des caractere");
                }
            }while(!choixposssibles5.contains(choix5));
            if(choix5==1){
                System.out.println("Veuillez saisir l'Id de la nation qui qui residera dans l'hotel :");
                int Nationnalite_ID  = sc.nextInt();
                sc.nextLine();
                System.out.println("Veuillez saisir le nom de l'hotel :");
                String Nom = sc.nextLine();
                System.out.println("veuillez saisir l'email de l'hotel :");
                String email = sc.nextLine();
                System.out.println("Veuillez saisir votre localisation :");
                String Localisation = sc.nextLine();
                hotel.add(Nationnalite_ID,Nom,email,Localisation);
            }else if(choix5==2){
                System.out.println("Veuillez saisir l'Id de l'Hotel a modifier :");
                int HotelID = sc.nextInt();
                System.out.println("Veuillez saisir l'Id de la nation qui qui residera dans l'hotel :");
                int Nationnalite_ID  = sc.nextInt();
                sc.nextLine();
                System.out.println("Veuillez saisir le nom de l'hotel :");
                String Nom = sc.nextLine();
                System.out.println("veuillez saisir l'email de l'hotel :");
                String email = sc.nextLine();
                System.out.println("Veuillez saisir votre localisation :");
                String Localisation = sc.nextLine();
                hotel.update(HotelID,Nationnalite_ID,Nom,email,Localisation);
            }else if(choix5==3){
                System.out.println("Veuillez saisir l'Id de l'Hotel a supprimer :");
                int HotelID = sc.nextInt();
                hotel.delete(HotelID);
            }else if(choix5==4){
               List<Hotel> hotelList = hotel.findAll();
                System.out.println(hotelList.toString());
            }else if(choix5==5){
                System.out.println("Veuillez saisir l'Id de l'Hotel a modifier :");
                int HotelID = sc.nextInt();
               Hotel hotelocc = hotel.findOne(HotelID);
                System.out.println(hotelocc.toString());
            }
        }while(choix5 != 6);

     }

     /**
     * Cette methode nous permettra de verifier que l'utilisateur a saisie Une valeur de type entier
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
    private static void VERIFICATIONSAISIEDETYPECHAINE (int name){
        Scanner sc = new Scanner(System.in);
        while(!sc.hasNextLine()){
            System.out.println("La saisie ne doit contenir que des caractere");
            System.out.println("Veuillez ressayer :");
            sc.next();
        }
        name = sc.nextInt();
    }
}


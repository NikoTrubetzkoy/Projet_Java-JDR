import outils.Fonctions;
import personnages.*;

public class App {
    public static void main(String[] args) {
        Personnage Perso1 = null;
        do {
            String inputStr = Fonctions.saisirTexte("Choisissez votre classe de personnage : (G)uerrier ou (M)age ?\n");
            // System.out.println(inputStr + "\t" + inputStr.length() + "\n");

            if (inputStr.equals("G") || inputStr.equals("g")) {
                Perso1 = new Guerrier();
            }
            if (inputStr.equals("M") || inputStr.equals("m")) {
                Perso1 = new Mage();
            }
        } while (Perso1 == null);
        System.out.println(Perso1);

        // System.out.println(Perso1.getNom());

        while (Perso1.getNom() == null) {
            String Pers1Name = "";
            while (Pers1Name.equals("")) {
                Pers1Name = Fonctions.saisirTexte("Choisissez un nom de personnage :\n");
            }
            // System.out.println("INPUT : " + Pers1Name);
            Perso1.setNom(Pers1Name);
        }
        // System.out.println("NOM : " + Perso1.getNom());
        // System.out.println("FORCE : " + Perso1.getForce());

        String myName = Perso1.getNom();

        while (Perso1.getForce() == 0) {
            int Pers1Force = Fonctions.saisirEntier("Entrez la force de " + myName + " :\n");
            if (Pers1Force > 20) {
                Perso1.setForce(20);
            } else if (Pers1Force < 1) {
                Perso1.setForce(1);
            } else {
                Perso1.setForce(Pers1Force);
            }
        }

        while (Perso1.getPointsVie() == 0) {
            int Pers1Vie = Fonctions.saisirEntier("Entrez les points de vie de " + myName + " :\n");
            if (Pers1Vie > 200) {
                Perso1.setPointsVie(200);
            } else if (Pers1Vie < 50) {
                Perso1.setPointsVie(50);
            } else {
                Perso1.setPointsVie(Pers1Vie);
            }
        }

        // System.out.println(Perso1.fiche());
        if (Perso1 instanceof Guerrier) {
            while (((Guerrier) Perso1).getArmour() == 0) {
                int Pers1Armour = Fonctions.saisirEntier("Entrez les points d'armure de " + myName + " :\n");
            }
        }

    }
}

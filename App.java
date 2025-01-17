import outils.Fonctions;
import personnages.*;
import outils.combat;

public class App {

    public static Personnage setStatsPerso() {
        int characterFlag = 0; // 0 == Guerrier || 1 == Mage
        Personnage myPerso = null;
        do {
            String inputStr = Fonctions.saisirTexte("Choisissez votre classe de personnage : (G)uerrier ou (M)age ?\n");
            // System.out.println(inputStr + "\t" + inputStr.length() + "\n");

            if (inputStr.equals("G") || inputStr.equals("g")) {
                myPerso = new Guerrier();
            }
            if (inputStr.equals("M") || inputStr.equals("m")) {
                myPerso = new Mage();
                characterFlag = 1;
            }
        } while (myPerso == null);
        System.out.println(myPerso);

        // System.out.println(myPerso.getNom());

        while (myPerso.getNom() == null) {
            String Pers1Name = "";
            while (Pers1Name.equals("")) {
                Pers1Name = Fonctions.saisirTexte("Choisissez un nom de personnage :\n");
            }
            // System.out.println("INPUT : " + Pers1Name);
            myPerso.setNom(Pers1Name);
        }
        // System.out.println("NOM : " + myPerso.getNom());
        // System.out.println("FORCE : " + myPerso.getForce());

        String myName = myPerso.getNom();

        if (characterFlag == 0) {
            while (myPerso.getForce() == 0) {
                int Pers1Force = Fonctions.saisirEntier("Entrez la force de " + myName + " :\n");
                if (Pers1Force > 20) {
                    myPerso.setForce(20);
                } else if (Pers1Force < 1) {
                    myPerso.setForce(1);
                } else {
                    myPerso.setForce(Pers1Force);
                }
            }
        } else {
            while (myPerso.getForce() == 0) {
                int Pers1Force = Fonctions.saisirEntier("Entrez la force de " + myName + " :\n");
                if (Pers1Force > 10) {
                    myPerso.setForce(10);
                } else if (Pers1Force < 1) {
                    myPerso.setForce(1);
                } else {
                    myPerso.setForce(Pers1Force);
                }
            }
        }

        while (myPerso.getPointsVie() == 0) {
            int Pers1Vie = Fonctions.saisirEntier("Entrez les points de vie de " + myName + " :\n");
            if (Pers1Vie > 200) {
                myPerso.setPointsVie(200);
            } else if (Pers1Vie < 50) {
                myPerso.setPointsVie(50);
            } else {
                myPerso.setPointsVie(Pers1Vie);
            }
        }

        // System.out.println(myPerso.fiche());
        // if (((Guerrier) myPerso) instanceof Guerrier) {
        if (characterFlag == 0) {
            while (((Guerrier) myPerso).getArmour() == 0) {
                int Pers1Armour = Fonctions.saisirEntier("Entrez les points d'armure de " + myName + " :\n");
                if (Pers1Armour > 5) {
                    ((Guerrier) myPerso).setArmour(5);
                } else if (Pers1Armour < 1) {
                    ((Guerrier) myPerso).setArmour(1);
                } else {
                    ((Guerrier) myPerso).setArmour(Pers1Armour);
                }
            }
        } else {
            while (((Mage) myPerso).getMana() == 0) {
                int Pers1Mana = Fonctions.saisirEntier("Entrez les points de mana de " + myName + " :\n");
                if (Pers1Mana > 100) {
                    ((Mage) myPerso).setMana(200);
                } else if (Pers1Mana < 1) {
                    ((Mage) myPerso).setMana(1);
                } else {
                    ((Mage) myPerso).setMana(Pers1Mana);
                }
            }
        }
        return myPerso;
    }

    public static void main(String[] args) {
        Personnage Perso1 = setStatsPerso();
        Personnage Perso2 = setStatsPerso();

        System.out.println(Perso1.fiche());
        System.out.println(Perso2.fiche());

        combat.stageCombatRandom(Perso1, Perso2);

    }
}

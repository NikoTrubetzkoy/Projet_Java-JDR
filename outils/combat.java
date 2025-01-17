package outils;

import personnages.*;
import personnages.categories.Lanceur;

public class combat {

    public static void stageCombatRandom(Personnage a, Personnage b) {
        int flipACoin = Fonctions.aleatoire(1, 2);
        Personnage attacker;
        Personnage defendant;

        if (flipACoin == 1) {
            attacker = a;
            defendant = b;
        } else {
            attacker = b;
            defendant = a;
        }
        Personnage victor = null;

        // System.out.println(flipACoin + "\t" + attacker + "\t" + defendant);
        while (victor == null) {
            String attName = attacker.getNom();
            String defName = defendant.getNom();
            System.out.println(attName + " attaque " + defName + ".\n");
            int damage = attacker.attaque(defendant);
            if (attacker instanceof Mage && !(defendant instanceof Lanceur)) {
                defendant.setPointsVie(defendant.getPointsVie() + damage);
                defendant.esquive(damage);
            }
            int defPV = defendant.getPointsVie();
            System.out.println("\t--> Il reste " + defPV + "PV à " + defendant.getNom() + ".\n");
            if (defPV <= 0) {
                victor = attacker;
                System.out.println(attName + " a massacré " + defName + " !\n");
            } else {
                Personnage prevAtt = attacker;
                attacker = defendant;
                defendant = prevAtt;
            }
        }
    }

    public static void main(String[] args) {
        Guerrier conan = new Guerrier("Conan", 100, 18, "barbare", 0);
        Mage gandalf = new Mage("Gandalf", "vagabond", 9, 90, 100);

        stageCombatRandom(conan, gandalf);
        stageCombatRandom(conan, gandalf);

        Mage WhiteGandalf = new Mage("Gandalf le blanc", "Godlike wizard", 15, 200, 400);

        stageCombatRandom(WhiteGandalf, conan);

    }

}

/*
 * int tour = 1;
 * do {
 * System.out.println(
 * "╔══════════════════════════════════════════════════════════════╗");
 * System.out.println("║                            " + "Tour " + tour++ +
 * "                            ║");
 * System.out.println(
 * "╚══════════════════════════════════════════════════════════════╝");
 * conan.attaque(gandalf);
 * System.out.println("Il reste " + gandalf.getVie() + " PV à " +
 * gandalf.getNom());
 * gandalf.attaque(conan);
 * System.out.println("Il reste " + conan.getVie() + " PV à " + conan.getNom());
 * 
 * } while( gandalf.getVie() > 0 && conan.getVie() > 0);
 * if( gandalf.getVie() > 0 ) {
 * System.out.println(gandalf.getNom() + " a vaincu " + conan.getNom());
 * } else if( conan.getVie() > 0 ) {
 * System.out.println(conan.getNom() + " a vaincu " + gandalf.getNom());
 * } else {
 * System.out.println(gandalf.getNom() + " et " + conan.getNom() +
 * " se sont entretués : aucun vainqueur");
 * }
 */

import outils.Fonctions;
import personnages.*;
import personnages.categories.Lanceur;
import personnages.categories.Race;

public class test {
    public static void main(String[] args) {
        Guerrier p1 = new Guerrier(5);
        p1.setNom("Conan");
        p1.setClasse("barbare");
        p1.setForce(18);
        p1.setPointsVie(100);
        p1.setRace(Race.Humain);

        System.out.println(p1.toString());

        Mage p2 = new Mage();
        p2.setNom("Gandalf");
        p2.setClasse("magicien");
        p2.setForce(9);
        p2.setPointsVie(90);
        p2.setMana(180);
        p2.setRace(Race.Istar);

        System.out.println(p2.toString());

        System.out.println(p2.getPointsVie());
        p1.attaque(p2);
        System.out.println(p2.getPointsVie());

        Guerrier p3 = new Guerrier(8);
        p3.setNom("Spike");
        p3.setClasse("chasseur de primes");
        p3.setForce(8);
        p3.setPointsVie(77);
        p3.setRace(Race.Elfe);

        int armorValues[] = new int[5];

        armorValues[0] = p3.getArmour();
        p3.setArmour(-3);
        armorValues[1] = p3.getArmour();
        p3.setArmour(8);
        armorValues[2] = p3.getArmour();

        for (int i = 0; i < 3; i++) {
            System.out.println("État armure : " + armorValues[i]);
        }

        System.out.println(p3.fiche() + "\n\n" + p2.fiche()
                + "\n\n" + p1.fiche());

        System.out.println(p3);

        System.out.println(p3.fiche());
        System.out.println("Race : " + p3.getRace() + "\n");

        try {
            if (p3.getRace() == Race.valueOf("Istere")) {
                System.out.println("C'est bien maia.");
            } else {
                System.out.println("Ce n'est pas un humain.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("\n**********");
            System.out.println("Cette race n'existe pas dans cet unvers.");

        } catch (Exception e) {
            System.out.println(("Erreur non définie"));
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Ce bloc est utilisé dans tous les cas.");
        }

        Sorcier p4 = new Sorcier("Skeletor", "Seigneur de la destruction",
                15, 85, 10, 10);

        System.out.println(p4.fiche());

        Lanceur lanceur = new Archer();
        ((Archer) lanceur).setNom("Legolas");
        String ficheLanceur = ((Archer) lanceur).fiche();
        System.out.println(ficheLanceur);

        Personnage p = new Guerrier();
        p.setNom("Cugel l'astucieux");
        System.out.println(p.fiche());

        System.out.println("########## ########## ##########");
        System.out.println("## LISTE DES RACES DISPONIBLES :");
        for (Race race : Race.values()) {
            System.out.println("-> " + race);
        }

        System.out.println("Position de la race 'Nain' dans la liste : " + (Race.Nain.ordinal() + 1));

        System.out.println("***** ***** ***** ***** ***** *****");
        Fonctions.saisirTexte("Entrez une phrase :\n>> ");
        Fonctions.saisirMot("Entrez un mot seul :\n>> ");
        Fonctions.saisirEntier("Entrez une valeur numérique en chiffres :\n>> ");
    }
}

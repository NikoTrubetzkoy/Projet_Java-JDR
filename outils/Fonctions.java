package outils;

import java.util.InputMismatchException;
import java.util.Scanner;

public final class Fonctions {

    private static final Scanner scan = new Scanner(System.in);

    private Fonctions() {
    };

    public static int aleatoire(int min, int max) {
        return (int) (Math.random() * (max - min + 1) + min);
    }

    public static String saisirTexte(String amorce) {
        System.out.print(amorce + " > ");
        String texte = scan.nextLine();
        return texte;
    }

    public static String saisirMot(String amorce) {
        System.out.println(amorce + " > ");
        String texte = scan.next();
        return texte;
    }

    public static int saisirEntier(String amorce) {
        Integer nb = null;
        do {
            try {
                System.out.println(amorce + " > ");
                String str = scan.nextLine();
                nb = Integer.parseInt(str);
            } catch (InputMismatchException e) {
                System.out.println(("\033[31m Ce n'est pas un nombre \033[0m"));
                nb = saisirEntier(amorce);
            } catch (NumberFormatException e) {
                System.out.println("\033[31m Mauvaise saisie \033[0m");
                nb = saisirEntier(amorce);
            } catch (Exception e) {
                System.out.println("\033[31m Erreur ! \033[0m");
                nb = saisirEntier(amorce);
            }
        } while (nb == null);
        return nb;

    }
}
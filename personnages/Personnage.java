package personnages;

import personnages.categories.Race;

public abstract class Personnage {

    public static final int FORCE_MAX = 20;
    public static final int FORCE_MIN = 1;

    private String nom;
    private String classe;
    private int force;
    private int pointsVie;
    private Race race;

    public Personnage(String name, String type, int strength, int health) {
        this.nom = name;
        this.classe = type;
        this.force = strength;
        this.pointsVie = health;
    }

    public Personnage(String name, int strength, String type, int health) {
        this.nom = name;
        this.classe = type;
        this.force = strength;
        this.pointsVie = health;
    }

    public Personnage(String name, int strength, int health) {
        this.nom = name;
        this.force = strength;
        this.pointsVie = health;
    }

    public Personnage() {
    };

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public int getForce() {
        return force;
    }

    public void setForce(int force) {
        this.force = force > FORCE_MAX ? FORCE_MAX : (force < FORCE_MIN ? FORCE_MIN : force);
    }

    public int getPointsVie() {
        return pointsVie;
    }

    public void setPointsVie(int pointsVie) {
        this.pointsVie = pointsVie;
    }

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    public void attaque(Personnage cible) {
        // changer les points de vie de la cible en fonction de la force de l'attaquant
        cible.pointsVie -= this.force;
        /*
         * Ou alors plus strictement :
         * cible.setPointsVie(cible.getPointsVie() - this.force) ;
         */
    }

    public abstract void esquive();

    public abstract boolean esquive(int dmg);

    public String fiche() {
        String stats = " ----- Fiche personnage -----\n ----------------------------\n\n";
        stats += "Nom : " + getNom() + "\n";
        stats += "Classe : " + getClasse() + "\n";
        stats += "Points de force : " + getForce() + "\n";
        stats += "Point de vie : " + getPointsVie() + "\n";

        return stats;
    }

    public String toString() {
        return this.getClass().getSimpleName();
    }

    public Personnage clone() throws CloneNotSupportedException {
        return (Personnage) super.clone();
    }
}

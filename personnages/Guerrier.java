package personnages;

import outils.Fonctions;

public class Guerrier extends Personnage {

    private int armour;

    public Guerrier() {
    }

    public Guerrier(int armour) {
        this.armour = armour;
    }

    public Guerrier(String name, int health, int strength, String type, int armor) {
        /*
         * this.setNom(name) ;
         * this.setPointsVie(health);
         * this.setForce(strength);
         * this.pointVie = health // si la propriété a une visibilité "protected"
         */
        super(name, type, strength, health);
        this.setArmour(armor);
    }

    public int getArmour() {
        return armour;
    }

    public void setArmour(int armour) {
        if (armour < 1) {
            this.armour = 1;
        } else if (armour > 5) {
            this.armour = 5;
        } else {
            this.armour = armour;
        }
    }

    public void esquive() {
    };

    @Override
    public boolean esquive(int dmg) {
        int nbAleatoire;
        if (this.getForce() >= 15) {
            nbAleatoire = Fonctions.aleatoire(1, 4);
        } else if (this.getForce() >= 13) {
            nbAleatoire = Fonctions.aleatoire(1, 8);
        } else {
            nbAleatoire = Fonctions.aleatoire(1, 10);
        }
        boolean reussite = nbAleatoire == 1;
        if (reussite) {
            this.setPointsVie(this.getPointsVie() - dmg / 2);
        } else {
            this.setPointsVie(this.getPointsVie() - dmg);
        }
        /*
         * boolean esquive = false;
         * if (this.getForce() >= 15) {
         * esquive = Fonctions.aleatoire(1, 4) == 1 ;
         * } else if (this.getForce() >= 13){
         * esquive = Fonctions.aleatoire(1, 8) ==1 ;
         * } else {
         * esquive = Fonctions.aleatoire(1, 10) == 1;
         * }
         * dmg = esquive? dmg / 2 : dmg;
         * this.setPointsVie( this.getPointsVie() - dmg );
         * return esquive;
         * 
         */

        return reussite;
    }

    public String fiche() {
        return super.fiche() + "Points d'armure : " + this.getArmour() + "\n";
    }

}

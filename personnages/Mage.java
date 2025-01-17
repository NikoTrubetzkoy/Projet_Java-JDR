package personnages;

import outils.Fonctions;
import personnages.categories.Lanceur;;

public class Mage extends Personnage implements Lanceur {

    public static final int FORCE_MAX = 10;
    private int mana;

    public Mage() {
    };

    public Mage(String name, String type, int strength, int health, int magic) {
        super(name, type, strength, health);
        this.mana = magic;
    }

    public Mage(String name, int strength, int health, int magic) {
        super(name, strength, health);
        this.mana = magic;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    @Override
    public void esquive() {
    };

    @Override
    public boolean esquive(int dmg) {
        int nbAleatoire = Fonctions.aleatoire(1, 10);
        return nbAleatoire == 1;
    }

    public String fiche() {
        return super.fiche() + "Points de mana : " + this.getMana() + "\n";
    }

    @Override
    public int attaque(Personnage cible) {
        int myDmg = this.getForce();
        if (this.mana > 200) {
            myDmg *= 4;
        }
        if (this.mana > 50 && this.mana <= 200) {
            myDmg *= 3;
        }
        if (this.mana > 20 && this.mana <= 50) {
            myDmg *= 2;
        }
        if (this.mana < 1) {
            myDmg = myDmg / 2;
        }
        cible.setPointsVie((cible.getPointsVie() - myDmg));
        this.setMana(this.mana - myDmg);
        return myDmg;

    }

    @Override
    public void attaqueDistante(Personnage p) {
    };

    @Override
    public boolean esquiveDistante(int dmg) {
        return this.esquive(dmg);
    }

}

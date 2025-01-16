package personnages;

import outils.Fonctions;
import personnages.categories.Lanceur;;

public class Mage extends Personnage implements Lanceur {
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
    public void attaqueDistante(Personnage p) {

    }

    @Override
    public boolean esquiveDistante(int dmg) {
        return this.esquive(dmg);
    }

}

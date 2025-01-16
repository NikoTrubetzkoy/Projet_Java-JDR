package personnages;

import personnages.categories.Lanceur;

public class Arbaletrier extends Guerrier implements Lanceur {

    @Override
    public void attaqueDistante(Personnage p) {

    }

    @Override
    public boolean esquiveDistante(int dmg) {
        return this.esquive(dmg);
    }

}

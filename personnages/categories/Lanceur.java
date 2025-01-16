package personnages.categories;

import personnages.Personnage;

public interface Lanceur {

    public void attaqueDistante(Personnage p);

    public boolean esquiveDistante(int dmg);

}

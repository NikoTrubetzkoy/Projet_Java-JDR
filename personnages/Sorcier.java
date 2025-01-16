package personnages;

public class Sorcier extends Mage {
    private int magieNoire;

    public Sorcier() {
    };

    public Sorcier(String name, String type, int strength, int health, int magic, int magieNoire) {
        super(name, type, strength, health, magic);
        this.magieNoire = magieNoire;
    }

    public Sorcier(String name, int strength, int health, int magic, int magieNoire) {
        super(name, strength, health, magic);
        this.magieNoire = magieNoire;
    }

    public int getMagieNoire() {
        return magieNoire;
    }

    public void setMagieNoire(int magieNoire) {
        this.magieNoire = magieNoire;
    }

    public String fiche() {
        return super.fiche() + "Points de magie noire : " + this.getMagieNoire() + "\n";
    }

}

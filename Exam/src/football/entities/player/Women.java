package football.entities.player;

public class Women extends BasePlayer{

    private static final double KG = 60.0;

    public Women(String name, String nationality, int strength) {
        super(name, nationality, strength);
    }

    @Override
    public int getStrength() {
        return super.getStrength();
    }

    @Override
    public void stimulation() {
       setStrength(getStrength() + 115);
    }
}

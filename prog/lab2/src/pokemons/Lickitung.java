package pokemons;

import attacks.Facade;
import attacks.IceBeam;
import attacks.Screech;
import ru.ifmo.se.pokemon.Pokemon;

public class Lickitung extends Pokemon {

    public Lickitung(String s, int i) {
        super(s, Math.min(i, 42));
        setStats(90, 55, 75, 60, 75, 30);
        this.addMove(new Facade());
        this.addMove(new Screech());
        this.addMove(new IceBeam());
    }
}

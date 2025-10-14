package pokemons;

import attacks.Confide;
import attacks.PoisonSting;
import ru.ifmo.se.pokemon.Pokemon;

public class NidoranM extends Pokemon {

    public NidoranM(String s, int i) {
        super(s, Math.min(i, 1));
        setStats(46, 57, 40, 40, 40, 50);
        this.addMove(new PoisonSting());
        this.addMove(new Confide());
    }
}

package pokemons;

import attacks.Flatter;

public class Nidorino extends NidoranM {

    public Nidorino(String s, int i) {
        super(s, Math.min(i, 45));
        setStats(61, 72, 57, 55, 55, 65);
        addMove(new Flatter());
    }
}

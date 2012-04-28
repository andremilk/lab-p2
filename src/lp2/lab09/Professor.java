package lp2.lab09;

public class Professor extends Usuario {

    private final static int TEMPO_MAXIMO = 180;
    public Professor(String nome, int matricula, int tempoMaximo) {
        super(nome, matricula, TEMPO_MAXIMO);
    }
    
    @Override
    public int getTempoMaximo() {
        return Professor.TEMPO_MAXIMO;
    }

}

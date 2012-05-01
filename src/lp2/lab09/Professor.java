package lp2.lab09;


/**
 * Classe que modela um professor.
 * Esta classe apenas muda o tempo maximo que um Professor pode ficar com um livro.
 * @author dekozo
 *
 */
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

package lp2.lab09;

/**
 * Classe que modela um aluno.
 * Esta classe serve para mudar o tempo maximo em que um usuario do tipo Aluno pode ficar com um livro.
 * @author Andre Luiz Guimaraes de Souza Leite
 * @author Marcus Antonio Rocha Tenorio
 *
 */
public class Aluno extends Usuario {
	 
    /**
     * Tempo maximo de permanencia com livro do aluno eh de 30 dias 
     */
    private final static int TEMPO_MAXIMO = 30;
    public Aluno(String nome, int matricula, int tempoMaximo) {
        super(nome, matricula, TEMPO_MAXIMO);
        
    }
    
    @Override
    public int getTempoMaximo() {
        return Aluno.TEMPO_MAXIMO;
    }

}

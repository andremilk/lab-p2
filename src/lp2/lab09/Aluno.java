package lp2.lab09;

/**
 * 
 * @author Andre Luiz Guimaraes de Souza Leite
 * @author Marcus Antonio Rocha Tenorio
 *
 */
public class Aluno extends Usuario {
	/*** Tempo maximo de permanencia com livro do aluno eh de 30 dias*/
    private final static int TEMPO_MAXIMO = 30;
    public Aluno(String nome, int matricula, int tempoMaximo) {
        super(nome, matricula, TEMPO_MAXIMO);
        
    }
    
    @Override
    public int getTempoMaximo() {
        return Aluno.TEMPO_MAXIMO;
    }

}

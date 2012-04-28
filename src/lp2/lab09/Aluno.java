package lp2.lab09;

public class Aluno extends Usuario {

    public Aluno(String nome, int matricula, int tempoMaximo) {
        super(nome, matricula, tempoMaximo);
        
    }
    
    @Override
    public int getTempoMaximo() {
        return 30;
    }

}

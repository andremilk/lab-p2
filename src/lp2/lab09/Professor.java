package lp2.lab09;

public class Professor extends Usuario {

    public Professor(String nome, int matricula, int tempoMaximo) {
        super(nome, matricula, tempoMaximo);
    }
    
    @Override
    public int getTempoMaximo() {
        return 180;
    }

}

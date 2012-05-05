package lp2.lab10;

import java.util.ArrayList;

public class DisciplinaAnual extends Disciplina {

    private final int MAX_PROVAS = 6;

    public DisciplinaAnual(String nome, Estado estado) {
        super(nome, estado);
        // TODO Auto-generated constructor stub
    }

    @Override
    public int getCreditos() {
        // TODO Auto-generated method stub
        return 120;
    }

    @Override
    public void adicionarProva() throws Exception {
        if(this.getProvas().size() >= MAX_PROVAS)
            return;
        int tamLista = this.getProvas().size();
        /**
         * As 5 primeiras provas tem peso 1 (formam uma media aritmetica que tera peso 6)
         * a ultima prova tem peso 4
         */
        this.getProvas().add(new Prova((tamLista <= 5 ? 1: 4), DataHandler.entradaNota()));
    }

    @Override
    public double gerarParcial() {
        double primeiraParte = 0;
        ArrayList<Prova> p = this.getProvas();
        for(int i = 0; i <= 4; i++) {
            primeiraParte += p.get(i).getNota();
        }
        return ((primeiraParte / 5) + (p.get(5).getNota() * p.get(5).getPeso()) / 10);
    }

}

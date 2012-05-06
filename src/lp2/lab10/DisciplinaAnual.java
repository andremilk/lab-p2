package lp2.lab10;

import java.util.ArrayList;

public class DisciplinaAnual extends Disciplina {

    private final int MAX_PROVAS = 6;

    public DisciplinaAnual(String nome, Estado estado) {
        super(nome, Estado.CURSANDO);
    }

    @Override
    public int getCreditos() {
        return 120;
    }

    @Override
    public void adicionarProva() throws Exception {
        int tamLista = this.getProvas().size();
        if(tamLista >= MAX_PROVAS)
            return;
        /**
         * As 5 primeiras provas tem peso 1 (formam uma media aritmetica que tera peso 6)
         * a ultima prova tem peso 4
         */
        String message = "Digite a prova de numero" + (tamLista + 1);
        this.getProvas().add(new Prova((tamLista <= 5 ? 1: 4), DataHandler.entradaNota(message)));
    }

    @Override
    public void gerarParcial() {
        double primeiraParte = 0;
        ArrayList<Prova> p = this.getProvas();
        for(int i = 0; i <= 4; i++) {
            primeiraParte += p.get(i).getNota();
        }
        this.setMediaParcial((((primeiraParte / 5) * 4) + (p.get(5).getNota() * p.get(5).getPeso()) / 10));
    }

}

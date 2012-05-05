package lp2.lab10;

public class DisciplinaSemestral extends Disciplina {

    private final int MAX_PROVAS = 3;

    public DisciplinaSemestral(String nome, Estado estado) {
        super(nome, Estado.CURSANDO);
    }

    @Override
    public int getCreditos() {
        return 60;
    }

    @Override
    public void adicionarProva() throws Exception {
        int tamLista = this.getProvas().size();
        if(tamLista >= MAX_PROVAS)
            return;
        String message = "Digite a prova de numero" + (tamLista + 1);
        this.getProvas().add(new Prova(1, DataHandler.entradaNota(message)));
    }

    @Override
    public void gerarParcial() {
        double produtos = 0;
        for(Prova p: this.getProvas()) {
            produtos += (p.getNota() * p.getPeso());
        }
        this.setMediaParcial((produtos/this.getProvas().size()));
    }
}

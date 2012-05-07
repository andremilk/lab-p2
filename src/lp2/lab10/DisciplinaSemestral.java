package lp2.lab10;

public class DisciplinaSemestral extends Disciplina {

    private final int MAX_PROVAS = 3;
    private final int CREDITOS = 60;

    /**
     * Construtor da classe DisciplinaSemestral
     * @param nome nome da disciplina
     */
    public DisciplinaSemestral(String nome) {
        super(nome, Estado.CURSANDO);
    }

    /**
     * Retorna o numero de creditos da disciplina semestral, 60 horas
     */
    @Override
    public int getCreditos() {
        return CREDITOS;
    }

    /**
     * Adiciona provas (maximo de 3 provas)
     * @throws Exception Excecao lancada caso a nota da prova seja invalida
     */
    @Override
    public void adicionarProva() throws Exception {
        int tamLista = this.getProvas().size();
        if(tamLista >= MAX_PROVAS)
            return;
        String message = "Digite a prova de numero" + (tamLista + 1);
        this.getProvas().add(new Prova(1, DataHandler.entradaNota(message)));
    }

    /**
     * Gera a media parcial da disciplina
     */
    @Override
    public void gerarParcial() {
        double produtos = 0;
        for(Prova p: this.getProvas()) {
            produtos += (p.getNota() * p.getPeso());
        }
        this.setMediaParcial((produtos/this.getProvas().size()));
    }
}

package lp2.lab10;

public class DisciplinaTrimestral extends Disciplina {

    private final int MAX_PROVAS = 2;
    
    public DisciplinaTrimestral(String nome, Estado estado) {
        super(nome, estado);
    }

    /**
     * return retorna o numero de horas da disciplina trimestral, 30 horas
     */
    @Override
    public int getCreditos() {
        return 30;
    }

    /**
     * Adiciona provas (maximo de 2 provas) 
     * @throws Exception 
     */
    @Override
    public void adicionarProva() throws Exception {
        if(this.getProvas().size() >= MAX_PROVAS)
            return;
        int tamLista = this.getProvas().size();
        this.getProvas().add(new Prova((tamLista == 0 ? 4: 6), DataHandler.entradaNota()));
    }

    @Override
    public void gerarParcial() {
        double pesos = 0;
        double produtos = 0;
        for(Prova p: this.getProvas()) {
            pesos += p.getPeso();
            produtos += (p.getNota() * p.getPeso());            
        }
        this.setMediaParcial(produtos/pesos);
    }
}

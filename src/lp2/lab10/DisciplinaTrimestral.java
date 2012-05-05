package lp2.lab10;

public class DisciplinaTrimestral extends Disciplina {

    private final int MAX_PROVAS = 2;
    
    public DisciplinaTrimestral(String nome, Estado estado) {
        super(nome, Estado.CURSANDO);
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
        int tamLista = this.getProvas().size();
        if(tamLista >= MAX_PROVAS)
            return;
        String message = "Digite a prova de numero" + (tamLista + 1);
        this.getProvas().add(new Prova((tamLista == 0 ? 4: 6), DataHandler.entradaNota(message)));
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

package lp2.lab10;

public class DisciplinaTrimestral extends Disciplina {

    private final int MAX_PROVAS = 2;
    private final int CREDITOS = 30;
    
    /**
     * Construtor da classe DisciplinaTrimestral
     * @param nome nome da disciplina
     * 
     */
    public DisciplinaTrimestral(String nome, int periodo) {
        super(nome, periodo);
    }

    /**
     * Metodo que retorna o numero de creditos
     * @return 30
     */
    @Override
    public int getCreditos() {
        return CREDITOS;
    }

    /**
     * Adiciona provas (maximo de 2 provas) 
     * @throws Exception Excecao lancada caso a nota da prova seja invalida
     */
    @Override
    public void adicionarProva() throws Exception {
        int tamLista = this.getProvas().size();
        if(tamLista == MAX_PROVAS - 1) {
            this.setEstado(Estado.CONCLUIDA);
            
        }    
        String message = "Digite a prova de numero" + (tamLista + 1);
        this.getProvas().add(new Prova((tamLista == 0 ? 4: 6), DataHandler.entradaNota(message)));
        this.gerarParcial();
    }

    /**
     * Metodo que gera a media parcial da disciplina e ja usa o set correspondente
     */
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

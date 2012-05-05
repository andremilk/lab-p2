package lp2.lab10;

public class DisciplinaTrimestral extends Disciplina {

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
        if(this.getProvas().size() >= 2)
            return;
        this.getProvas().add(new Prova(4, DataHandler.entradaNota()));
    }

}

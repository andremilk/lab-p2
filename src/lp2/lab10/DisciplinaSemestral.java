package lp2.lab10;

public class DisciplinaSemestral extends Disciplina {

    private final int MAX_PROVAS = 3;

    public DisciplinaSemestral(String nome, Estado estado) {
        super(nome, estado);
        // TODO Auto-generated constructor stub
    }

    @Override
    public int getCreditos() {
        // TODO Auto-generated method stub
        return 60;
    }

    @Override
    public void adicionarProva() throws Exception {
        if(this.getProvas().size() >= MAX_PROVAS)
            return;
        this.getProvas().add(new Prova(1, DataHandler.entradaNota()));
    }

}

package lp2.lab10;

import java.util.ArrayList;

public class DisciplinaAnual extends Disciplina {

    private final int MAX_PROVAS = 6;
    private final int CREDITOS = 120;

    /**
     * Construtor da classe DisciplinaAnual de 120 creditos
     * @param nome nome da disciplina
     */
    public DisciplinaAnual(String nome, int periodo) {
        super(nome, periodo);
    }

    /**
     * Retorna o numero de creditos da disciplina anual, 120 horas
     */
    @Override
    public int getCreditos() {
        return CREDITOS;
    }

    /**
     * Adiciona provas (maximo de 6 provas)
     * As 5 primeiras provas tem peso 1 (formam uma media aritmetica que tera peso 6)
     * a ultima prova tem peso 4
     * @throws Exception Excecao lancada caso a nota da prova seja invalida
     */
    @Override
    public void adicionarProva() throws Exception {
        int tamLista = this.getProvas().size();
        if(tamLista == MAX_PROVAS - 1) {
            this.setEstado(Estado.CONCLUIDA);
            return;
        }            
        
        String message = "Digite a prova de numero " + (tamLista + 1);
        this.getProvas().add(new Prova((tamLista <= 5 ? 1: 4), DataHandler.entradaNota(message)));
    }

    /**
     * Gera a media parcial da disciplina anual
     */
    @Override
    public void gerarParcial() {
        double primeiraParte = 0;
        ArrayList<Prova> p = this.getProvas();
        for(int i = 0; i < p.size(); i++) {
            primeiraParte += p.get(i).getNota();
        }
        if(p.size() < MAX_PROVAS) {
            System.out.println("Nao ha notas suficientes cadastradas");
            return;
        }
        this.setMediaParcial((((primeiraParte / 5) * 6) + (p.get(5).getNota() * p.get(5).getPeso()) / 10));
    }

}

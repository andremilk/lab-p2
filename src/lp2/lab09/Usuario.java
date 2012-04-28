package lp2.lab09;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Usuario {
    
    private String nome;
    private int matricula;
    private ArrayList<Livro> listaLivros;
    private final int maxLivros = 3;
    private int tempoMaximo;
    public static enum userType {
        ALUNO, PROFESSOR
    }
    
    public Usuario(String nome, int matricula, int tempoMaximo) {
        super();
        this.nome = nome;
        this.matricula = matricula;
        this.tempoMaximo = tempoMaximo;
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public int getMatricula() {
        return matricula;
    }
    
    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }
    
    public int getTempoMaximo() {
        return tempoMaximo;
    }
    
    public void setTempoMaximo(int tempoMaximo) {
        this.tempoMaximo = tempoMaximo;
    }
    
    public int getMaxLivros() {
        return maxLivros;
    }
    
    public boolean temAtrasados() {
        Calendar hoje = new GregorianCalendar();
        for(Livro l: this.listaLivros) {
            if(hoje.get(Calendar.DAY_OF_YEAR) - l.getDataDeLocacao().get(Calendar.DAY_OF_YEAR) > this.getTempoMaximo())
                return false;
        }
        return true;
    }
    
    public boolean alugarLivro(Livro livro) {
        if(this.listaLivros.size() < 3)
            if(!this.temAtrasados()) {
                this.listaLivros.add(livro);
                return true;
            }
        return false;
    }
      
}

package lp2.lab09;

import java.util.HashMap;
// Egit suckz
public class Usuario {
    private String nome;
    private int matricula;
    private HashMap hashLivros;
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
    
    
    
    
}

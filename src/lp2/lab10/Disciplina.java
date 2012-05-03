package lp2.lab10;

import java.util.ArrayList;

enum Estado {
    CURSANDO, CONCLUIDA
}

public abstract class Disciplina {
    
    private String nome;
    private ArrayList<Prova> provas;
    private Estado estado;
    private int creditos;
    
    Disciplina(String nome) {
        this.setNome(nome);
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getNome() {
        return this.nome;
    }
    
    public Estado getEstado() {
        return estado;
    }
    
    public void setEstado(Estado estado) {
        this.estado = estado;
    }
        
    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }
    
    public ArrayList<Prova> getProvas() {
        return provas;
    }
    
    public abstract int getCreditos();
    public abstract void adicionarProva();

}

package lp2.lab10;

import java.util.ArrayList;


/**
 * Enum responsavel por classificar as disciplinas em concluidas ou nao concluidas
 * @author dekozo
 *
 */
enum Estado {
    CURSANDO, CONCLUIDA
}

/**
 * Classe que servira de base para as sub-classes Trimestral, Semestral e Anual. 
 * @author dekozo
 *
 */
public abstract class Disciplina {
    
    /**
     * Nome da disciplina
     */
    private String nome;
    
    /**
     * ArrayList de provas da disciplina
     */
    private ArrayList<Prova> provas;
    
    /**
     * Atributo responsavel por guardar o estado da disciplina, CURSANDO ou CONCLUIDA
     */
    private Estado estado;
    
    /**
     * Numero de creditos da disciplina
     */
    private int creditos;
    
    /**
     * Construtor principal da classe Disciplina
     * @param nome nome a ser atribuido a disciplina
     * @param creditos numero de creditos a ser atribuido a disciplina
     * @param estado estado da disciplina, CURSANDO ou CONCLUIDA
     */
    Disciplina(String nome, int creditos, Estado estado) {
        this.setNome(nome);
        this.setCreditos(creditos);
        this.setEstado(estado);
    }
    
    /**
     * 
     * @param nome nome da disciplina
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    /**
     * 
     * @return retorna o nome usado da disciplina
     */
    public String getNome() {
        return this.nome;
    }
    
    /**
     * Este metodo deve ser invocado quando o historico for gerado para saber se a disciplina deve ou nao ser listada
     * @return CURSANDO para uma disciplina que esta sendo cursada e CONCLUIDA caso contrario.
     */
    public Estado getEstado() {
        return estado;
    }
    
    /**
     * 
     * @param estado Estado.CURSANDO ou Estado.CONCLUIDA
     */
    public void setEstado(Estado estado) {
        this.estado = estado;
    }
        
    /**
     * 
     * @param creditos numero de creditos da disciplina a ser usado
     */
    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }
    
    /**
     * 
     * @return objetos do tipo Prova
     */
    public ArrayList<Prova> getProvas() {
        return provas;
    }
    
    /**
     * Este metodo devera ser sobreescrito
     * @return
     */
    public abstract int getCreditos();
    
    /**
     * Este metodo devera ser sobreescrito
     */
    public abstract void adicionarProva();

}

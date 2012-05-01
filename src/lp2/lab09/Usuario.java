package lp2.lab09;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
/**
 * 
 * @author Andre Luiz Guimaraes de Souza Leite
 * @author Marcus Antonio Rocha Tenorio
 * 
 * 
 */
public class Usuario {
    
    /**
     * Nome do usuário
     */
    private String nome;
    
    /**
     * Matrícula do usuário
     */
    private int matricula;
    
    /**
     * Lista de livros em posse do usuário
     */
    private ArrayList<Livro> listaLivros;
    
    /**
     * Constante do número máximo de livros que o usuário pode pegar
     */
    private final int maxLivros = 3;
    
    /**
     * Tempo máximo que o usuário pode manter o livro
     * Este tempo varia para cada tipo de usuário
     */
    private int tempoMaximo; 
    
    /**
     * Construtor da classe Usuario
     * @param nome nome do usuário
     * @param matricula matrícula do usuário
     * @param tempoMaximo tempo máximo de posse de livros
     */
    public Usuario(String nome, int matricula, int tempoMaximo) {
        super();
        this.setNome(nome);
        this.setMatricula(matricula);
        this.setTempoMaximo(tempoMaximo);
    }
    
    /**
     * Retorna o atributo nome
     * @return nome do usuário
     */
    public String getNome() {
        return nome;
    }
    
    /**
     * Seta o nome do usuário
     * @param nome nome que se deseja setar
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    /**
     * Retorna a matricula do usuario
     * @return retorna o atributo matricula
     */
    public int getMatricula() {
        return matricula;
    }

    /**
     * 
     * @return lista de livros do usuario
     */
    public ArrayList<Livro> getListaLivros() {
        return listaLivros;
    }

    
    /**
     * Seta a matricula do usuário
     * @param matricula matrícula desejada
     */
    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }
    /**
     * Retorna o tempo máximo que o usuário pode permanecer com um livro
     * Este método deve ser sobre-escrito em classes inferiores
     * @return tempo máximo de posse do livro
     */
    public int getTempoMaximo() {
        return tempoMaximo;
    }
    
    /**
     * Set de tempo máximo de estadia do livro
     * @param tempoMaximo tempo máximo para posse de livro
     */
    public void setTempoMaximo(int tempoMaximo) {
        this.tempoMaximo = tempoMaximo;
    }
    
    /**
     * Retorna a quantidade máxima de livros que o usuário pode ter
     * @return atributo quantidade máxima
     */
    public int getMaxLivros() {
        return maxLivros;
    }
    
    /**
     * Checa se há livros atrasados em posse do usuário
     * @return retorna true se há livros atrasados e false caso não haja
     */
    public boolean temAtrasados() {
        Calendar hoje = new GregorianCalendar();
        for(Livro l: this.listaLivros) {
            if(hoje.get(Calendar.DAY_OF_YEAR) - l.getDataDeLocacao().get(Calendar.DAY_OF_YEAR) > this.getTempoMaximo())
                return true;
        }
        return false;
    }
    
    /**
     * Método para alugar um livro
     * @param livro livro que se deseja alugar
     * @return true se foi possível alugar e false caso contrário
     */
    public boolean alugarLivro(Livro livro) {
        if(this.listaLivros.size() < 3)
            if(!this.temAtrasados()) {
                this.listaLivros.add(livro);
                return true;
            }
        return false;
    }
      
}

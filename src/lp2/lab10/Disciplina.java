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
     * Atributo que guarda a media parcial da disciplina
     */
    private double mediaParcial;
    
    /**
     * Atributo da media final
     */
    private double mediaFinal;
    
    /**
     * Construtor principal da classe Disciplina
     * @param nome nome a ser atribuido a disciplina
     * @param creditos numero de creditos a ser atribuido a disciplina
     * @param estado estado da disciplina, CURSANDO ou CONCLUIDA
     */
    Disciplina(String nome, Estado estado) {
        this.setNome(nome);
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
     * @return objetos do tipo Prova
     */
    public ArrayList<Prova> getProvas() {
        return provas;
    }
    
    /**
     * Este metodo devera ser sobreescrito
     * @return numero de horas da disciplina
     */
    public abstract int getCreditos();
    
    /**
     * Este metodo devera ser sobreescrito
     * @throws Exception 
     */
    public abstract void adicionarProva() throws Exception;
    
    /**
     * Este metodo devera ser sobreescrito
     * @return a media parcial da disciplina
     */
    public abstract void gerarParcial();
    
    /**
     * Metodo que retorna a media parcial
     * @return media parcial
     */
    public double getMediaParcial() {
        return mediaParcial;
    }

    /**
     * 
     * @param mediaParcial media parcial a ser usada
     */
    public void setMediaParcial(double mediaParcial) {
        this.mediaParcial = mediaParcial;
    }
    
    /**
     * 
     * @return media final obtida na disciplina
     */
    public double getMediaFinal() {
        return this.mediaFinal;
    }
    
    /**
     * 
     * @param mediaFinal media final a ser usada para a disciplina
     */
    public void setMediaFinal(double mediaFinal) {
        this.mediaFinal = mediaFinal;
    }
    
    /**
     * Este metodo gera a media final da disciplina.
     * Se a media parcial for maior ou igual a 7, menor ou igual a 4, esta sera utilizada como media final
     * caso contrario outra prova devera ser feita
     * @throws Exception Excecao lançada caso a nota seja invalida
     */
    public void gerarFinal() throws Exception {
        if(this.getMediaParcial() >= 7 || this.getMediaParcial() <= 4)
            this.setMediaFinal(this.getMediaParcial());
        Prova provaFinal = new Prova(4, DataHandler.entradaNota("Digite a nota da prova final"));
        this.setMediaFinal(((this.getMediaParcial() * 6) + (provaFinal.getNota() * 4))/10);
        this.setEstado(Estado.CONCLUIDA);
    }

    @Override
    public String toString() {
        return "Disciplina " + nome + " (" + getCreditos() + ")" + "nota " + mediaFinal;
    }
    
    

}

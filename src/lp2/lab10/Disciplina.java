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
     * Periodo ao qual pertence a disciplina 
     */
    private int periodo;
    
    /**
     * Construtor principal da classe Disciplina
     * @param nome nome a ser atribuido a disciplina
     * @param creditos numero de creditos a ser atribuido a disciplina
     * @param estado estado da disciplina, CURSANDO ou CONCLUIDA
     */
    Disciplina(String nome, int periodo) {
        this.setNome(nome);
        this.setEstado(Estado.CURSANDO);
        this.setPeriodo(periodo);
        this.provas = new ArrayList<Prova>();
    }
    
    /**
     * Metodo para setar o nome da disciplina
     * @param nome nome da disciplina
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    /**
     * Metodo que retorna o nome da disciplina
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
     * Metodo que seta o estado da disciplina
     * @param estado Estado.CURSANDO ou Estado.CONCLUIDA
     */
    public void setEstado(Estado estado) {
        this.estado = estado;
    }
        
    /**
     * Metodo que retorna um ArrayList de objetos Prova
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
     * 
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
     * Metodo que seta a media parcial
     * @param mediaParcial media parcial a ser usada
     */
    public void setMediaParcial(double mediaParcial) {
        this.mediaParcial = mediaParcial;
    }
    
    /**
     * Metodo que retorna a media final
     * @return media final obtida na disciplina
     */
    public double getMediaFinal() {
        return this.mediaFinal;
    }
    
    /**
     * Metodo que seta a media final
     * @param mediaFinal media final a ser usada para a disciplina
     */
    public void setMediaFinal(double mediaFinal) {
        this.mediaFinal = mediaFinal;
    }
    
    public int getPeriodo() {
        return periodo;
    }

    public void setPeriodo(int periodo) {
        this.periodo = periodo;
    }

    /**
     * Este metodo gera a media final da disciplina.
     * Se a media parcial for maior ou igual a 7, menor ou igual a 4, esta sera utilizada como media final
     * caso contrario outra prova devera ser feita
     * @throws Exception Excecao lançada caso a nota seja invalida
     */
    public void gerarFinal() throws Exception {
        if(!this.taNaFinal()) {
            this.setMediaFinal(this.getMediaParcial());
            return;
        }
        Prova provaFinal = new Prova(4, DataHandler.entradaNota("Digite a nota da prova final"));
        this.setMediaFinal(((this.getMediaParcial() * 6) + (provaFinal.getNota() * 4))/10);
        this.setEstado(Estado.CONCLUIDA);
    }
    
    /**
     * Metodo que printa na tela quanto o aluno precisa na final
     */
    public void quantoParaFinal() {
        if(this.taNaFinal())
            return;
        double nota = (50 - 6*this.getMediaParcial())*4;
        System.out.println("Para a prova final voce precisa de: " + nota);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((estado == null) ? 0 : estado.hashCode());
        long temp;
        temp = Double.doubleToLongBits(mediaFinal);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(mediaParcial);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        result = prime * result + periodo;
        result = prime * result + ((provas == null) ? 0 : provas.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof Disciplina))
            return false;
        Disciplina other = (Disciplina) obj;
        if (estado != other.estado)
            return false;
        if (Double.doubleToLongBits(mediaFinal) != Double.doubleToLongBits(other.mediaFinal))
            return false;
        if (Double.doubleToLongBits(mediaParcial) != Double.doubleToLongBits(other.mediaParcial))
            return false;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        if (periodo != other.periodo)
            return false;
        if (provas == null) {
            if (other.provas != null)
                return false;
        } else if (!provas.equals(other.provas))
            return false;
        return true;
    }

    /**
     * Metodo para checar se o aluno foi para final na disciplina
     * @return true se estiver na final, false caso contrario
     */
    private boolean taNaFinal() {
        if(this.getMediaParcial() >= 7 || this.getMediaParcial() <= 4) {
            return false;
        }
            
        return true;
    }
    @Override
    public String toString() {
        String nota = (mediaFinal != mediaParcial) ? " parcial " + mediaParcial : " nota " + mediaFinal;
        return "Disciplina " + nome + " (" + getCreditos() + ")" + nota + " provas cadastradas: " + this.getProvas().size() + " ";
    }
    
    

}

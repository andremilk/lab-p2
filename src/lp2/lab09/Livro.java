package lp2.lab09;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Classe que modela um livro e os comportamentos associados a ele
 * @author Andre Luiz Guimaraes de Souza Leite
 * @author Marcus Antonio Rocha Tenorio
 * 
 * 
 */
public class Livro {
    
    /**
     * Titulo do livro
     */
    private String titulo;
    
    /**
     * Verdadeiro se o livro e alugavel e falso caso contrario
     */
    private boolean alugavel;
    
    /**
     * Lista de autores de um livro
     */
    private ArrayList<String> autores;
    
    /**
     * Nome da editora que publicou o livro
     */
    private String editora;
    
    /**
     * Status de um livro
     * @author dekozo
     *
     */
    public enum Status {
        DISPONIVEL, EMPRESTADO, RESERVADO
    }
    
    /**
     * Array de status de um livro, um livro pode ter mais de um status
     */
    private Status[] status; 
    
    /**
     * Edicao de um livro
     */
    private String edicao;
    
    /**
     * Ano de publicacao do livro
     */
    private int anoDePublicacao;
    
    /**
     * Numero de exemplares cadastrados do livro
     */
    private static long exemplares;
    
    /**
     * Total de exemplares disponiveis no momento
     */
    private static long disponiveis;
    
    /**
     * Data de locacao de um livro
     * Este atributo so e utilizado caso o livro seja locado, nao no cadastro da biblioteca
     */
    private Calendar dataDeLocacao;

    /**
     * Construtor da classe Livro que recebe todas as informacoes do livro
     * @param titulo titulo do livro a ser cadastrado
     * @param alugavel true se o livro for alugavel, false caso contrario
     * @param autores lista de autores do livro
     * @param editora editora que publica o livro
     * @param edicao edicao do livro
     * @param anoDePublicacao ano de publicacao do livro
     */
    public Livro(String titulo, boolean alugavel, ArrayList<String> autores,
            String editora, String edicao, int anoDePublicacao, long exemplares) {
        this.titulo = titulo;
        Livro.exemplares = exemplares;
        Livro.disponiveis = exemplares;
        this.alugavel = alugavel;
        this.autores = autores;
        this.editora = editora;
        this.edicao = edicao;
        this.anoDePublicacao = anoDePublicacao;
    }
    
    /**
     * Construtor da classe Livro que recebe outro Livro.
     * Este construtor servirá apenas para outro construtor que e usado na locacao de um livro
     * @param livro livro a ser locado
     */
    private Livro(Livro livro) {
        this.setTitulo(livro.getTitulo());
        this.setAlugavel(livro.getAlugavel());
        this.setAutores(livro.getAutores());
        this.setEditora(livro.getEditora());
        this.setEdicao(livro.getEdicao());
        this.setAnoDePublicacao(livro.getAnoDePublicacao());
    }
 
    /**
     * Construtor usado para locacao de um livro
     * @param livro livro a ser locado
     * @param locacao data de locacao do livro
     */
    public Livro(Livro livro, Calendar locacao) {
        this(livro);
        this.dataDeLocacao = new GregorianCalendar();
    }
    
    /**
     * get do atributo alugavel
     * @return verdadeiro se for alugavel, falso se nao for
     */
    private boolean getAlugavel() {
        return this.alugavel;
    }
    
    /**
     * @return titulo do livro
     */
    public String getTitulo() {
        return titulo;
    }
    
    /**
     * @param titulo titulo a ser usado
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    /**
     * @return true se for alugavel, false caso contrario
     */
    public boolean isAlugavel() {
        return alugavel;
    }
    
    /**
     * @param alugavel true para alugavel, false para nao alugavel
     */
    public void setAlugavel(boolean alugavel) {
        this.alugavel = alugavel;
    }
    
    /**
     * @return lista de autores do livro
     */
    public ArrayList<String> getAutores() {
        return autores;
    }
    
    /**
     * @param autores lista de autores a ser setada
     */
    public void setAutores(ArrayList<String> autores) {
        this.autores = autores;
    }
    
    /**
     * @return editora do livro
     */
    public String getEditora() {
        return editora;
    }
    
    /**
     * @param editora editora a ser setada
     */
    public void setEditora(String editora) {
        this.editora = editora;
    }
    
    /**
     * @return edicao do livro
     */
    public String getEdicao() {
        return edicao;
    }
    
    /**
     * @param edicao edicao a ser setada
     */
    public void setEdicao(String edicao) {
        this.edicao = edicao;
    }
    
    /**
     * @return ano de publicacao do livro
     */
    public int getAnoDePublicacao() {
        return anoDePublicacao;
    }
    
    /**
     * @param anoDePublicacao ano de publicacao a ser setado
     */
    public void setAnoDePublicacao(int anoDePublicacao) {
        this.anoDePublicacao = anoDePublicacao;
    }
    
    /**
     * @return numero de exemplares cadastrados do livro
     */
    public long getExemplares() {
        return exemplares;
    }
    
    /**
     * @param exemplares numero de exemplares cadastrados do livro
     */
    public void setExemplares(long exemplares) {
        Livro.exemplares = exemplares;
    }
    
    /**
     * @return numero de exemplares disponiveis do livro
     */
    public long getDisponiveis() {
        return disponiveis;
    }
    
    /**
     * @param disponiveis numero de exemplares disponiveis a ser setado
     */
    public static void setDisponiveis(long disponiveis) {
        Livro.disponiveis = disponiveis;
    }

    /**
     * @return retorna os status do livro
     */
    public Status[] getStatus() {
        return status;
    }
    
    /**
     * @return um objeto Calendar criado com a data de locacao
     */
    public Calendar getDataDeLocacao() {
        return dataDeLocacao;
    }
    
    /**
     * @param dataDeLocacao Calendar da data de locacao
     */
    public void setDataDeLocacao(Calendar dataDeLocacao) {
        this.dataDeLocacao = dataDeLocacao;
    }
    
    /**
     * @return true se o livro foi alugado, false caso contrario
     */
    public boolean serAlugado() {
        if(this.isAlugavel() && this.getDisponiveis() > 0) {
            this.setExemplares(this.getExemplares() - 1);
            return true;
        }
        return false;
    }
    
    /**
     * metodo para devolucao do livro
     * @return true
     */
    public boolean serDevolvido() {
        this.setExemplares(this.getExemplares() + 1);
        return true;
    }
 
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof Livro))
            return false;
        Livro other = (Livro) obj;
        if (alugavel != other.alugavel)
            return false;
        if (anoDePublicacao != other.anoDePublicacao)
            return false;
        if (autores == null) {
            if (other.autores != null)
                return false;
        } else if (!autores.equals(other.autores))
            return false;
        if (dataDeLocacao == null) {
            if (other.dataDeLocacao != null)
                return false;
        } else if (!dataDeLocacao.equals(other.dataDeLocacao))
            return false;
        if (edicao == null) {
            if (other.edicao != null)
                return false;
        } else if (!edicao.equals(other.edicao))
            return false;
        if (editora == null) {
            if (other.editora != null)
                return false;
        } else if (!editora.equals(other.editora))
            return false;
        if (!Arrays.equals(status, other.status))
            return false;
        if (titulo == null) {
            if (other.titulo != null)
                return false;
        } else if (!titulo.equals(other.titulo))
            return false;
        return true;
    }

}

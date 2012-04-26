package lp2.lab09;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Livro {
    
    private String titulo;
    private boolean alugavel;
    private ArrayList<String> autores;
    private String editora;
    public enum Status {
        DISPONIVEL, EMPRESTADO, RESERVADO
    }
    private Status[] status; 
    private String edicao;
    private int anoDePublicacao;
    private static long exemplares;
    private static long disponiveis;
    private Calendar dataDeLocacao;

    
    public Livro(String titulo, boolean alugavel, ArrayList<String> autores,
            String editora, String edicao, int anoDePublicacao) {
        this.titulo = titulo;
        this.alugavel = alugavel;
        this.autores = autores;
        this.editora = editora;
        this.edicao = edicao;
        this.anoDePublicacao = anoDePublicacao;
    }
    public Livro(Livro livro) {
        this.setTitulo(livro.getTitulo());
        this.setAlugavel(livro.getAlugavel());
        this.setAutores(livro.getAutores());
        this.setEditora(livro.getEditora());
        this.setEdicao(livro.getEdicao());
        this.setAnoDePublicacao(livro.getAnoDePublicacao());
    }
 
    public Livro(Livro livro, Calendar locacao) {
        this(livro);
        this.dataDeLocacao = new GregorianCalendar();
    }
    
    private boolean getAlugavel() {
        return this.alugavel;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public boolean isAlugavel() {
        return alugavel;
    }
    public void setAlugavel(boolean alugavel) {
        this.alugavel = alugavel;
    }
    public ArrayList<String> getAutores() {
        return autores;
    }
    public void setAutores(ArrayList<String> autores) {
        this.autores = autores;
    }
    public String getEditora() {
        return editora;
    }
    public void setEditora(String editora) {
        this.editora = editora;
    }
    public String getEdicao() {
        return edicao;
    }
    public void setEdicao(String edicao) {
        this.edicao = edicao;
    }
    public int getAnoDePublicacao() {
        return anoDePublicacao;
    }
    public void setAnoDePublicacao(int anoDePublicacao) {
        this.anoDePublicacao = anoDePublicacao;
    }
    public long getExemplares() {
        return exemplares;
    }
    public void setExemplares(long exemplares) {
        Livro.exemplares = exemplares;
    }
    public long getDisponiveis() {
        return disponiveis;
    }
    public static void setDisponiveis(long disponiveis) {
        Livro.disponiveis = disponiveis;
    }

    public Status[] getStatus() {
        return status;
    }
    public Calendar getDataDeLocacao() {
        return dataDeLocacao;
    }
    public void setDataDeLocacao(Calendar dataDeLocacao) {
        this.dataDeLocacao = dataDeLocacao;
    }
    public boolean serAlugado() {
        if(this.isAlugavel() && this.getDisponiveis() > 0) {
            this.setExemplares(this.getExemplares() - 1);
            return true;
        }
        return false;
    }
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

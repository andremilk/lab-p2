package lp2.lab10;

import java.util.ArrayList;

public class Aluno {

    /**
     * Nome do aluno
     */
    private String nome;
    
    /**
     * Numero de matricula do aluno
     */
    private long matricula;
    
    /**
     * Nome do curso do aluno
     */
    private String curso;
    
    /**
     * ArrayList de disciplinas do aluno
     */
    private ArrayList<Disciplina> disciplinas;
    
    /**
     * Construtor da classe Aluno
     * @param nome nome do aluno a ser criado
     * @param matricula numero de matricula do aluno
     * @param curso nome do curso do aluno
     */
    Aluno(String nome, long matricula, String curso) {
        this.setNome(nome);
        this.setMatricula(matricula);
        this.setCurso(curso);
    }
    
    /**
     * Metodo que retorna o nome do aluno
     * @return nome do aluno
     */
    public String getNome() {
        return nome;
    }
    
    /**
     * Metodo para setar o nome do aluno
     * @param nome nome a ser setado
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    /**
     * Metodo que retorna a matricula do aluno
     * @return numero de matricula
     */
    public long getMatricula() {
        return matricula;
    }
    
    /**
     * Metodo que seta o numero de matricula do aluno
     * @param matricula numero de matricula
     */
    public void setMatricula(long matricula) {
        this.matricula = matricula;
    }
    
    /**
     * Metodo que retorna o nome do curso do aluno
     * @return nome do curso
     */
    public String getCurso() {
        return curso;
    }
    
    /**
     * Metodo que seta o nome do curso do aluno
     * @param curso nome do curso a ser setado
     */
    public void setCurso(String curso) {
        this.curso = curso;
    }
    
    /**
     * Metodo que retorna as disciplinas do aluno
     * @return lista de disciplinas do aluno
     */
    public ArrayList<Disciplina> getDisciplinas() {
        return disciplinas;
    }
    
    /**
     * Metodo para adisconar um objeto Disciplina a lista de disciplinas do aluno
     * @param disc disciplina a ser adicionada
     */
    public void adicionarDisciplina(Disciplina disc) {
        this.disciplinas.add(disc);
    }
    
    /**
     * Metodo que gera o historico do aluno listando apenas disciplinas concluidas e informa o CRA
     */
    public void gerarHistorico() {
        double produtos = 0;
        double carga = 0;
        for(Disciplina d: this.getDisciplinas()) {
            if(d.getEstado() == Estado.CONCLUIDA) {
                System.out.print(d);
                produtos += (d.getMediaFinal() * d.getCreditos());
                carga += d.getCreditos();
            }
        }
        System.out.println("CRA ... " + produtos/carga);
        
    }
}

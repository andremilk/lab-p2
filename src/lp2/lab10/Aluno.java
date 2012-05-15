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
        this.disciplinas = new ArrayList<Disciplina>();
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
    
    public void gerarParciais() {
        if(this.getListaStatus(Estado.CURSANDO).isEmpty()) {
            System.out.println("Nao ha disciplinas sendo cursadas");
            return;
        }
            
        for(Disciplina d: this.getListaStatus(Estado.CURSANDO)) {
            d.gerarParcial();
            System.out.println(d + "\n");
        }
            
    }
    
    public ArrayList<Disciplina> getListaStatus(Estado estado) {
        ArrayList<Disciplina> disciplinasStatus = new ArrayList<Disciplina>();
        
        if(!this.getDisciplinas().isEmpty())
            for(Disciplina d: this.getDisciplinas()) {
                if(d != null && d.getEstado() == estado) {
                    disciplinasStatus.add(d);
                }
            }
        
        return disciplinasStatus;
    }
    
    /**
     * Metodo que gera o historico do aluno listando apenas disciplinas concluidas e informa o CRA
     * @throws Exception 
     */
    public void gerarHistorico() throws Exception {
        System.out.println(this);
        double produtos = 0;
        double carga = 0;
        for(Disciplina d: this.getListaStatus(Estado.CONCLUIDA)) {
            System.out.print(d);
            d.gerarFinal();
            System.out.println("media final = " + d.getMediaFinal());
            produtos += (d.getMediaFinal() * d.getCreditos());
            carga += d.getCreditos();
            }
        
        if(this.getDisciplinas().size() != 0)
            System.out.println("CRA ... " + produtos + " carga = " + carga);
        else
            System.out.println("Sem disciplinas cursadas");
        
    }

    @Override
    public String toString() {
        return "Aluno \n" + "Nome: " +  nome + "\nMatricula: " + matricula
                + "\nCurso: " + curso;
    }
}

package lp2.lab10;

import java.util.ArrayList;

public class Aluno {

    private String nome;
    private long matricula;
    private String curso;
    private ArrayList<Disciplina> disciplinas;
    
    Aluno(String nome, long matricula, String curso, ArrayList<Disciplina> disciplinas) {
        this.setNome(nome);
        this.setMatricula(matricula);
        this.setCurso(curso);
        this.adicionarDisciplinas(disciplinas);
    }
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public long getMatricula() {
        return matricula;
    }
    
    public void setMatricula(long matricula) {
        this.matricula = matricula;
    }
    
    public String getCurso() {
        return curso;
    }
    
    public void setCurso(String curso) {
        this.curso = curso;
    }
    
    public ArrayList<Disciplina> getDisciplinas() {
        return disciplinas;
    }
    
    public void adicionarDisciplina(Disciplina disc) {
        this.disciplinas.add(disc);
    }
    
    public void adicionarDisciplinas(ArrayList<Disciplina> disc) {
        for(Disciplina d: disc) {
            this.adicionarDisciplina(d);
        }
    }
    
    public void gerarHistorico() {
        double produtos = 0;
        double carga = 0;
        for(Disciplina d: this.getDisciplinas()) {
            if(d.getEstado() == Estado.CONCLUIDA) {
                DataHandler.printDisciplina(d.getNome(), d.getCreditos(), d.getMediaFinal());
                produtos += (d.getMediaFinal() * d.getCreditos());
                carga += d.getCreditos();
            }
        }
        System.out.println("CRA ... " + produtos/carga);
        
    }
    
    
}

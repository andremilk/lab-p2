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
        this.addDisciplinas(disciplinas);
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
    
    public void addDisciplina(Disciplina disc) {
        this.disciplinas.add(disc);
    }
    
    public void addDisciplinas(ArrayList<Disciplina> disc) {
        for(Disciplina d: disc) {
            this.addDisciplina(d);
        }
    }
    
    
    
}

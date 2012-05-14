package lp2.lab10;

import java.util.ArrayList;
import java.util.Scanner;

public class DataHandler {
    
    private static Scanner entradaString = new Scanner(System.in);
    private static Scanner entradaNum = new Scanner(System.in);

    public static double entradaNota(String message) {
        System.out.println(message);
        return entradaNum.nextDouble(); 
    }
        
    public static Aluno introMenu() {
        System.out.println("Bem vindo ao sistema GiraHistorico");
        
        System.out.println("Digite o seu nome: ");
        String nome = entradaString.nextLine();
        
        System.out.println("Digite o seu curso: ");
        
        String curso = entradaString.nextLine();
        
        System.out.println("Digite sua matricula: ");
        long matricula = entradaNum.nextLong();
        
       
        System.out.println("O CURSO FOI " + curso);
        
        return new Aluno(nome, matricula, curso);
    }
    
    public static int menu() {
        System.out.println("Menu do sistema GiraHistorico");
        System.out.println("1) Adicionar disciplina");
        System.out.println("2) Cadastrar nota em disciplina");
        System.out.println("3) Media parcial das disciplinas");
        System.out.println("4) Quanto para a final?");
        System.out.println("5) Cadastrar prova final");
        System.out.println("6) Visualizar histórico");
        System.out.println("0) Sair");
        return entradaNum.nextInt();
    }
    
    public static int escolherDisciplina(Aluno aluno) {
        ArrayList<Disciplina> disciplinas = aluno.getListaStatus(Estado.CURSANDO);
        if(disciplinas.isEmpty()) {
            System.out.println("Nao ha disciplinas sendo cursadas\n");
            return -1;
        }
        
        for(int i = 0; i < disciplinas.size(); i++)
            System.out.println((i + 1) + ")" + disciplinas.get(i));
        System.out.println("Escolha a disciplina");
        
        return aluno.getDisciplinas().indexOf(disciplinas.get(entradaNum.nextInt() - 1));
    }
    
    public static Disciplina addDisciplinaMenu() {
        int tipo;
        
        do {
            System.out.println("Escolha o tipo de disciplina\n1) Trimestral\n2) Semestral\n3) Anual\n0) Voltar");
            System.out.println("Disciplina: ");
            tipo = entradaNum.nextInt();
            if(tipo == 0)
                return null;
        } while(tipo > 3 || tipo < 1);
        
        System.out.println("Nome da disciplina :");
        String nome = entradaString.nextLine();
        
        System.out.println("Periodo: ");
        int periodo = entradaNum.nextInt();
        switch(tipo) {
            case 1:
                return new DisciplinaTrimestral(nome, periodo);
            case 2:
                return new DisciplinaSemestral(nome, periodo);
            case 3:
                return new DisciplinaAnual(nome, periodo);
        }
        return null;
    }
    
}












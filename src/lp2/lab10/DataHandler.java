package lp2.lab10;

import java.util.ArrayList;
import java.util.Scanner;

public class DataHandler {
    
    private static Scanner entrada = new Scanner(System.in);

    public static double entradaNota(String message) {
        System.out.println(message);
        return entrada.nextDouble(); 
    }
        
    public static Aluno introMenu() {
        System.out.println("Bem vindo ao sistema GiraHistorico");
        
        System.out.println("Digite o seu nome: ");
        String nome = entrada.nextLine();
        
        System.out.println("Digite sua matricula: ");
        long matricula = entrada.nextLong();
        
        System.out.println("Digite o seu curso: ");
        String curso = entrada.nextLine();
        
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
        return entrada.nextInt();
    }
    
    public static int escolherDisciplina(Aluno aluno) {
        ArrayList<Disciplina> disciplinas = aluno.getListaStatus(Estado.CURSANDO);
        for(int i = 0; i <= disciplinas.size(); i++)
            System.out.println((i + 1) + ")" + disciplinas.get(i));
        System.out.println("Escolha a disciplina");
        
        return aluno.getDisciplinas().indexOf(disciplinas.get(entrada.nextInt()));
    }
    
    public static Disciplina addDisciplinaMenu() {
        int tipo;
        
        do {
            System.out.println("Escolha o tipo de disciplina\n1) Trimestral\n2)Semestral\n3)Anual");
            System.out.println("Disciplina: ");
            tipo = entrada.nextInt();
        } while(tipo > 3 || tipo < 1);
        
        System.out.println("Nome da disciplina :");
        String nome = entrada.nextLine();
        
        System.out.println("Periodo: ");
        int periodo = entrada.nextInt();
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












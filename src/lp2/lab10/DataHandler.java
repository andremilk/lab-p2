package lp2.lab10;

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
    
}












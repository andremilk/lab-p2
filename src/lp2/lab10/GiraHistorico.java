package lp2.lab10;

import java.util.Scanner;

public class GiraHistorico {

    
    public enum Flag {
        ATIVO, DESATIVO
    }
    
    private static Flag flag = Flag.ATIVO;
    private static Scanner entrada = new Scanner(System.in);
    private static Aluno s_aluno; 
   
    public static void main(String[] args) {
        s_aluno = DataHandler.introMenu();
        
        while(flag == Flag.ATIVO) {
            
        }
        
        
    
    }


}

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
      //  s_aluno.gerarHistorico();
        while(flag == Flag.ATIVO) {
            switch(DataHandler.menu()) {
                case 0:
                    flag = Flag.DESATIVO;
                    break;
                case 1:
                    s_aluno.adicionarDisciplina(DataHandler.addDisciplinaMenu());
                    break;
                case 2:
                case 5:
                    int escolhida = 
                        DataHandler.escolherDisciplina(s_aluno);
                    try {
                        s_aluno.getDisciplinas().get(escolhida).adicionarProva();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 3:
                    s_aluno.gerarParciais();
                    break;
                case 4:
                    int quantoFinal = 
                        DataHandler.escolherDisciplina(s_aluno);
                    s_aluno.getDisciplinas().get(quantoFinal).quantoParaFinal();
                    break;       
                case 6:
                    s_aluno.gerarHistorico();
        }
        
        
    
    }


}
}

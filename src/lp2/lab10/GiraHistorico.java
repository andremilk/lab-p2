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
        s_aluno.gerarHistorico();
        while(flag == Flag.ATIVO) {
            switch(DataHandler.menu()) {
                case 0:
                    flag = Flag.DESATIVO;
                    break;
                case 1:
                    s_aluno.adicionarDisciplina(DataHandler.addDisciplinaMenu());
                    break;
                case 2:
                    Disciplina escolhida = 
                        DataHandler.escolherDisciplina(s_aluno.getListaStatus(Estado.CURSANDO), DataHandler.ADICIONAR_PROVA);
                    int index = s_aluno.getDisciplinas().indexOf(escolhida);
                    try {
                        s_aluno.getDisciplinas().get(index).adicionarProva();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                    // aqui o aluno passa pra dataHandler as disciplinas que ele esta cursando para 
                    // adicionar notas
                    // e dataHandler volta o index da disciplina 
                    // entao aluno.getdisciplinas.get(numero tal).addprova
                    
                        
            }
            
        }
        
        
    
    }


}

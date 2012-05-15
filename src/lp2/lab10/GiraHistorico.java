package lp2.lab10;

public class GiraHistorico {

    
    public enum Flag {
        ATIVO, DESATIVO
    }
    
    private static Flag flag = Flag.ATIVO;
    private static Aluno s_aluno; 
   
    public static void main(String[] args) throws Exception {
        
        s_aluno = DataHandler.introMenu();
       
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
                        break;
                    } catch (Exception e) {
                        break;
                    }
                    
                case 3:
                    s_aluno.gerarParciais();
                    break;
                case 4:
                    int quantoFinal = 
                        DataHandler.escolherDisciplina(s_aluno);
                    try {
                        s_aluno.getDisciplinas().get(quantoFinal).quantoParaFinal();
                    } catch (Exception e) {
                        break;
                    }
                    
                    break;       
                case 6:
                    s_aluno.gerarHistorico();
        }
        
        
    
    }


}
}

package lp2.lab03;
/* Aluno: André Luiz Guimarães de Souza Leite */
import java.util.Scanner;

public class Robo {
        
        private static final int SUBIR = 1;
        private static final int DESCER = 2;
        private static final int DIREITA = 3;
        private static final int ESQUERDA = 4;
        private static final int TAMANHO = 10;
        private static final int OCUPADO = 1;
        private static final int LIVRE = 0;
        private static int[][] sala = new int[TAMANHO][TAMANHO];
        private static final String PROMPT = "Indique a movimentação desejada: \n" +
                        "1 (SUBIR), 2(DESCER), 3 (DIREITA), 4 (ESQUERDA), (<= 0 para sair) \n" +
                        ">> ";
        
        public static void subir() {
                int[] posicao = Robo.getPosicao();
                int i = posicao[0];
                int j = posicao[1];
                
                if(sala[i][j] == OCUPADO)
                        if((j - 1) < 0)
                                System.out.println("Movimentação não é possível");
                        else {
                                sala[i][j] = LIVRE;
                                sala[i][j-1] = OCUPADO;
                                System.out.println("Robô subiu um nível. Agora ele está na posição: [" + i + "," + (j-1) + "]" );
                        }
        }
        
        public static void descer() {
                int[] posicao = Robo.getPosicao();
                int i = posicao[0];
                int j = posicao[1];
                                
                if ((j + 1) == TAMANHO)
                        System.out.println("Movimentação não é possível");
                else {
                        sala[i][j] = LIVRE;
                        sala[i][j+1] = OCUPADO;
                        System.out.println("Robô desceu um nível. Agora ele está na posição: [" + i + "," + (j+1) + "]");
                }
        }
        
        public static void irParaDireita() {
                int[] posicao = Robo.getPosicao();
                int i = posicao[0];
                int j = posicao[1];
                
                if ((i + 1) == TAMANHO)
                        System.out.println("Movimentação não é possível");
                else {
                        sala[i][j] = LIVRE;
                        sala[i+1][j] = OCUPADO;
                        System.out.println("Robô andou um nível para a direita. Agora ele está na posição: [" + (i+1) + "," + j + "]");
                }
        }
        
        public static void irParaEsquerda() {
                int[] posicao = Robo.getPosicao();
                int i = posicao[0];
                int j = posicao[1];
                
                if ((i - 1) < 0)
                        System.out.println("Movimentação não é possível");
                else {
                        sala[i][j] = LIVRE;
                        sala[i-1][j] = OCUPADO;
                        System.out.println("Robô andou um nível para a esquerda. Agora ele está na posição: [" + (i-1) + "," + j + "]");
                }
        }
                        
        public static int[] getPosicao() {
                int[] posicao = new int[2];
                for(int j = 0; j < TAMANHO; j++)
                        for(int i = 0; i < TAMANHO; i++)
                                if (sala[i][j] == OCUPADO) {
                                        posicao[0] = i;
                                        posicao[1] = j;
                                        return posicao;
                                }
                
                return posicao;
        }
        
        public static void main(String args[]) {

                Scanner entrada = new Scanner(System.in);
                int movimento;
                
                Robo.sala[0][0] = OCUPADO;
                
                do {
                        
                        System.out.print(PROMPT);
                        movimento = entrada.nextInt();
                        
                        switch (movimento){
                                case SUBIR:
                                        Robo.subir();
                                        break;
                                case DESCER:
                                        Robo.descer();
                                        break;
                                case DIREITA:
                                        Robo.irParaDireita();
                                        break;
                                case ESQUERDA:
                                        Robo.irParaEsquerda();
                                        break;                  
                        }
                
                } while(movimento > 0);
                
        }
}
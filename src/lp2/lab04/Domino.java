package lp2.lab04;
/* Aluno: André Luiz Guimarães de Souza Leite 
 * Aluno: Marcus Antônio Rocha Tenório
 */
import java.util.ArrayList;

class Peca {
        public static ArrayList<String> pecas = Peca.gerarPecas();
        
        public static String[][] distribuiPecas(int jogadores, int pecasPorJogador) {
                String[][] jogo = new String[jogadores][pecasPorJogador];

                for(int i = 0; i < jogadores; i++)
                        for(int j = 0; j < pecasPorJogador; j++) {
                                double sorte = 0 + Math.random() * (pecas.size() - 1);
                                int pedra = (int) Math.floor(sorte);
                                jogo[i][j] = pecas.get(pedra);
                                pecas.remove(pedra);
                        }
                return jogo;
        }
        
        public static ArrayList<String> gerarPecas() {
                ArrayList<String> pecas = new ArrayList<String>(28);
                for(int i = 0; i <= 6; i++)
                        for(int j = i; j <= 6; j++) {
                                pecas.add(i + "-" + j);
                        }
                return pecas;
        }
}

public class Domino {

        /**
         * @param args
         */
        public static void main(String[] args) {
                // TODO Auto-generated method stub
                int[] entradaDeDados = parseEntrada(args);
                if(entradaDeDados != null) {
                        if(entradaDeDados[2] == 0) {
                                String[][] jogo = Peca.distribuiPecas(entradaDeDados[0], entradaDeDados[1]);
                                System.out.println("Jogadores: " + jogo.length);
                                System.out.println("Peças por jogador: " + jogo[0].length + "\n\n");
                        
                                printarJogo(jogo);
                        }
                        else
                                printarMedia(entradaDeDados);
                }
        }
        
        public static void printarMedia(int[] dados) {
                ArrayList<String> carrocas = new ArrayList<String>(6);

                System.out.println("Simulando " + dados[2] + " distribuições, a média de carroções por jogador é: \n");
                // adicionando carrocas
                for(int i = 0; i <= 6; i++)
                        carrocas.add(i + "-" + i);
                
                int[] media = new int[dados[0]];
                for(int vez = 0; vez < dados[2]; vez++) {
                        String[][] jogo = Peca.distribuiPecas(dados[0], dados[1]);
                        Peca.pecas = Peca.gerarPecas();
                        for(int i = 0; i < jogo.length; i++) {
                                for(String s: jogo[i]) {
                                        if(carrocas.contains(s)) {
                                                media[i]++;
                                        }
                                }
                        }                               
                }
                
                for(int i = 0; i < media.length; i++)
                        System.out.println("Jogador " + (i + 1) + ":" + " " + (float)media[i]/dados[2]);
        }
        
        public static int[] parseEntrada(String[] entrada) {
                int[] parsed = new int[3];
                if(entrada.length < 2 || (Integer.parseInt(entrada[0]) * Integer.parseInt(entrada[1]) > 28)) {
                        System.out.println("Parâmetros insuficientes.");
                        System.out.println("Modo de usar: java lp2.lab04.Domino <jogadores> <peças-por-jogador>");
                        return null;
                }
                else 
                        for(int i = 0; i < entrada.length; i++)
                                parsed[i] = Integer.parseInt(entrada[i]);
                return parsed;
        }
        
        public static void printarJogo(String[][] jogo) {
                System.out.println("Mãos:");
                for(int i = 0; i < jogo.length; i++) {
                        System.out.print("Jogador " + (i + 1) + ": ");
                        for(String s: jogo[i])
                                System.out.print(s + " ");
                        System.out.println();
                }
        }

}
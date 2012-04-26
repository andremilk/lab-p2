package lp2.lab07;
/* André Luiz Guimarães de Souza Leite 21121393 */
public class Sala {
	
	static int LIVRE = 0;
	static int OCUPADO = 1;
	private int[][] matriz;
	
	public Sala(int linha, int coluna) throws Exception {
		if(linha <= 0 || coluna <= 0)
			throw new Exception("Parâmetros incorretos para a criação da sala.");
		this.matriz = new int[linha][coluna];
	}
	
	public boolean inserirObstaculo(int linha, int coluna) {
		if(this.verificarPosicaoLivre(linha, coluna)) {
			this.matriz[linha][coluna] = OCUPADO;
			return true;
		}
		return false;
	}
	
	public boolean verificarPosicaoLivre(int linha, int coluna) {
		if(this.posicaoValida(linha, coluna))
			return this.matriz[linha][coluna] == LIVRE ? true: false;
		return false;
	}
	
	public boolean posicaoValida(int linha, int coluna) {
		if(((this.matriz.length -1 >= linha) && (this.matriz[0].length -1 >= coluna)) && (linha >= 0 && coluna >= 0))
			return true;
		return false;
	}
	
	public boolean setPosicao(int linha, int coluna, int situacao) {
		if(this.posicaoValida(linha, coluna)) {
			this.matriz[linha][coluna] = situacao;
			return true;
		}
		return false;
	}
	
}

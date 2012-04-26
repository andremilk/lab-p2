package lp2.lab07;

/* André Luiz Guimarães de Souza Leite 21121393 */

public class Robo {
	
	private Sala sala;
	private int energia;
	private int x, y;
	private int passos = 0;
	
	public Robo(int energia, Sala sala) throws Exception {
	    this(energia, sala, 0, 0);
	}
	
	public Robo(int energia, Sala sala, int linha, int coluna) throws Exception {
	        if(energia <= 0)
                    throw new Exception("A energia deve ser positiva.");
                this.sala = sala;
                this.energia = energia;
                this.x = 0;
                this.y = 0;
                sala.setPosicao(this.x, this.y, Sala.OCUPADO);
	}
	
	
	public boolean subir() {
		if(sala.posicaoValida(this.x - 1, this.y)  && this.possuiEnergia() && sala.verificarPosicaoLivre(this.x -1, this.y)) {
			this.energia--;
			sala.setPosicao(this.x - 1, this.y, Sala.OCUPADO);
			sala.setPosicao(this.x, this.y, Sala.LIVRE);
			this.x--;
			this.passos++;
			return true;
		}
		return false;
	}
	
	public boolean descer() {
		if(sala.posicaoValida(this.x + 1, this.y)  && this.possuiEnergia() && sala.verificarPosicaoLivre(this.x + 1, this.y)) {
			this.energia--;
			sala.setPosicao(this.x + 1, this.y, Sala.OCUPADO);
			sala.setPosicao(this.x, this.y, Sala.LIVRE);
			this.x++;
			this.passos++;
			return true;
		}
		return false;
	}

	public boolean direita() {
		if(sala.posicaoValida(this.x, this.y + 1) && this.possuiEnergia() && sala.verificarPosicaoLivre(this.x, this.y + 1)) {
			this.energia--;
			sala.setPosicao(this.x, this.y + 1, Sala.OCUPADO);
			sala.setPosicao(this.x, this.y, Sala.LIVRE);
			this.y++;
			this.passos++;
			return true;
		}
		return false;
	}
	
	public boolean esquerda() {
		if(sala.posicaoValida(this.x, this.y - 1) && this.possuiEnergia() && sala.verificarPosicaoLivre(this.x, this.y -1)) {
			this.energia--;
			sala.setPosicao(this.x, this.y - 1, Sala.OCUPADO);
			sala.setPosicao(this.x, this.y, Sala.LIVRE);
			this.y--;
			this.passos++;
			return true;
		}
		return false;
	}
	
	public boolean possuiEnergia() {
		return this.energia > 0 ? true: false;
	}
	public int getLinhaAtual() {
		return this.x;
	}
	
	public int getColunaAtual() {
		return this.y;
	}
	
	public int getEnergia() {
		return this.energia;
	}
	
	public int getPassos() {
		return this.passos;
	}
	

}

package prova1;

public class Celula {

	private int x;
	private int y;
	private int quadrante;
	private String condicao;
	
	public Celula(int x,int y) {
		if(x>=0 && x<=8) {
			this.x = x;
		}
		if(y>=0 && y<=16) {
			this.y = y;
		}
	}
	
	public Celula() {
		
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public int getQuadrante() {
		return quadrante;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public void determinarQuadrante() {
		quadrante = 0;
		if(x<5 && y<8) {
			quadrante = 1;
		} else if(x<5 && y>7) {
			quadrante = 2;
		} else if(x>4 && y<8) {
			quadrante = 3;
		} else if(x>4 && y>7) {
			quadrante = 4;
		}
	}
	
	public void determinarSituacao() {
		condicao = "Dentro";
		if(y==0 || y==16 || x==0) {
			condicao = "Fora";
		} else if(y==1 && x>1) {
			condicao = "Trave Esquerda";
		} else if(y==15 && x>1) {
			condicao = "Trave Direita";
		} else if(x==1 && y>0 && y<16) {
			condicao = "Trave Superior";
		}
	
	}
	
}

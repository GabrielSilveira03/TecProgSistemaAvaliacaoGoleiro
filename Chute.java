package prova1;

public class Chute {

	private int id;
	private int forca;
	private int quadrante;
	private int x;
	private int y;
	private String condicao;
	
	public Chute(int id,int forca,int quadrante,int x,int y) {
		this.id = id;
		this.forca = forca;
		this.quadrante = quadrante;
		if(x>=0 && x<=8) {
			this.x = x;
		}
		if(y>=0 && y<=16) {
			this.y = y;
		}
	}
	
	public Chute(Chute c) {
		this.id = c.getId();
		this.forca = c.getForca();
		this.quadrante = c.getQuadrante();
		this.x = c.getX();
		this.y = c.getY();
	}
	
	public int getId() {
		return id;
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
	
	public int getForca() {
		return forca;
	}
	
	public String getCondicao() {
		return condicao;
	}
	
	public void setCondicao(String s) {
		condicao = s;
	}
	
}

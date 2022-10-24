package prova1;

import java.util.ArrayList;

public class Goleiro {

	private int id;
	private String nome;
	private int velocidade;
	private int flexibilidade;
	private int agilidade;
	private int coordenacao;
	private int forca;
	private int equilibrio;
	private int aag;
	private ArrayList<Chute> totalChutes = new ArrayList<Chute>();
	private ArrayList<Chute> golstomados = new ArrayList<Chute>();
	private ArrayList<Chute> chutesdefendidos = new ArrayList<Chute>();
	private ArrayList<Chute> golsporforca = new ArrayList<Chute>();
	private ArrayList<Chute> golsangulo = new ArrayList<Chute>();
	private String selecao;
	private int quadrantemaisgols;
	
	public Goleiro(String nome,int id,int velocidade,int flexibilidade, int agilidade,int coordenacao,int forca,int equilibrio) {
		this.nome = nome;
		this.id = id;
		this.velocidade = velocidade; 
		this.flexibilidade = flexibilidade;
		this.agilidade = agilidade;
		this.coordenacao = coordenacao;
		this.forca = forca;
		this.equilibrio = equilibrio;
		calculoAreaAtuacao();
	}
	
	public Goleiro() {
		
	}
	
	public int getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public int getAAG() {
		return aag;
	}
	
	public int getForca() {
		return forca;
	}
	
	public String getSelecao() {
		return selecao;
	}
	
	public int getQuantidadeGolsTomados() {
		return golstomados.size();
	}
	
	public int getQuantidadeChutesDefendidos() {
		return chutesdefendidos.size();
	}
	
	public ArrayList<Chute> getTotalChutes(){
		return totalChutes;
	}
	
	public ArrayList<Chute> getGolsAngulo(){
		return golsangulo;
	}
	
	public ArrayList<Chute> getGolsForca(){
		return golsporforca;
	}
	
	public int getQuadranteMaisGols() {
		return quadrantemaisgols;
	}
	
	public void setSelecao(String selecao) {
		this.selecao = selecao;
	}
	
	public void addChute(Chute c) {
		totalChutes.add(c);
	}
	
	
	public void addGolsTomados(Chute c) {
		golstomados.add(c);
	}
	
	public void addChuteDefendido(Chute c) {
		chutesdefendidos.add(c);
	}
	
	public void addGolsPorForca(Chute c) {
		golsporforca.add(c);
	}
	
	public void addGolsAngulo(Chute c) {
		golsangulo.add(c);
	}
	
	public void calculoAreaAtuacao() {
		aag = ((velocidade*3)+(flexibilidade*2)+(agilidade*3)+(coordenacao*2)+(forca)+(equilibrio*2))/8;
	}
	
	//Metodo auxiliar para a funcionalidade 5
	public void verificarGolAngulo() {
		for (Chute chute : golstomados) {
			if((chute.getX()==2 && chute.getY()==2) || (chute.getX()==2 && chute.getY()==14)) {
				addGolsAngulo(chute);
			}
		}
	}
	
	//Metodo auxiliar para a funcionalidade 8
	public String exibirInformacoes() {
		String informacoes = "";
		informacoes += "Nome do Goleiro: " + nome;
		informacoes += "\nSelecao que o Goleiro faz parte: " + selecao;
		informacoes += "\nO goleiro realizou " + chutesdefendidos.size() + " defesas";
		informacoes += "\nO goleiro tomou " + golstomados.size() + " gols";
		informacoes += "\nAreá de Atuacao do Goleiro: " + aag;

		
		return informacoes;
	}
	
	//Metodo auxiliar para a funcionalidade 9
	public void quadranteMaisGols() {
		int qdt1=0,qdt2=0,qdt3=0,qdt4=0;
		int maisgols=0;
		ArrayList<Integer> qdts = new ArrayList<Integer>();
		for (Chute chute : golstomados) {
			if(chute.getQuadrante()==1) {
				qdt1++;
			} else if(chute.getQuadrante()==2) {
				qdt2++;
			} else if(chute.getQuadrante()==3) {
				qdt3++;
			} else if(chute.getQuadrante()==4) {
				qdt4++;
			}
		}
		qdts.add(qdt1);
		qdts.add(qdt2);
		qdts.add(qdt3);
		qdts.add(qdt4);
		
		for (int contador = 0; contador < 4; contador++) {
			if(qdts.get(contador)>maisgols) {
				maisgols=qdts.get(contador);
				quadrantemaisgols = contador+1;
			}
		} 	
	}
	
	
	
	
	
	
}

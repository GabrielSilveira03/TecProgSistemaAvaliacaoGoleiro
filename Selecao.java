package prova1;

import java.util.ArrayList;

public class Selecao {

	private String nome;
	private ArrayList<Goleiro> listaGoleiros = new ArrayList<Goleiro>();
	private double mediaBolasDefendidas;
	private double mediaGolsTomados;
	private Goleiro goleiroTitular = new Goleiro();
	
	public Selecao(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	
	public ArrayList<Goleiro> getListaGoleiros(){
		return listaGoleiros;
	}
	
	public double getMediaDefesas() {
		return mediaBolasDefendidas;
	}
	
	public double getMediaGols() {
		return mediaGolsTomados;
	}
	
	public Goleiro getGoleiroTitular() {
		return goleiroTitular;
	}
	
	
	
	public void addGoleiro(Goleiro g) {
		listaGoleiros.add(g);
		g.setSelecao(nome);
		g.calculoAreaAtuacao();
	}
	
	//Metodo auxiliar para a funcionalidade 1
	public void calculoMediaDefesa() {
		int totalbolasdefendidas=0;
		for (Goleiro goleiro : listaGoleiros) {
			totalbolasdefendidas += goleiro.getQuantidadeChutesDefendidos();
		}
		mediaBolasDefendidas = totalbolasdefendidas/listaGoleiros.size();
	}
	
	//Metodo auxiliar para a funcionalidade 2
		public void determinarGoleiroTitular() {
			int menosgols=100;
			for (Goleiro goleiro : listaGoleiros) {
				if(goleiro.getQuantidadeGolsTomados()<menosgols) {
					menosgols = goleiro.getQuantidadeGolsTomados();
					goleiroTitular = goleiro;
				}
			}
		}
	
	//Metodo auxiliar para a funcionalidade 3
	public void calculoMediaGols() {
		int totalgolstomados=0;
		for (Goleiro goleiro : listaGoleiros) {
			totalgolstomados += goleiro.getQuantidadeGolsTomados();
		}
		mediaGolsTomados = totalgolstomados/listaGoleiros.size();
	}
	
	
	
}

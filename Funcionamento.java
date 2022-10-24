package prova1;

import java.util.ArrayList;
import java.util.Random;

public class Funcionamento {

	private ArrayList<Selecao> listaSelecoes = new ArrayList<Selecao>();
	private ArrayList<Chute> listaChutes = new ArrayList<Chute>();
	private ArrayList<Celula> listaCelulas = new ArrayList<Celula>();
	private Goleiro PrimeiroGoleiro = new Goleiro();
	private Goleiro SegundoGoleiro = new Goleiro();
	private Goleiro TerceiroGoleiro = new Goleiro();
	private int qtdbolasforas;
	private int qtdtravedireita;
	private int qtdtraveesquerda;
	private int qtdtravesuperior;

			
	
	public void addSelecao(Selecao s) {
		listaSelecoes.add(s);
		s.calculoMediaDefesa();
		s.calculoMediaGols();
		s.determinarGoleiroTitular();
	}
	
	public void addChute(Chute c) {
		listaChutes.add(c);
	}
	
	public void addCelula(Celula c) {
		listaCelulas.add(c);
		c.determinarQuadrante();
		c.determinarSituacao();
	}
	

	
	public void gerarResultados() {
			
		Celula cAux = new Celula();
			
		for (Selecao selecao : listaSelecoes) {
			for (Goleiro goleiro : selecao.getListaGoleiros()) {
				goleiro.calculoAreaAtuacao();
				for (Chute chute : listaChutes) {
					cAux = sortearPosicao(chute);
					verificarGol(cAux, chute, goleiro);
					}
				}
			}
		
		}

	public void verificarGol(Celula cAux, Chute chute, Goleiro goleiro) {
			
		int x = cAux.getX();
		int y = cAux.getY();
		int contador = 0, somador, aag = goleiro.getAAG();
		boolean defesa = false;
		somador = aag % 4 == 0 ? (aag / 4) - 1 : (aag / 4);
		
		Chute aux = new Chute(chute);
		
		do {
			if (contador < 4) {
				if (x == chute.getX() && y == chute.getY()) {
					if (contador == 3) { 
						if (goleiro.getForca() >= chute.getForca()) {
							defesa = true;
						} else { 
							goleiro.addGolsPorForca(chute);
							defesa = false;
						}

					} else if (y == cAux.getY() + somador) { 
						if (goleiro.getForca() >= chute.getForca()) {
							defesa = true;
						} else { 
							goleiro.addGolsPorForca(chute);
							defesa = false;
						}
					} else
						defesa = true;

				}
					aag--;
					contador++;
					x = x > 0 ? x -= 1 : cAux.getX();
				} else {
					x = cAux.getX();
					y = y < 15 ? y += 1 : y;
					contador = 0;
				}

			} while ((aag > 0 && defesa == false));
			if (defesa == true) {
				aux.setCondicao("Defesa");
				goleiro.addChute(aux);
				goleiro.addChuteDefendido(aux);
			} else {
				aux.setCondicao("Gol");
				goleiro.addChute(aux);
				goleiro.addGolsTomados(aux);
			}
		}

		
	public Celula sortearPosicao(Chute chute) {
			
		Random aleatorio = new Random();
			
		Celula cAux = new Celula();
		do {
			cAux.setX(aleatorio.nextInt(8));
			cAux.setY(aleatorio.nextInt(16));
			cAux.determinarQuadrante();;
		} while (cAux.getQuadrante() != chute.getQuadrante());
			
		return cAux;
			
		}
	
	
	//Metodo que realiza a funcionalidade 1
	public String mediaDefesasCadaSelecao() {
		String resultado = "\n\nMEDIA DE DEFESAS REALIZADAS PELOS GOLEIROS DE CADA  SELECAO\n";
		for (Selecao selecao : listaSelecoes) {
			selecao.calculoMediaDefesa();
			resultado += "\nSelecao: " + selecao.getNome() + "\tMedia: " + selecao.getMediaDefesas();
		}
		
		return resultado;
	}
	
	//Metodo que realiza a funcionalidade 2
			public String goleiroTitularCadaSelecao() {
				String resultado = "\n\nINDICACAO DE GOLEIRO TITULAR IDEAL DE CADA SELECAO\n";
				for (Selecao selecao : listaSelecoes) {
					selecao.determinarGoleiroTitular();
					resultado += "\nSelecao: " + selecao.getNome() + "\tGoleiro: " + selecao.getGoleiroTitular().getNome();
				}
				
				return resultado;
			}
	
	//Metodo que realiza a funcionalidade 3
		public String mediaGolsCadaSelecao() {
			String resultado = "\n\nMEDIA DE GOLS SOFRIDOS PELOS GOLEIROS DE CADA SELECAO\n";
			for (Selecao selecao : listaSelecoes) {
				selecao.calculoMediaGols();
				resultado += "\nSelecao: " + selecao.getNome() + "\tMedia: " + selecao.getMediaGols();
			}
			
			return resultado;
		}
	
	//Metodo que realiza a funcionalidade 4
	public String chutesNaoGol() {
		for (Chute c : listaChutes) {
			if(c.getY()==0 || c.getY()==16 || c.getX()==0) {
				qtdbolasforas++;
			} else if(c.getY()==1 && c.getX()>1) {
				qtdtraveesquerda++;
			} else if(c.getY()==15 && c.getX()>1) {
				qtdtravedireita++;
			} else if(c.getX()==1 && c.getY()>0 && c.getY()<16) {
				qtdtravesuperior++;
			}
		}
		String resultado = "\n\nQUANTIDADE DE OCORRENCIAS EM QUE O CHUTE REALIZADO FOI PARA FORA OU NA TRAVE\n";
		resultado += "\nQuantidade de chutes que foram para fora: " + qtdbolasforas;
		resultado += "\nQuantidade de chutes que atingiram a trave direita: " + qtdtravedireita;
		resultado += "\nQuantidade de chutes que atingiram a trave esquerda: " + qtdtraveesquerda;
		resultado += "\nQuantidade de chutes que atingiram a trave superior: " + qtdtravesuperior;
		
		return resultado;
	}
	
	//Metodo que realiza a funcionalidade 5
	public String golsAngulo() {
		String resultado = "\n\nOCORRENCIAS EM QUE O GOL FOI NO ANGULO\n";
		for (Selecao selecao : listaSelecoes) {
			for (Goleiro goleiro : selecao.getListaGoleiros()) {
				for (Chute chute : goleiro.getGolsAngulo()) {
					resultado += "\nGoleiro: " + goleiro.getNome() + "\tId do chute: " + chute.getId();
				}
			}
		}
		
		return resultado;
	}
	
	//Metodo que realiza a funcionalidade 6
	public String melhoresGoleiros() {
		String resultado = "\n\nSELECOES QUE POSSUEM OS 3 MELHORES GOLEIROS\n";
		int menosGols = 100,menosGols2 = 100, menosGols3 = 100;
		for (Selecao selecao : listaSelecoes) {
			selecao.determinarGoleiroTitular();
			if(selecao.getGoleiroTitular().getQuantidadeGolsTomados()<menosGols) {
				TerceiroGoleiro = SegundoGoleiro;
				SegundoGoleiro = PrimeiroGoleiro;
				PrimeiroGoleiro = selecao.getGoleiroTitular();
				menosGols = selecao.getGoleiroTitular().getQuantidadeGolsTomados();
			} else if(selecao.getGoleiroTitular().getQuantidadeGolsTomados()<menosGols2) {
				TerceiroGoleiro = SegundoGoleiro;
				SegundoGoleiro = selecao.getGoleiroTitular();
				menosGols2 = selecao.getGoleiroTitular().getQuantidadeGolsTomados();
			} else if(selecao.getGoleiroTitular().getQuantidadeGolsTomados()<menosGols3) {
				TerceiroGoleiro = selecao.getGoleiroTitular();
				menosGols3 = selecao.getGoleiroTitular().getQuantidadeGolsTomados();
			}
		}
		
		resultado += "\nSelecao que tem o melhor goleiro: " + PrimeiroGoleiro.getSelecao() + "\t\tNome do Goleiro: " + PrimeiroGoleiro.getNome();
		resultado += "\nSelecao que tem o segundo melhor goleiro: " + SegundoGoleiro.getSelecao() + "\tNome do Goleiro: " + SegundoGoleiro.getNome();
		resultado += "\nSelecao que tem o terceiro melhor goleiro: " + TerceiroGoleiro.getSelecao() + "\tNome do Goleiro: " + TerceiroGoleiro.getNome();
		
		return resultado;
	}
	
	//Metodo que realiza a funcionalidade 7
	public String golsPorForca() {
		String resultado = "\n\nOCORRENCIAS EM QUE O GOL FOI FEITO POR FORCA\n";
		for (Selecao selecao : listaSelecoes) {
			for (Goleiro goleiro : selecao.getListaGoleiros()) {
				for (Chute chute : goleiro.getGolsAngulo()) {
					resultado += "\nGoleiro: " + goleiro.getNome() + "\tId do chute: " + chute.getId();
				}
			}
		}
		
		return resultado;
	}
	
	//Metodo que realiza a funcionalidade 8
	public String exibirInformacoesGoleiros() {
		String resultado = "\n\nEXIBIR INFORMACOES DOS GOLEIROS\n";
		for (Selecao selecao : listaSelecoes) {
			for (Goleiro goleiro : selecao.getListaGoleiros()) {
					goleiro.calculoAreaAtuacao();
					resultado += goleiro.exibirInformacoes() + "\n\n";
			}
		}
		
		return resultado;
	}
	
	//Metodo que realiza a funcionalidade 9
	public String quadranteMaisGols(int id) {
		String resultado = "\n\nEXIBIR O QUADRANTE QUE O GOLEIRO INFORMADO PELO ID TOMOU MAIS GOLS\n";
		for (Selecao selecao : listaSelecoes) {
			for (Goleiro goleiro : selecao.getListaGoleiros()) {
				goleiro.quadranteMaisGols();
				if(goleiro.getId()==id) {
					resultado += " O quadrante em que o goleiro tomou mais gols foi: " + goleiro.getQuadranteMaisGols();
				}
			}
		}
		
		return resultado;
	}
	
	//Metodo que realiza a funcionalidade 10
	public String exibirMatrizGoleiro() {
		String resultado = "\n\nEXIBIR A MATRIZ DE CADA GOLEIRO MOSTRANDO AS DEFESAS E GOLS EM CADA CELULA\n";
		for (Selecao selecao : listaSelecoes) {
			for (Goleiro goleiro : selecao.getListaGoleiros()) {
				resultado += "Goleiro: " + goleiro.getNome() + "\n";
				resultado += gerarMatrizGoleiro(goleiro);
			}
		}
		return resultado;
	}
	
	//Metodos que auxiliam na funcionalidade 10
	public String[][] gerarMatrizGoleiro(Goleiro goleiro) {
		String[][] matriz = new String[9][17];
		int qtdChuteCelula=0;
		for (Celula celula : listaCelulas) {
			Chute chAux = buscarPosicao(celula.getX(), celula.getX(), goleiro);
			if(chAux != null) {
				qtdChuteCelula = qtdChutesNaCelula(celula.getX(), celula.getX(), goleiro);
				if(chAux.getCondicao().equals("Gol")) {
					if(qtdChuteCelula>1) {
						matriz[celula.getX()][celula.getY()] += qtdChuteCelula + "*";
					} else {
						matriz[celula.getX()][celula.getY()] += " *";
					}
				} else if(chAux.getCondicao().equals("Defesa")){
					if(qtdChuteCelula>1) {
						matriz[celula.getX()][celula.getY()] += qtdChuteCelula + "X";
					} else {
						matriz[celula.getX()][celula.getY()] += " X";
					}
				}
			} else {
				matriz[celula.getX()][celula.getY()] += "";
			}
		}
		
		return matriz;
	}
	
	public int qtdChutesNaCelula(int xCelula,int yCelula,Goleiro goleiro) {
		int qtd=0;
		for (Chute chute : goleiro.getTotalChutes()) {
			if(chute.getX()==xCelula && chute.getY()==yCelula) {
				qtd++;
			}
			
		}
		
		return qtd;
	}
	
	public Chute buscarPosicao(int xCelula,int yCelula,Goleiro goleiro) {
		for (Chute chute : goleiro.getTotalChutes()) {
			if(chute.getX()==xCelula && chute.getY()==yCelula) {
				return chute;
			}
		}
		
		return null;
	}
	
}

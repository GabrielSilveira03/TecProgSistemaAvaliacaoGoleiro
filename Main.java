package prova1;

public class Main {

	public static void main(String[] args) {
		//Instanciando a classe que gera o funcionamento do programa
		Funcionamento funcionamento = new Funcionamento();
		
		//Instanciando as celulas
		for (int x = 0; x <= 8; x++) {
			for (int y = 0; y <= 16; y++) {
				Celula c = new Celula(x,y);
				funcionamento.addCelula(c);
			}
		}
		
		//Instanciando os chutes e adicionando aos ArrayLists gerais na classe Funcionamento
		Chute c01 = new Chute(1,2,1,4,7);
		Chute c02 = new Chute(2,6,1,3,6);
		Chute c03 = new Chute(3,9,2,4,15);
		Chute c04 = new Chute(4,5,4,6,11);
		Chute c05 = new Chute(5,3,4,8,13);
		Chute c06 = new Chute(6,3,3,6,4);
		Chute c07 = new Chute(7,4,4,5,8);
		Chute c08 = new Chute(8,7,4,7,14);
		Chute c09 = new Chute(9,8,4,7,14);
		Chute c10 = new Chute(10,4,4,6,12);
		Chute c11 = new Chute(11,2,4,5,15);
		Chute c12 = new Chute(12,7,3,6,4);
		Chute c13 = new Chute(13,3,3,8,2);
		Chute c14 = new Chute(14,9,4,7,10);
		Chute c15 = new Chute(15,10,4,7,12);
		Chute c16 = new Chute(16,5,1,4,2);
		Chute c17 = new Chute(17,3,4,5,13);
		Chute c18 = new Chute(18,10,2,4,16);
		Chute c19 = new Chute(19,10,4,5,16);
		Chute c20 = new Chute(20,10,2,3,14);
		Chute c21 = new Chute(21,9,2,1,8);
		Chute c22 = new Chute(22,4,4,8,16);
		Chute c23 = new Chute(23,8,4,6,14);
		Chute c24 = new Chute(24,7,4,7,11);
		Chute c25 = new Chute(25,6,1,0,3);
		Chute c26 = new Chute(26,5,3,6,7);
		Chute c27 = new Chute(27,3,3,8,4);
		Chute c28 = new Chute(28,4,3,6,7);
		Chute c29 = new Chute(29,10,2,2,13);
		Chute c30 = new Chute(30,7,3,5,3);
		
		funcionamento.addChute(c01);
		funcionamento.addChute(c02);
		funcionamento.addChute(c03);
		funcionamento.addChute(c04);
		funcionamento.addChute(c05);
		funcionamento.addChute(c06);
		funcionamento.addChute(c07);
		funcionamento.addChute(c08);
		funcionamento.addChute(c09);
		funcionamento.addChute(c10);
		funcionamento.addChute(c11);
		funcionamento.addChute(c12);
		funcionamento.addChute(c13);
		funcionamento.addChute(c14);
		funcionamento.addChute(c15);
		funcionamento.addChute(c16);
		funcionamento.addChute(c17);
		funcionamento.addChute(c18);
		funcionamento.addChute(c19);
		funcionamento.addChute(c20);
		funcionamento.addChute(c21);
		funcionamento.addChute(c22);
		funcionamento.addChute(c23);
		funcionamento.addChute(c24);
		funcionamento.addChute(c25);
		funcionamento.addChute(c26);
		funcionamento.addChute(c27);
		funcionamento.addChute(c28);
		funcionamento.addChute(c29);
		funcionamento.addChute(c30);
		
		
		//Instanciando os goleiros 
		Goleiro g01 = new Goleiro("Pratik Skaggs",1,5,7,8,9,6,6);
		Goleiro g02 = new Goleiro("Uehudah Hack",2,9,6,8,8,7,10);
		Goleiro g03 = new Goleiro("Edison Drye",3,5,8,5,8,10,7);
		Goleiro g04 = new Goleiro("Ajani Harding",4,6,6,5,8,7,6);
		Goleiro g05 = new Goleiro("Orazio Hart",5,5,8,7,9,9,10);
		Goleiro g06 = new Goleiro("Tristan Karns",6,9,7,10,7,7,6);
		Goleiro g07 = new Goleiro("Niven Glaser",7,10,9,7,6,5,8);
		Goleiro g08 = new Goleiro("Derwyn Devers",8,10,7,9,5,9,5);
		Goleiro g09 = new Goleiro("Tod Phan",9,10,7,7,5,5,6);
		Goleiro g10 = new Goleiro("Eddie Hulse",10,7,6,5,9,7,5);
		Goleiro g11 = new Goleiro("Welford Yepez",11,5,8,8,7,7,8);
		Goleiro g12 = new Goleiro("Rishley Snyder",12,6,5,6,5,7,6);
		Goleiro g13 = new Goleiro("Milo Mccurdy",13,10,9,8,6,10,9);
		Goleiro g14 = new Goleiro("Carden Justus",14,8,5,8,5,10,7);
		Goleiro g15 = new Goleiro("Carlyon Gorby",15,8,5,8,8,8,6);
		Goleiro g16 = new Goleiro("Mungo Spangler",16,8,10,9,8,9,10);
		Goleiro g17 = new Goleiro("Whitmore Squires",17,9,10,7,9,9,10);
		Goleiro g18 = new Goleiro("Pedrog Mccurdy",18,8,5,10,5,7,7);
		Goleiro g19 = new Goleiro("Ridgley Leo",19,8,8,8,9,9,9);
		Goleiro g20 = new Goleiro("Bolton Tarin",20,9,8,7,6,9,10);
		Goleiro g21 = new Goleiro("Edison Loy",21,7,7,5,10,10,7);
		Goleiro g22 = new Goleiro("Delling Herndon",22,7,5,5,8,9,9);
		Goleiro g23 = new Goleiro("Senichi Iorio",23,7,7,5,8,10,5);
		Goleiro g24 = new Goleiro("Albin Kerner",24,6,7,8,8,10,5);
		Goleiro g25 = new Goleiro("Jivin Justus",25,9,10,8,7,7,5);
		Goleiro g26 = new Goleiro("Clement Fleisher",26,10,9,10,5,7,8);
		
		
		//Instancionando as seleções, adicionando os goleiros a elas e e adicionando aos ArrayLists gerais na classe Funcionamento
		Selecao s1 = new Selecao("Inglaterra");
		Selecao s2 = new Selecao("França");
		Selecao s3 = new Selecao("Estados Unidos");
		Selecao s4 = new Selecao("Austrália");
		Selecao s5 = new Selecao("Canadá");
		
		s1.addGoleiro(g01);
		s1.addGoleiro(g02);
		s1.addGoleiro(g03);
		s1.addGoleiro(g04);
		s1.addGoleiro(g05);
		s2.addGoleiro(g06);
		s2.addGoleiro(g07);
		s2.addGoleiro(g08);
		s2.addGoleiro(g09);
		s2.addGoleiro(g10);
		s3.addGoleiro(g11);
		s3.addGoleiro(g12);
		s3.addGoleiro(g13);
		s3.addGoleiro(g14);
		s3.addGoleiro(g15);
		s4.addGoleiro(g16);
		s4.addGoleiro(g17);
		s4.addGoleiro(g18);
		s4.addGoleiro(g19);
		s4.addGoleiro(g20);
		s5.addGoleiro(g21);
		s5.addGoleiro(g22);
		s5.addGoleiro(g23);
		s5.addGoleiro(g24);
		s5.addGoleiro(g25);
		
		
		funcionamento.addSelecao(s1);
		funcionamento.addSelecao(s2);
		funcionamento.addSelecao(s3);
		funcionamento.addSelecao(s4);
		funcionamento.addSelecao(s5);
		
		//Chamando metodo necessario para o funcionamento do programa
		funcionamento.gerarResultados();
		
		//Funcionalidade 1
		System.out.println(funcionamento.mediaDefesasCadaSelecao());
		
		//Funcionalidade 2
		System.out.println(funcionamento.goleiroTitularCadaSelecao());
		
		//Funcionalidade 3
		System.out.println(funcionamento.mediaGolsCadaSelecao());
		
		//Funcionalidade 4
		System.out.println(funcionamento.chutesNaoGol());
		
		//Funcionalidade 5
		System.out.println(funcionamento.golsAngulo());
		
		//Funcionalidade 6
		System.out.println(funcionamento.melhoresGoleiros());
		
		//Funcionalidade 7
		System.out.println(funcionamento.golsPorForca());
		
		//Funcionalidade 8
		System.out.println(funcionamento.exibirInformacoesGoleiros());
		
		//Funcionalidade 9
		System.out.println(funcionamento.quadranteMaisGols(1));
		
		//Funcionalidade 10
		System.out.println(funcionamento.exibirMatrizGoleiro());
	}

}

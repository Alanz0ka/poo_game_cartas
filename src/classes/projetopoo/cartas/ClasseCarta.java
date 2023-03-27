package classes.projetopoo.cartas;

import java.util.Random;

/*
 * essa é a classe principal onde a carta será gerada 
 * e todas as informações das cartas são guardadas
 * */
public abstract class ClasseCarta {

	/*
	 * propriedade do nome do baralho juntando o nome da carta e o naipe
	 */
	private String nomeDoBaralho;

	// propridades que representa os valores das cartas
	private int valorDaCarta;
	private int valorDoNaipe;

	public String getNomeDoBaralho() {
		return nomeDoBaralho;
	}

	// getters e setters dos atributos da classe
	public void setNomeDoBaralho(String nomeDoBaralho) {
		this.nomeDoBaralho = nomeDoBaralho;
	}

	public int getValorDaCarta() {
		return valorDaCarta;
	}

	public void setValorDaCarta(int valorDaCarta) {
		this.valorDaCarta = valorDaCarta;
	}

	public int getValorDoNaipe() {
		return valorDoNaipe;
	}

	public void setValorDoNaipe(int valorDoNaipe) {
		this.valorDoNaipe = valorDoNaipe;
	}

	// métodos

	/*
	 * o método gerarUmNumeroAleatorio() tem a função de gerar um número aleatório
	 * no alcance definido pelo desenvolvedor do projeto
	 */
	private int gerarUmNumeroAleatorio(int numeroMaximo, int numeroMinimo) {

		Random aleatorio = new Random();
		int valorDoBaralho = (aleatorio.nextInt(numeroMaximo) + numeroMinimo);

		return valorDoBaralho;
	}

	/*
	 * o método receberCarta() usa o método gerarUmNúmeoAleatorio() para gerar um
	 * número de carta
	 */
	private int receberCarta() {

		int carta = this.gerarUmNumeroAleatorio(13, 1);
		return carta;
	}

	/*
	 * o método receberNaipe() usa o método gerarUmNúmeoAleatorio() para gerar um
	 * número de carta
	 */
	private int receberNaipe() {

		int naipe = this.gerarUmNumeroAleatorio((5 - 1), 2);
		return naipe;
	}

	public ClasseCarta devolveCarta() {
		// GERA UMA STRING BASEADA NO NÚMERO DA CARTA E DO NAIPE
		// E JUNTA NO ATRIBUTO nomeBaralho
		// DEVOLVE O OBJETO EM SI PARA TOTAL MANIPULAÇÃO PARA O JOGADOR

		this.valorDaCarta = receberCarta();
		this.valorDoNaipe = receberNaipe();

		String nomeDoNaipe;
		String nomeDaCarta;

		// NAIPE EM STRING
		if (this.valorDoNaipe == 2) {
			nomeDoNaipe = "Paus";
		} else if (this.valorDoNaipe == 3) {
			nomeDoNaipe = "Ouros";
		} else if (this.valorDoNaipe == 4) {
			nomeDoNaipe = "Copas";
		} else {
			nomeDoNaipe = "Espadas";
		}

		// CARTA EM STRING
		if (this.valorDaCarta == 1) {
			nomeDaCarta = "Ás";
		} else if (this.valorDaCarta == 11) {
			nomeDaCarta = "Valete";
		} else if (this.valorDaCarta == 12) {
			nomeDaCarta = "Dama";
		} else if (this.valorDaCarta == 13) {
			nomeDaCarta = "Rei";
		} else {
			nomeDaCarta = this.valorDaCarta + "";
		}

		this.nomeDoBaralho = nomeDaCarta + " de " + nomeDoNaipe;

		return this;
	}

	// métodos abstratos a serem implementados nas classes específicas
	public abstract int getResultadoDaCarta();

	public abstract String getCalculoDoBaralho();

}

package classes.projetopoo.cartas;

import java.util.Scanner;

// essa classe armazena todas as informações do jogador
public class ClasseJogadorCartas {

	// dois atributos estáticos que guarda quantos jogadores foram registrados
	private static int quantidadeJogadoresCadastrados = 0;
	private static int quantidadeMaximaDeJogadores = 5;

	// atributos do jogador
	private String nomeDoJogador;
	private ClasseCarta cartaDoJogador;
	private int pontuacaoDaRodadaDoJogador = 0;
	private int pontuacaoTotalDoJogador = 0;

	// construtor de entrada
	ClasseJogadorCartas() {

		Scanner inputDoJogador = new Scanner(System.in);
		ClasseJogadorCartas.quantidadeJogadoresCadastrados++;

		System.out.print("Digite o nome do jogador " + quantidadeJogadoresCadastrados + ": ");
		this.nomeDoJogador = inputDoJogador.nextLine();

		if (ClasseJogadorCartas.quantidadeJogadoresCadastrados == ClasseJogadorCartas.quantidadeMaximaDeJogadores) {
			inputDoJogador.close();
		}
	}

	// construtor sem leitor de entradas (somente para testes)
	ClasseJogadorCartas(String nome) {
		
		this.nomeDoJogador = nome;
	}

	public static int getQuantidadeJogadoresCadastrados() {
		
		return ClasseJogadorCartas.quantidadeJogadoresCadastrados;
	}

	public String getNomeDoJogador() {
		
		return this.nomeDoJogador;
	}

	public ClasseCarta getCartaDoJogador() {
		
		return cartaDoJogador;
	}

	public int getPontuacaoDaRodadaDoJogador() {
		
		return this.pontuacaoDaRodadaDoJogador;
	}

	public int getPontuacaoTotalDoJogador() {
		
		return this.pontuacaoTotalDoJogador;
	}

	/*
	 * setter para a quantidade máxima de jogadores que poderá ser modificada
	 * dependendo da escolhad o usuário mas não passará de 5
	 */
	public static void setQuantidadeMaximaDeJogadores(int quantidade) {
		ClasseJogadorCartas.quantidadeMaximaDeJogadores = quantidade;
	}

	/*
	 * setter para a pontuação da rodada que define o valor da rodada do jogador e
	 * incrementa no valor total
	 */
	public void setPontuacaoDaRodadaDoJogador(int novaRodada) {
		this.pontuacaoDaRodadaDoJogador = novaRodada;

		incrementaPontuacao(novaRodada);
	}

	/*
	 * esse é o método que incrementa a pontuação total do jogador
	 */
	public void incrementaPontuacao(int pontuacao) {
		this.pontuacaoTotalDoJogador += pontuacao;
	}

	/*
	 * puxará uma carta para o jogador em questão e armazena na variável de carta do
	 * jogador
	 */
	public void puxaCarta(ClasseCarta temaDoBaralho) {
		this.cartaDoJogador = temaDoBaralho.devolveCarta();
	}

}

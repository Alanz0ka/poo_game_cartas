package classes.projetopoo.cartas;

import java.util.Scanner;

/*
 * essa é a classe de estruturação do jogo de cartas
 * onde são armazenados as informações e
 * é feito o controle do jogo
 * */
public class ClasseJogo {

	private Scanner input = new Scanner(System.in);

	// lista de jogadores até 5 (máximo)
	private ClasseJogadorCartas[] jogadores = new ClasseJogadorCartas[5];

	// número de rodadas (padrão: 3)
	private int rodadas = 3;

	// tema do baralho (padrão: Padrão)
	private ClasseCarta temaBaralho = new Padrao();

	// método que pergunta inteiros (para o número de rodadas ou de jogadores)
	private int perguntaInt(String texto) {

		System.out.print(texto);
		int inteiro = this.input.nextInt();
		this.input.nextLine(); // para consumir a sobra do nextInt()

		return inteiro;
	}

	/*
	 * esse método é o que verifica a integridade do inteiro atribuido em
	 * perguntaInt() se o inteiro não estiver errado, então o método apenas
	 * retornará um valor não modificado de volta
	 */
	private int verificaInt(int entrada, int deInt, int paraInt) {

		while (entrada < deInt || entrada > paraInt) {
			entrada = this.perguntaInt("Número inválido. Digite novamente: ");
		}

		return entrada;
	}

	/*
	 * esse método pergunta quantas rodadas o usuário quer jogar se o método não for
	 * chamado, o padrão será de 3 rodadas como definido
	 */
	public void perguntarQuantidadeDeRodadas() {

		int quantidadeDeRodadas;
		quantidadeDeRodadas = this.perguntaInt("Número de rodadas (min: 3, max: 7): ");
		quantidadeDeRodadas = this.verificaInt(quantidadeDeRodadas, 3, 7);

		this.rodadas = quantidadeDeRodadas;
	}

	/*
	 * esse método pergunta quantos jogadores vão jogar e cria os objetos dos
	 * jogadores dinamicamente colocando eles na array this.jogadores
	 */
	public void cadastrarJogadores() {

		int quantosJogadores;
		quantosJogadores = this.perguntaInt("Quanto jogadores vão jogar (min: 2, max: 5): ");
		quantosJogadores = this.verificaInt(quantosJogadores, 2, 5);
		ClasseJogadorCartas.setQuantidadeMaximaDeJogadores(quantosJogadores);

		for (int i = 0; i < quantosJogadores; i++) {
			this.jogadores[i] = new ClasseJogadorCartas();
		}
	}

	/*
	 * esse método calcula pontos bonus dos jogadores e imprime no final da partida
	 */
	private void calcularPontuacaoBonus(ClasseJogadorCartas[] colocacaoArray) {

		System.out.println("Nesta rodada: ");

		for (int index = 0; index < ClasseJogadorCartas.getQuantidadeJogadoresCadastrados(); index++) {
			if (colocacaoArray[index] == null) {
				break;
			}
			int incremento = (ClasseJogadorCartas.getQuantidadeJogadoresCadastrados() - index);
			colocacaoArray[index].incrementaPontuacao(incremento);

			System.out.println(colocacaoArray[index].getNomeDoJogador() + " ganhou " + incremento + " pontos");
		}
	}

	/*
	 * aqui comparamos os pontos de todos os jogadores em cada rodada de forma
	 * dinâmica e imprimimos na tela a única coisa que muda são os métodos pois
	 * comparaPontosNoFinalDaRodada() e calcularVencedor() são iguais
	 */
	private ClasseJogadorCartas[] comparaPontosNoFinalDaRodada() {

		// cria array para colocação, que é do tamanho da array this.jogadores
		ClasseJogadorCartas[] colocacao = new ClasseJogadorCartas[this.jogadores.length];

		// for para colocação
		for (int i = 0; i < ClasseJogadorCartas.getQuantidadeJogadoresCadastrados(); i++) {

			// for para todos os jogadores a cada uma posição da colocação
			for (int j = 0; j < ClasseJogadorCartas.getQuantidadeJogadoresCadastrados(); j++) {
				// para verificar se jogador já está na colocação
				boolean jogadorEmColocacaoI = false;

				for (ClasseJogadorCartas c : colocacao) {
					if (c == null) {
						break;
					}

					if (this.jogadores[j] == c) {
						// se atual jogador j estiver na colocação ele será desconsiderado
						jogadorEmColocacaoI = true;
					}
				}
				// o motivo disso é que se o jogador já estiver no vetor
				// e acabar sendo o com maior pontos
				// ele acabará sobrescrevendo todos os outros jogadores em todas as posições

				if (!jogadorEmColocacaoI) {

					if (colocacao[i] == null) {
						// se atual colocação for vazia, coloca o primeiro jogador que aparecer
						colocacao[i] = this.jogadores[j];
					} else if (this.jogadores[j].getPontuacaoDaRodadaDoJogador() > colocacao[i]
							.getPontuacaoDaRodadaDoJogador()) {
						// se a atual posição da colocação não estiver vazia e
						// o atual jogador tiver maior pontuação que o jogador que já está ocupando esse
						// lugar
						// então o atual passará a ser o dono da posição da colocação
						colocacao[i] = this.jogadores[j];
					}
				} else {
					continue;
				}
			}
		}

		return colocacao;
	}

	private void calcularVencedor() {
		// COMPARA A POSIÇÃO FINAL DOS JOGADORES
		// E IMPRIME NA TELA
		// OBS: NÃO CONSEGUI PENSAR EM UMA FORMA DE NÃO REPETIR O CÓDIGO
		// POIS comparaPontosNoFinalDaRodada() e calculaVencedor() SÃO IGUAIS
		// MAS A ÚNICA COISA QUE MUDA SÃO MÉTODOS
		// E NÃO ACHEI UMA FORMA FÁCIL DE PASSAR MÉTODOS COMO PARÂMETROS

		// cria array para colocação, que é do tamanho da array this.jogadores
		ClasseJogadorCartas[] colocacaoFinal = new ClasseJogadorCartas[this.jogadores.length];

		// loop para colocação
		for (int i = 0; i < ClasseJogadorCartas.getQuantidadeJogadoresCadastrados(); i++) {

			// loop para todos os jogadores a cada uma posição da colocação
			for (int j = 0; j < ClasseJogadorCartas.getQuantidadeJogadoresCadastrados(); j++) {
				// para verificar se jogador já está na colocação
				boolean jogadorEmColocacaoI = false;

				for (ClasseJogadorCartas c : colocacaoFinal) {
					if (c == null) {
						break;
					}

					if (this.jogadores[j] == c) {
						// se atual jogador j estiver na colocação ele será desconsiderado
						jogadorEmColocacaoI = true;
					}
				}
				// o motivo disso é que se o jogador já estiver no vetor
				// e acabar sendo o com maior pontos
				// ele acabará sobrescrevendo todos os outros jogadores em todas as posições

				if (!jogadorEmColocacaoI) {

					if (colocacaoFinal[i] == null) {
						// se atual colocação for vazia, coloca o primeiro jogador que aparecer
						colocacaoFinal[i] = this.jogadores[j];
					} else if (this.jogadores[j].getPontuacaoTotalDoJogador() > colocacaoFinal[i]
							.getPontuacaoTotalDoJogador()) {
						// se a atual posição da colocação não estiver vazia e
						// o atual jogador tiver maior pontuação que o jogador que já está ocupando esse
						// lugar
						// então o atual passará a ser o dono da posição da colocação
						colocacaoFinal[i] = this.jogadores[j];
					}
				} else {
					continue;
				}
			}
		}

		for (int c = 0; c < ClasseJogadorCartas.getQuantidadeJogadoresCadastrados(); c++) {
			System.out.println(colocacaoFinal[c].getNomeDoJogador() + " ficou em " + (c + 1) + "° lugar com "
					+ colocacaoFinal[c].getPontuacaoTotalDoJogador() + " pontos");
		}
	}

	/*
	 * método que pergunta qual o tema de baralho que o usuário quer
	 * se o método não for chamado, o padrão será o tema padrão
	 * */
	public void escolheTipoBaralho() {

		System.out.println("VAMOS COMEÇAR!\n");

		System.out.println("1) Padrão (sem modificações no baralho)");
		System.out.println("2) Naipe Plus (os valores de todos os naipes são 1)");
		System.out.println("3) Parente (cartas (não naipes)\n de números primos são multiplicados por 3)\n");

		int temaBaralho;
		temaBaralho = this.perguntaInt("Escolha o tipo de baralho para a rodada: ");
		temaBaralho = this.verificaInt(temaBaralho, 1, 3);

		if (temaBaralho == 2) {
			this.temaBaralho = new Naipe();
		} else if (temaBaralho == 3) {
			this.temaBaralho = new Parente();
		}
	}

	/*
	 * é o loop do jogo e chama os métodos e objetos importantes para o jogo
	 * funcionar
	 */
	public void jogar() {

		for (int rodada = 0; rodada < this.rodadas; rodada++) {
			for (ClasseJogadorCartas j : this.jogadores) {
				if (j == null) {
					break;
				}

				int pontuacaoRodadaJogador;

				// jogador puxa a carta com o tema do jogo
				j.puxaCarta(this.temaBaralho);
				// baseado na carta que o jogador puxou, os pontos da rodada são calculados e
				// inseridos
				pontuacaoRodadaJogador = j.getCartaDoJogador().getResultadoDaCarta();
				j.setPontuacaoDaRodadaDoJogador(pontuacaoRodadaJogador);

				System.out.println(j.getNomeDoJogador() + ": " + j.getCartaDoJogador().getNomeDoBaralho());
				System.out.println("Pontuação final da carta: " + j.getCartaDoJogador().getCalculoDoBaralho());
				System.out.println();
			}
			ClasseJogadorCartas[] colocacaoNaPartida = this.comparaPontosNoFinalDaRodada();
			this.calcularPontuacaoBonus(colocacaoNaPartida);

			System.out.println();
		}

		this.calcularVencedor();

		this.input.close();
	}
}

package classes.projetopoo.cartas;

// classe onde executamos todos os códigos do projeto
public class Executavel {

	/*
	 * esse método serve para executar o nosso código java instancia a classe do
	 * Jogo e chama os jogos
	 */
	public static void main(String[] args) {
		ClasseJogo novoJogo = new ClasseJogo();

		novoJogo.escolheTipoBaralho();
		System.out.println();
		novoJogo.perguntarQuantidadeDeRodadas();
		System.out.println();
		novoJogo.cadastrarJogadores();
		System.out.println();

		novoJogo.jogar();
	}
}
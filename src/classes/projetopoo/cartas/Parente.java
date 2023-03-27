package classes.projetopoo.cartas;

/*
 * tema: parente
 * todas as cartas com o respectivos valores primos 
 * serão multiplicadas por três
 * */
public class Parente extends ClasseCarta {

	private int multiplicador;

	/*
	 * o método a seguir verifica se um número é primo e 
	 * calcula o valor baseado em um multiplicador
	 * todos os números são primos até que o for prove ao contrário
	 * caso o número seja primo, o this.multiplicador passa a ser 3
	 * caso o contrário passa a ser apenas 1
	 * */
	@Override
	public int getResultadoDaCarta() {

		boolean primo = true;

		for (int i = 2; i <= this.getValorDaCarta() / 2; i++) {
			if (this.getValorDaCarta() % i == 0) {
				primo = false;
				break;
			}
		}

		if (!primo || (this.getValorDaCarta() == 1)) {
			this.multiplicador = 1;
		} else {
			this.multiplicador = 3;
		}

		return ((this.getValorDaCarta() * this.multiplicador) * this.getValorDoNaipe());
	}

	/*
	 * neste método, se o multiplicador for 3 (que indica que é um primo), a mensagem
	 * terá um multiplicador a mais
	 * caso o contrário, a mensagem será comum 
	 * */
	@Override
	public String getCalculoDoBaralho() {

		if (this.multiplicador == 3) {
			return (this.getValorDaCarta() + " * " + this.multiplicador + " * " + this.getValorDoNaipe() + " = "
					+ this.getResultadoDaCarta());
		} else {
			return (this.getValorDaCarta() + " * " + this.getValorDoNaipe() + " = " + this.getResultadoDaCarta());
		}
	}
}

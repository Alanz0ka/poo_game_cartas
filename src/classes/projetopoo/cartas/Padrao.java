package classes.projetopoo.cartas;

/*
 * tema: padrão
 * o valor permanece sem ser alterado
 * */
public class Padrao extends ClasseCarta {

	/*
	 * aqui esse método calcula o valor total da carta sem alteração de valores
	 */
	@Override
	public int getResultadoDaCarta() {

		return (this.getValorDaCarta() * this.getValorDoNaipe());
	}

	/*
	 * aqui esse método devolverá uma mensagem comum do cálculo do baralho
	 */
	@Override
	public String getCalculoDoBaralho() {

		return (this.getValorDaCarta() + " * " + this.getValorDoNaipe() + " = " + this.getResultadoDaCarta());
	}

}
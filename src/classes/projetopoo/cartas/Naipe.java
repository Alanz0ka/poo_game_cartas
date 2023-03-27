package classes.projetopoo.cartas;

/*
 * tema: naipe plus
 * todo os naipes passam a valer um nesta classe
 * */
public class Naipe extends ClasseCarta {

	/*
	 * aqui esse método devolve o calcula da carta, porém, o naipe vale um
	 */
	@Override
	public int getResultadoDaCarta() {

		return (this.getValorDaCarta() * 1);
	}

	/*
	 * aqui esse método devolverá uma mensagem onde o naipe passa valer 1
	 */
	@Override
	public String getCalculoDoBaralho() {

		return (this.getValorDaCarta() + " * 1 = " + this.getResultadoDaCarta());
	}
}
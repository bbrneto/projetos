package investimento;

public class TesteDeInvestimentos {

	public static void main(String[] args) {
		Conta conta = new Conta();
		conta.deposita(1000);

		Investimento conservador = new Conservador();

		Investimento moderado = new Moderado();

		Investimento arrojado = new Arrojado();

		RealizadorDeInvestimentos realizador = new RealizadorDeInvestimentos();
		realizador.realiza(conta, conservador);
		realizador.realiza(conta, moderado);
		realizador.realiza(conta, arrojado);
	}

}

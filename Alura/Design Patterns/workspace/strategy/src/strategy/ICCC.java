package strategy;

// Tipo de estratégia
public class ICCC implements Imposto {

	@Override
	public double calcula(Orcamento orcamento) {
		double valor = orcamento.getValor();

		if (valor < 1000) {
			return valor * 0.05;
		} else if (valor <= 3000) {
			return valor * 0.07;
		}

		return valor * 0.08 + 30;
	}

}

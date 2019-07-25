package strategy;

// Não sofrerá alterações com o surgimento de novos impostos
public class CalculadorDeImpostos {

	public void realizaCalculo(Imposto imposto, Orcamento orcamento) {
		double valor = imposto.calcula(orcamento);

		System.out.println(valor);
	}

}

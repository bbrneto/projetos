package strategy;

public class TesteDeImpostos {
	
	public static void main(String[] args) {
		Imposto icms = new ICMS();
		
		Imposto iss = new ISS();
		
		Imposto iccc = new ICCC();
		
		Orcamento orcamento = new Orcamento(3001);
		
		CalculadorDeImpostos calculador = new CalculadorDeImpostos();
		calculador.realizaCalculo(icms, orcamento);
		calculador.realizaCalculo(iss, orcamento);
		calculador.realizaCalculo(iccc, orcamento);
	}

}

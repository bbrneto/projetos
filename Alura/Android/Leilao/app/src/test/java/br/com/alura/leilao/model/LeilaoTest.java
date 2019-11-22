package br.com.alura.leilao.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class LeilaoTest {

//    Atributos fixos para todos os testes, ou seja, não podem ser modificados

    private final Leilao CONSOLE = new Leilao("Console");

    private final Usuario ALEX = new Usuario("Alex");

//    Template: [deve] [resultado esperado] [cenário]

//        Cenário
//        Ação
//        Validação

//    Cada método é executado por uma nova instância da classe de teste

//    Atributos de instância devem aparecer na maioria dos testes

    @Test
    public void deveDevolverDescricaoQuandoRecebeDescricao() {
        String descricaoDevolvida = CONSOLE.getDescricao();

        assertEquals("Console", descricaoDevolvida);
    }

    @Test
    public void deveDevolverMaiorLanceQuandoRecebeApenasUmLance() {
        CONSOLE.propoe(new Lance(ALEX, 200.0));

        double maiorLanceDevolvido = CONSOLE.getMaiorLance();

        assertEquals(200.0, maiorLanceDevolvido, 0.0001);
    }

    @Test
    public void deveDevolverMaiorLanceQuandoRecebeLancesEmOrdemCrescente() {
        CONSOLE.propoe(new Lance(ALEX, 100.0));
        CONSOLE.propoe(new Lance(new Usuario("Fran"), 200.0));

        double maiorLanceDevolvido = CONSOLE.getMaiorLance();

        assertEquals(200.0, maiorLanceDevolvido, 0.0001);
    }

    @Test
    public void deveDevolverMaiorLanceQuandoRecebeLancesEmOrdemDecrescente() {
        CONSOLE.propoe(new Lance(ALEX, 10000.0));
        CONSOLE.propoe(new Lance(new Usuario("Fran"), 9000.0));

        double maiorLanceDevolvido = CONSOLE.getMaiorLance();

        assertEquals(10000.0, maiorLanceDevolvido, 0.0001);
    }

    @Test
    public void deveDevolverMenorLanceQuandoRecebeApenasUmLance() {
        CONSOLE.propoe(new Lance(ALEX, 200.0));

        double menorLanceDevolvido = CONSOLE.getMenorLance();

        assertEquals(200.0, menorLanceDevolvido, 0.0001);
    }

    @Test
    public void deveDevolverMenorLanceQuandoRecebeLancesEmOrdemCrescente() {
        CONSOLE.propoe(new Lance(ALEX, 100.0));
        CONSOLE.propoe(new Lance(new Usuario("Fran"), 200.0));

        double menorLanceDevolvido = CONSOLE.getMenorLance();

        assertEquals(100.0, menorLanceDevolvido, 0.0001);
    }

    @Test
    public void deveDevolverMenorLanceQuandoRecebeLancesEmOrdemDecrescente() {
        CONSOLE.propoe(new Lance(ALEX, 10000.0));
        CONSOLE.propoe(new Lance(new Usuario("Fran"), 9000.0));

        double menorLanceDevolvido = CONSOLE.getMenorLance();

        assertEquals(9000.0, menorLanceDevolvido, 0.0001);
    }

}
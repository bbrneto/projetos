package br.com.alura.leilao.model;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class LeilaoTest {

    private static final double DELTA = 0.0001;

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

        assertEquals(200.0, maiorLanceDevolvido, DELTA);
    }

    @Test
    public void deveDevolverMaiorLanceQuandoRecebeLancesEmOrdemCrescente() {
        CONSOLE.propoe(new Lance(ALEX, 100.0));
        CONSOLE.propoe(new Lance(new Usuario("Fran"), 200.0));

        double maiorLanceDevolvido = CONSOLE.getMaiorLance();

        assertEquals(200.0, maiorLanceDevolvido, DELTA);
    }

    @Test
    public void deveDevolverMaiorLanceQuandoRecebeLancesEmOrdemDecrescente() {
        CONSOLE.propoe(new Lance(ALEX, 10000.0));
        CONSOLE.propoe(new Lance(new Usuario("Fran"), 9000.0));

        double maiorLanceDevolvido = CONSOLE.getMaiorLance();

        assertEquals(10000.0, maiorLanceDevolvido, DELTA);
    }

    @Test
    public void deveDevolverMenorLanceQuandoRecebeApenasUmLance() {
        CONSOLE.propoe(new Lance(ALEX, 200.0));

        double menorLanceDevolvido = CONSOLE.getMenorLance();

        assertEquals(200.0, menorLanceDevolvido, DELTA);
    }

    @Test
    public void deveDevolverMenorLanceQuandoRecebeLancesEmOrdemCrescente() {
        CONSOLE.propoe(new Lance(ALEX, 100.0));
        CONSOLE.propoe(new Lance(new Usuario("Fran"), 200.0));

        double menorLanceDevolvido = CONSOLE.getMenorLance();

        assertEquals(100.0, menorLanceDevolvido, DELTA);
    }

    @Test
    public void deveDevolverMenorLanceQuandoRecebeLancesEmOrdemDecrescente() {
        CONSOLE.propoe(new Lance(ALEX, 10000.0));
        CONSOLE.propoe(new Lance(new Usuario("Fran"), 9000.0));

        double menorLanceDevolvido = CONSOLE.getMenorLance();

        assertEquals(9000.0, menorLanceDevolvido, DELTA);
    }

    @Test
    public void deveDevolverTresMaioresLancesQuandoNaoRecebeLances() {
        List<Lance> tresMaioresLancesDevolvidos = CONSOLE.tresMaioresLances();

        assertEquals(0, tresMaioresLancesDevolvidos.size());
    }

    @Test
    public void deveDevolverTresMaioresLancesQuandoRecebeApenasUmLance() {
        CONSOLE.propoe(new Lance(ALEX, 200.0));

        List<Lance> tresMaioresLancesDevolvidos = CONSOLE.tresMaioresLances();

        assertEquals(1, tresMaioresLancesDevolvidos.size());

        assertEquals(200.0, tresMaioresLancesDevolvidos.get(0).getValor(), DELTA);
    }

    @Test
    public void deveDevolverTresMaioresLancesQuandoRecebeApenasDoisLances() {
        CONSOLE.propoe(new Lance(ALEX, 200.0));
        CONSOLE.propoe(new Lance(new Usuario("Fran"), 300.0));

        List<Lance> tresMaioresLancesDevolvidos = CONSOLE.tresMaioresLances();

        assertEquals(2, tresMaioresLancesDevolvidos.size());

        assertEquals(300.0, tresMaioresLancesDevolvidos.get(0).getValor(), DELTA);
        assertEquals(200.0, tresMaioresLancesDevolvidos.get(1).getValor(), DELTA);
    }

    @Test
    public void deveDevolverTresMaioresLancesQuandoRecebeExatosTresLances() {
        CONSOLE.propoe(new Lance(ALEX, 200.0));
        CONSOLE.propoe(new Lance(new Usuario("Fran"), 300.0));
        CONSOLE.propoe(new Lance(ALEX, 400.0));

        List<Lance> tresMaioresLancesDevolvidos = CONSOLE.tresMaioresLances();

        assertEquals(3, tresMaioresLancesDevolvidos.size());

        assertEquals(400.0, tresMaioresLancesDevolvidos.get(0).getValor(), DELTA);
        assertEquals(300.0, tresMaioresLancesDevolvidos.get(1).getValor(), DELTA);
        assertEquals(200.0, tresMaioresLancesDevolvidos.get(2).getValor(), DELTA);
    }

    @Test
    public void deveDevolverTresMaioresLancesQuandoRecebeMaisDeTresLances() {
        final Usuario FRAN = new Usuario("Fran");

        CONSOLE.propoe(new Lance(ALEX, 200.0));
        CONSOLE.propoe(new Lance(FRAN, 300.0));
        CONSOLE.propoe(new Lance(ALEX, 400.0));
        CONSOLE.propoe(new Lance(FRAN, 500.0));

        List<Lance> tresMaioresLancesDevolvidos = CONSOLE.tresMaioresLances();

        assertEquals(3, tresMaioresLancesDevolvidos.size());

        assertEquals(500.0, tresMaioresLancesDevolvidos.get(0).getValor(), DELTA);
        assertEquals(400.0, tresMaioresLancesDevolvidos.get(1).getValor(), DELTA);
        assertEquals(300.0, tresMaioresLancesDevolvidos.get(2).getValor(), DELTA);
    }

}
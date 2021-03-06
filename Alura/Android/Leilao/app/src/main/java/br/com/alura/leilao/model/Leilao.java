package br.com.alura.leilao.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Leilao implements Serializable {

    private final String descricao;
    private final List<Lance> lances;

    private double maiorLance = Double.NEGATIVE_INFINITY;
    private double menorLance = Double.POSITIVE_INFINITY;

    public Leilao(String descricao) {
        this.descricao = descricao;
        this.lances = new ArrayList<>();
    }

    public void propoe(Lance lance) {
        this.lances.add(lance);

        Collections.sort(this.lances);

        double valorLance = lance.getValor();

        calculaMaiorLance(valorLance);

        calculaMenorLance(valorLance);
    }

    private void calculaMaiorLance(double valorLance) {
        if (valorLance > maiorLance) {
            maiorLance = valorLance;
        }
    }

    private void calculaMenorLance(double valorLance) {
        if (valorLance < menorLance) {
            menorLance = valorLance;
        }
    }

    public List<Lance> tresMaioresLances() {
        int quantidadeMaximaLances = this.lances.size();

        if (quantidadeMaximaLances > 3) {
            quantidadeMaximaLances = 3;
        }

        return this.lances.subList(0, quantidadeMaximaLances);
    }

    public String getDescricao() {
        return descricao;
    }

    public double getMaiorLance() {
        return maiorLance;
    }

    public double getMenorLance() {
        return menorLance;
    }

}

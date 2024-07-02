package Contas;

import java.time.LocalDateTime;

public class Extrato {
    private final String movimentacao;
    private final double valor;
    private final LocalDateTime dataDeMovimentacao;

    public Extrato(String movimentacao, double valor) {
        this.movimentacao = movimentacao;
        this.valor = valor;
        this.dataDeMovimentacao = LocalDateTime.now();
    }

    public String getMovimentacao() {
        return movimentacao;
    }

    public double getValor() {
        return valor;
    }

    public LocalDateTime getDataDeMovimentacao() {
        return dataDeMovimentacao;
    }

    @Override
    public String toString() {
        return "{ " + movimentacao + ", valor: R$" + valor + ", data: " + dataDeMovimentacao.toString() + " }";
    }
}

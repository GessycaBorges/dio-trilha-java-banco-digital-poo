package Contas;

import java.util.ArrayList;
import java.util.List;

public class Conta implements ContaInterface {
    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    private String tipoConta;
    private final int agencia;
    private final int numero;
    private double saldo;
    private final Cliente cliente;
    private final List<Extrato> extratoList;

    public Conta(Cliente cliente) {
        this.agencia = AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
        this.extratoList = new ArrayList<>();
    }

    @Override
    public void sacar(double valor) {
        if (this.saldo >= valor) {
            this.saldo -= valor;
            this.extratoList.add(new Extrato("Saída", valor));
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }

    @Override
    public void depositar(double valor) {
        this.saldo += valor;
        this.extratoList.add(new Extrato("Entrada", valor));
    }

    @Override
    public void transferir(double valor, ContaInterface destino) {
        if (this.saldo >= valor) {
            this.sacar(valor);
            destino.depositar(valor);
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }

    @Override
    public void imprimirExtrato() {
    }

    protected void imprimirInformacoes() {
        System.out.printf("Titular: %s%n", this.cliente.getNome());
        System.out.printf("Cpf Titular: %s%n", this.cliente.getCpf());
        System.out.printf("Agencia: %d%n", this.agencia);
        System.out.printf("Numero: %d%n", this.numero);
        System.out.printf("Saldo: R$%.2f%n", this.saldo);
        extratoList.stream().toList().forEach(System.out::println);
    }

    public String getTipoConta() {
        return tipoConta;
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public double getSaldo() {
        return saldo;
    }
}

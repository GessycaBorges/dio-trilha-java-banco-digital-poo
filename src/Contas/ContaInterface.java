package Contas;

public interface ContaInterface {
    void sacar(double valor);
    void depositar(double valor);
    void transferir(double valor, ContaInterface destino);
    void imprimirExtrato();
}

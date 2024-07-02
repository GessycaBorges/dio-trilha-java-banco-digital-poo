package Contas;

public class ContaPoupanca extends Conta{

    public ContaPoupanca (Cliente cliente) {
        super(cliente);
    }

    @Override
    public String getTipoConta() {
        return "Conta Poupança";
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("=== Extrato Conta Poupança ===");
        super.imprimirInformacoes();
    }
}

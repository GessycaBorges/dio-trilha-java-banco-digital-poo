import Contas.Cliente;
import Contas.Conta;
import Contas.ContaCorrente;
import Contas.ContaPoupanca;

public class Main {
    public static void main(String[] args) {
        Banco bancoDio = new Banco("Banco DIO");

        Cliente gessyca = new Cliente("Gessyca Borges", "11111111111");
        Cliente paulo = new Cliente("Paulo Silva", "22222222222");

        Conta correnteGessyca = new ContaCorrente(gessyca);
        Conta poupancaGessyca = new ContaPoupanca(gessyca);
        Conta correntePaulo = new ContaCorrente(paulo);

        bancoDio.addConta(correnteGessyca);
        bancoDio.addConta(poupancaGessyca);
        bancoDio.addConta(correntePaulo);

        System.out.println("---------- Lista de contas ----------");
        System.out.println(bancoDio.listarContas());

        correnteGessyca.depositar(1000);
        correnteGessyca.sacar(200);
        correnteGessyca.transferir(300, poupancaGessyca);
        correnteGessyca.transferir(100, correntePaulo);

        correntePaulo.depositar(550);
        correntePaulo.sacar(200);
        correntePaulo.transferir(300, poupancaGessyca);

        System.out.println("\n---------- Gessyca ----------");
        correnteGessyca.imprimirExtrato();
        System.out.println("\n---------- Gessyca ----------");
        poupancaGessyca.imprimirExtrato();
        System.out.println("\n---------- Paulo ----------");
        correntePaulo.imprimirExtrato();
    }
}
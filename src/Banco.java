import Contas.Conta;

import java.util.ArrayList;
import java.util.List;

public class Banco {
    private final String nome;
    private final List<Conta> contas;

    public Banco(String nome) {
        this.nome = nome;
        this.contas = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public List<Conta> getContas() {
        return contas;
    }

    public void addConta(Conta conta) {
        this.contas.add(conta);
    }

    public List<String> listarContas() {
        return this.contas.stream()
                .map(conta -> String.format("Tipo: %s, Titular: %s, Agência %d, Número: %d \n",
                        conta.getTipoConta(),
                        conta.getCliente().getNome(),
                        conta.getAgencia(),
                        conta.getNumero()))
                .toList();
    }
}
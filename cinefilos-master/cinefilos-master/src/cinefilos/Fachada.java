package cinefilos;

import cinefilos.bancoDeDados.*;

import java.util.NoSuchElementException;

public class Fachada {
    public Cliente cadastroCliente(String nome, String email, String senha) {
        return new Cliente(nome, email, senha);
    }
    public BancoDeClientes criarBancoClientes() {
        return new BancoDeClientes();
    }

    public BancoDeGerentes criarBancoGerente() {
        return new BancoDeGerentes();
    }

    public Programacao criarProgramacao() {
        return new Programacao();
    }

    public Lanchonete criarLanchonete() {
        return new Lanchonete();
    }

    public BancoDeFuncionarios criarBancoFuncionario() {

        return new BancoDeFuncionarios();
    }

    public Cliente loginCliente(BancoDeClientes clientes, String email, String senha) throws NoSuchElementException {
        return clientes.buscarCliente(email, senha);
    }

    public Gerente loginGerente(BancoDeGerentes gerentes, String senha) {
        return gerentes.buscarGerente(senha);
    }

    public void fecharPedido(Cliente cliente) {
        double valor = cliente.pagarCompra();

        cliente.atualizarCartao();
        cliente.getCartao().aplicarDesconto(valor);
        cliente.getCartao().verificarPontos(valor);
    }

    public String gerarRelatorio(Cliente cliente) {
        return "Cliente: " + cliente + "\n" + "Compras: " + cliente.getCarrinhoDoRelatorio() + "\n" + "Lucro:" + cliente.getValorASerPago();
    }

    public Cliente buscarClientePeloNome(String nome) {
        for (Cliente cliente : criarBancoClientes().getClientes()) {
            if (cliente.getNome().equals(nome)) {
                return cliente;
            }
        }
        return null;
    }
}

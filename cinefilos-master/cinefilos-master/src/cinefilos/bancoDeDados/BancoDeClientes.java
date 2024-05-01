package cinefilos.bancoDeDados;

import cinefilos.Cliente;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class BancoDeClientes implements Serializable {
    private List<Cliente> clientes;

    public BancoDeClientes() {
        this.clientes = new ArrayList<>();
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void adicionarCliente(Cliente cliente) {
        if (cliente == null) {
            return;
        }
        clientes.add(cliente);
        salvarClienteEmArquivo(cliente);
    }

    public boolean removerCliente(Cliente cliente) {
        return clientes.remove(cliente);
    }

    public Cliente buscarCliente(String email, String senha) throws NoSuchElementException {
        for (Cliente cliente : clientes) {
            if (cliente.getEmail().equals(email) & cliente.getSenha().equals(senha)) {
                return cliente;
            } else {
                throw new NoSuchElementException("Cliente não encontrado.");
            }
        }
        return null;
    }

    private void salvarClienteEmArquivo(Cliente cliente) {
        String nomeArquivo = "clientes.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo, true))) {
            writer.write(cliente.toString());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}


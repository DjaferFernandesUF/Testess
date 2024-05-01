package cinefilos.bancoDeDados;

import cinefilos.Funcionario;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class BancoDeFuncionarios implements Serializable {
    private List<Funcionario> funcionarios;
    private static final String ARQUIVO_FUNCIONARIOS = "funcionarios.txt";

    public BancoDeFuncionarios() {
        this.funcionarios = new ArrayList<>();
    }

    public void adicionarFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
    }

    public void deletarFuncionario(int posicao) {
        funcionarios.remove(posicao);
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public boolean funcionarioExiste(Funcionario novoFuncionario) {
        try {
            List<String> linhas = Files.readAllLines(Paths.get(ARQUIVO_FUNCIONARIOS));
            for (String linha : linhas) {
                if (linha.contains(novoFuncionario.getEmail())) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    private void salvarFuncionarioNoArquivo(Funcionario funcionario) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARQUIVO_FUNCIONARIOS, true))) {
            writer.write(funcionario.toString());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<String> recuperaDadosDeAlunos() throws IOException{
        List<String> dadosAlunos = recuperaTextoDeArquivo();
        return dadosAlunos;
    }
    public List<String> recuperaTextoDeArquivo()
            throws IOException {
        BufferedReader leitor = null;
        List<String> textoLido = new ArrayList<>();
        try {
            leitor = new BufferedReader(new FileReader("funcionarios.txt"));
            String texto = null;
            do {
                texto = leitor.readLine();
                if (texto!=null){
                    textoLido.add(texto);
                }
            } while (texto!=null);
        } finally {
            if (leitor!=null){
                leitor.close();
            }
        }
        return textoLido;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BancoDeFuncionarios that = (BancoDeFuncionarios) o;
        return Objects.equals(funcionarios, that.funcionarios);
    }

    @Override
    public int hashCode() {
        return Objects.hash(funcionarios);
    }
}

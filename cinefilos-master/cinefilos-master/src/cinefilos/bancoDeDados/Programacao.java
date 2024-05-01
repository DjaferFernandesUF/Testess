package cinefilos.bancoDeDados;


import cinefilos.Cliente;
import cinefilos.Exibicao;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;

public class Programacao implements Serializable {
    private List<Exibicao> programacao;
    private static final String NOME_ARQUIVO = "Exibicoes.txt";

    public Programacao() {
        this.programacao = new ArrayList<>();
    }

    public void adicionarExibicao(Exibicao exibicao) {
        programacao.add(exibicao);
        salvarExibicaoEmArquivo(exibicao);
    }

    public void removerExibicao(int posicao) {
        programacao.remove(posicao);
    }

    public List<Exibicao> getProgramacao() {
        return programacao;
    }

    public Exibicao buscarExibicao(String titulo, int numero) throws Exception {

        for (Exibicao exibicao : getProgramacao()) {
            if (exibicao.getFilme().getTitulo().equals(titulo) && exibicao.getSala().getNumeroDaSala() == numero) {
                return exibicao;
            }
        }
        throw new Exception("A exibição não está na programação");
    }

    private boolean exibicaoExiste(Exibicao exibicao) {
        return programacao.stream().anyMatch(e -> e.equals(exibicao));
    }

    private boolean exibicaoExisteNoArquivo(Exibicao exibicao) {
        try {
            List<String> linhas = Files.readAllLines(Paths.get(NOME_ARQUIVO));
            for (String linha : linhas) {
                if (linha.contains(exibicao.toString())) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    private void salvarExibicaoEmArquivo(Exibicao exibicao) {
        String nomeArquivo = "programacaoCinema.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Exibicoes.txt", true))) {
            writer.write(exibicao.toString());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Programacao that = (Programacao) o;
        return Objects.equals(programacao, that.programacao);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(programacao);
    }
}


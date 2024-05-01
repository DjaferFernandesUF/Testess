package cinefilos.bancoDeDados;

import cinefilos.Gerente;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

public class BancoDeGerentes implements Serializable {
    private List<Gerente> gerentes;
    private static final String ARQUIVO_SENHAS = "senhasGerentes.txt";


    public BancoDeGerentes() {
        this.gerentes = new ArrayList<>();
    }


    public List<Gerente> getGerentes() {
        return gerentes;
    }

    public void adicionarGerente(Gerente gerente) {
        if (gerente == null) {
            return;
        }
        gerentes.add(gerente);
        if (gerenteExiste(gerente) || !senhaExisteNoArquivo(gerente.getSenha())) {
            salvarSenhaEmArquivo(gerente);
        }
    }

    public boolean removerGerente(Gerente gerente) {
        return gerentes.remove(gerente);
    }

    public Gerente buscarGerente(String senha) throws NoSuchElementException {
        for (Gerente gerente : gerentes) {
            if (gerente.getSenha().equals(senha)) {
                return gerente;
            }
        }
        return null;
    }


    private boolean gerenteExiste(Gerente novoGerente) {
        return gerentes.stream().anyMatch(gerente -> gerente.getSenha().equals(novoGerente.getSenha()));
    }

    private boolean senhaExisteNoArquivo(String senha) {
        try {
            List<String> senhas = Files.readAllLines(Path.of(ARQUIVO_SENHAS));
            return senhas.contains(senha);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    private void salvarSenhaEmArquivo(Gerente gerente) {
        String nomeArquivo = "senhasGerentes.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo, true))) {
            writer.write(gerente.toString());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<String> recuperaDadosDeGerentes() throws IOException{
        List<String> dadosAlunos = recuperaTextoDeArquivo();
        return dadosAlunos;
    }

    public List<String> recuperaTextoDeArquivo()
            throws IOException {
        BufferedReader leitor = null;
        List<String> textoLido = new ArrayList<>();
        try {
            leitor = new BufferedReader(new FileReader("senhasGerentes.txt"));
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

    private void removerSenhaGerente(Gerente gerente) {
        try {
            Path path = Paths.get(ARQUIVO_SENHAS);
            List<String> senhas = Files.readAllLines(path);
            senhas.remove(gerente.getSenha());
            Files.write(path, senhas);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BancoDeGerentes that = (BancoDeGerentes) o;
        return Objects.equals(gerentes, that.gerentes);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(gerentes);
    }

    @Override
    public String toString() {
        return "BancoDeGerentes{" +
                "gerentes=" + gerentes +
                '}';
    }
}

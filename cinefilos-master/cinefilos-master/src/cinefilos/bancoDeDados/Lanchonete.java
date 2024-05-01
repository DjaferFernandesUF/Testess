package cinefilos.bancoDeDados;

import cinefilos.Item;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Lanchonete implements Serializable {
    private List<Item> lanchonete;
    private static final String NOME_ARQUIVO = "itensLanchonete.txt";

    public Lanchonete() {
        this.lanchonete = new ArrayList<>();
    }

    public List<Item> getLanchonete() {
        return lanchonete;
    }
    public void adicionaItem(Item item) {
        salvarItemEmArquivo(item);
        lanchonete.add(item);
    }

    public void removerItem(int posicao) {
        lanchonete.remove(posicao);
    }

    public Item buscaItemNaLanchonete(String nome) throws Exception {
        for (Item item : lanchonete) {
            if (item.getNome().equals(nome)) {
                return item;
            }
        }
        throw new Exception("Item " + nome + " não encontrado na lanchonete");
    }

    private boolean itemExiste(Item item) {
        return lanchonete.stream().anyMatch(i -> i.equals(item));
    }

    private void salvarItemEmArquivo(Item item) {
        String nomeArquivo = "itensLanchonete.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo, true))) {
            writer.write(item.toString());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public List<String> recuperaDadosDeGerente() throws IOException{
        List<String> dadosGerente = recuperaTextoDeArquivo();
        return dadosGerente;
    }

    public List<String> recuperaTextoDeArquivo()
            throws IOException {
        BufferedReader leitor = null;
        List<String> textoLido = new ArrayList<>();
        try {
            leitor = new BufferedReader(new FileReader("itensLanchonete.txt"));
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
        Lanchonete that = (Lanchonete) o;
        return Objects.equals(lanchonete, that.lanchonete);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(lanchonete);
    }

    @Override
    public String toString() {
        return "Lanchonete{" +
                "lanchonete=" + lanchonete +
                '}';
    }
}


package cinefilos;

import java.io.Serializable;
import java.util.Objects;

public class Item implements ItemCarrinhoIF, Serializable {
    private String nome;
    private double preco;
    private int quantidade;
    private String data;
    private String tipo;

    public Item(String nome, double preco, int quantidade) {
        try {
            this.nome = nome;
            this.preco = preco;

            if (quantidade <= 0) {
                throw new IndexOutOfBoundsException("Quantidade não pode ser menor ou igual a zero");
            }
            this.quantidade = quantidade;
            this.data = "";
            this.tipo = "Item";
        }catch (IllegalArgumentException e) {
            System.err.println("Erro ao criar item: " + e.getMessage());
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    @Override
    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getData() {
        return data;
    }
    @Override
    public void setData(String data) {
        this.data = data;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        if (quantidade <= 0) {
            return;
        }
        this.quantidade = quantidade;
    }

    @Override
    public String vendeItem(int quantidade) {
        if (this.quantidade < quantidade) {
            this.quantidade -= quantidade;
            return "Item vendido com sucesso.";
        } else {
            return "Não existe mais esse item para vender.";
        }

    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Double.compare(preco, item.preco) == 0 && Objects.equals(nome, item.nome) && Objects.equals(data, item.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, preco, data);
    }

    @Override
    public String toString() {
        return "Item{" +
                "nome='" + nome + '\'' +
                ", preco=" + preco +
                ", data='" + data + '\'' +
                '}';
    }
}



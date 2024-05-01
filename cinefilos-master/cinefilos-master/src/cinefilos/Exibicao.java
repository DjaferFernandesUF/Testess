package cinefilos;

import java.io.Serializable;
import java.util.Objects;

public class Exibicao implements ItemCarrinhoIF, Serializable {
    private Sala sala;
    private Filme filme;
    private int quantidadeIngressosDisponivel;
    private double preco;
    private String data;
    private String tipo;

    public Exibicao(Sala sala, Filme filme) {
        try {
        this.sala = sala;
        this.filme = filme;
        this.quantidadeIngressosDisponivel = sala.getQuantidadePoltronas();
        this.preco = sala.getPreco();
        this.data = "";
        this.tipo = "Exibicao";
        }catch (IllegalArgumentException e) {
            System.err.println("Erro ao criar exibição: " + e.getMessage());
        }
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public int getQuantidade() {
        return quantidadeIngressosDisponivel;
    }

    public void setQuantidade(int quantidade) {
        if (quantidade <= 0) {
            return;
        }
        this.quantidadeIngressosDisponivel = quantidadeIngressosDisponivel;
    }

    @Override
    public String vendeItem(int quantidade) {

        if (this.quantidadeIngressosDisponivel < quantidade) {
            this.quantidadeIngressosDisponivel -= quantidade;
            return "Item vendido com sucesso.";
        } else {
            return "Não existe mais esse item para vender.";
        }
    }

    @Override
    public double getPreco() {
        return preco;
    }
    public void setPreco(double novoPreco) {
        this.preco = novoPreco;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
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
        Exibicao exibicao = (Exibicao) o;
        return quantidadeIngressosDisponivel == exibicao.quantidadeIngressosDisponivel && Double.compare(preco, exibicao.preco) == 0 && Objects.equals(sala, exibicao.sala) && Objects.equals(filme, exibicao.filme) && Objects.equals(data, exibicao.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sala, filme, data, quantidadeIngressosDisponivel, preco);
    }


    public String comprarIngresso(int quantidade) {
        if (quantidadeIngressosDisponivel > 0) {
            quantidadeIngressosDisponivel -= quantidade;
            return "Ingresso comprado com sucesso";
        } else {
            return "Não há mais ingressos disponíveis nessa exibição.";
        }
    }

    @Override
    public String toString() {
        return "Exibicao{" +
                sala +
                ", filme=" + filme +
                ", quantidade Ingressos Disponivel=" + quantidadeIngressosDisponivel +
                ", preco=" + preco +
                ", data='" + data + '\'' +
                '}';
    }
}


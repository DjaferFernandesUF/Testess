package cinefilos;

import cinefilos.cartaofidelidade.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Cliente implements Serializable  {
    private String nome;
    private String email;
    private String senha;
    private int pontos;
    private CartaoFidelidade cartao;
    private List<ItemCarrinhoIF> carrinho;
    private List<ItemCarrinhoIF> carrinhoDoRelatorio;
    private double valorASerPago;

    public Cliente(String nome, String email, String senha) {
        try {
            if (nome == null || nome.trim().isEmpty() || nome.matches(".*\\d.*")) {
                throw new IllegalArgumentException("Nome inválido");
            }
            this.nome = nome;

            if (email == null || email.trim().isEmpty() || !email.contains("@")) {
                throw new IllegalArgumentException("Email inválido");
            }
            this.email = email;

            if (senha == null || senha.trim().isEmpty()) {
                throw new IllegalArgumentException("Senha inválida");
            }
            this.senha = senha;
        } catch (IllegalArgumentException e) {
            System.err.println("Erro ao criar cliente: " + e.getMessage());
        }
        this.pontos = 0;
        this.cartao = new Silver();
        this.carrinho = new ArrayList<>();
        this.carrinhoDoRelatorio = new ArrayList<>();
        this.valorASerPago = 0;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty() || nome.matches(".*\\d.*")) {
            return;
        }
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email == null || email.trim().isEmpty() || !email.contains("@")) {
            return;
        }
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        if (senha == null || senha.trim().isEmpty()) {
            return;
        }
        this.senha = senha;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    public CartaoFidelidade getCartao() {
        return cartao;
    }

    public void setCartao(CartaoFidelidade cartao) {
        this.cartao = cartao;
    }

    public List<ItemCarrinhoIF> getCarrinho() {
        return carrinho;
    }

    public List<ItemCarrinhoIF> getCarrinhoDoRelatorio() {
        return carrinhoDoRelatorio;
    }

    public double getValorASerPago() {
        return valorASerPago;
    }

    public double pagarCompra() {
        for (ItemCarrinhoIF item : carrinho) {
            this.valorASerPago += item.getPreco();
            this.carrinhoDoRelatorio.add(item);


            DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
            LocalDateTime data = LocalDateTime.now();
            String dataFormatada = data.format(formatador);
            item.setData(dataFormatada);

        }
        return valorASerPago;
    }

    public void atualizarCartao() {
        CartaoFidelidade cartao1 = new Gold();
        CartaoFidelidade cartao2 = new Platinum();
        CartaoFidelidade cartao3 = new Black();

        if (pontos >= cartao1.getPontosParaAtingir() && pontos < cartao2.getPontosParaAtingir()) {
            this.cartao = cartao1;
        } else if (pontos >= cartao2.getPontosParaAtingir() && pontos < cartao3.getPontosParaAtingir()) {
            this.cartao = cartao2;
        } else if (pontos > cartao2.getPontosParaAtingir()) {
            this.cartao = cartao3;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(nome, cliente.nome) && Objects.equals(email, cliente.email) && Objects.equals(senha, cliente.senha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, email, senha);
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", pontos=" + pontos +
                ", cartao=" + cartao +
                ", valorASerPago=" + valorASerPago +
                '}';
    }
}

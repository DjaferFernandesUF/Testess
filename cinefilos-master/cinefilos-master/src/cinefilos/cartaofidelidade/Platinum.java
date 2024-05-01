package cinefilos.cartaofidelidade;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Platinum implements CartaoFidelidade {
    private double divisor;
    private double desconto;
    private double valorParaAplicarDesconto;
    private int pontosParaAtingir;

    public Platinum() {
        this.divisor = divisor = 45;
        this.desconto = desconto = 1 - 0.06;
        this.valorParaAplicarDesconto = 160;
        this.pontosParaAtingir = 50;
    }

    public double getDivisor() {
        return divisor;
    }

    public void setDivisor(double divisor) {
        this.divisor = divisor;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    public double getValorParaAplicarDesconto() {
        return valorParaAplicarDesconto;
    }

    public void setValorParaAplicarDesconto(double valorParaAplicarDesconto) {
        this.valorParaAplicarDesconto = valorParaAplicarDesconto;
    }

    public int getPontosParaAtingir() {
        return pontosParaAtingir;
    }

    public void setPontosParaAtingir(int pontosParaAtingir) {
        this.pontosParaAtingir = pontosParaAtingir;
    }

    @Override
    public int verificarPontos(double valor) {
        List<Double> valoresMenores = new ArrayList<>();
        double somaValores = 0;
        if (valor >= divisor) {
            return (int) (valor / divisor);
        } else {
            valoresMenores.add(valor);

            for (double v : valoresMenores) {
                somaValores += v;

                if (somaValores >= divisor) {
                    return (int) (somaValores / divisor);
                }
            }
        }
        return 0;
    }

    @Override
    public double aplicarDesconto(double valor) {
        if (valor >= valorParaAplicarDesconto) {
            return valor * divisor;
        }
        return valor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Platinum platinum = (Platinum) o;
        return Double.compare(divisor, platinum.divisor) == 0 && Double.compare(desconto, platinum.desconto) == 0 && Double.compare(valorParaAplicarDesconto, platinum.valorParaAplicarDesconto) == 0 && pontosParaAtingir == platinum.pontosParaAtingir;
    }

    @Override
    public int hashCode() {
        return Objects.hash(divisor, desconto, valorParaAplicarDesconto, pontosParaAtingir);
    }

    @Override
    public String toString() {
        return "Platinum{" +
                "Divisor: " + divisor +
                ", Desconto: " + desconto +
                ", Valor para aplicar desconto: " + valorParaAplicarDesconto +
                ", Pontos para atingir: " + pontosParaAtingir +
                '}';
    }
}

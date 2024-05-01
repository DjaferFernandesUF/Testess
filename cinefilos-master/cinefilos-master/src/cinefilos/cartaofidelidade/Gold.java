package cinefilos.cartaofidelidade;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Gold implements CartaoFidelidade {
    private double divisor;
    private double desconto;
    private double valorParaAplicarDesconto;
    private int pontosParaAtingir;

    public Gold() {
        this.divisor = divisor = 40;
        this.desconto = desconto = 1 - 0.03;
        this.valorParaAplicarDesconto = 120;
        this.pontosParaAtingir = 20;
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
        Gold gold = (Gold) o;
        return Double.compare(divisor, gold.divisor) == 0 && Double.compare(desconto, gold.desconto) == 0 && Double.compare(valorParaAplicarDesconto, gold.valorParaAplicarDesconto) == 0 && pontosParaAtingir == gold.pontosParaAtingir;
    }

    @Override
    public int hashCode() {
        return Objects.hash(divisor, desconto, valorParaAplicarDesconto, pontosParaAtingir);
    }

    @Override
    public String toString() {
        return "Gold{" +
                "Divisor: " + divisor +
                ", Desconto: " + desconto +
                ", Valor para aplicar desconto: " + valorParaAplicarDesconto +
                ", Pontos para atingir: " + pontosParaAtingir +
                '}';
    }
}

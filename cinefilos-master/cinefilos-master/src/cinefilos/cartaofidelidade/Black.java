package cinefilos.cartaofidelidade;

import java.util.ArrayList;
import java.util.List;

public class Black implements CartaoFidelidade {
    private double divisor;
    private double desconto;
    private double valorParaAplicarDesconto;
    private int pontosParaAtingir;

    public Black() {
        this.divisor = divisor = 50;
        this.desconto = desconto = 1 - 0.12;
        this.valorParaAplicarDesconto = 200;
        this.pontosParaAtingir = 80;
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

}

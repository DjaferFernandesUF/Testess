package cinefilos.cartaofidelidade;

import java.util.Objects;

public class Silver implements CartaoFidelidade {
    private double divisor;

    public Silver() {
        this.divisor = 35;
    }

    public double getDivisor() {
        return divisor;
    }

    public void setDivisor(double divisor) {
        this.divisor = divisor;
    }

    @Override
    public int getPontosParaAtingir() {
        return 0;
    }

    @Override
    public void setPontosParaAtingir(int pontosParaAtingir) {

    }

    @Override
    public int verificarPontos(double valor) {
        return (int) (valor / divisor);
    }

    @Override
    public double aplicarDesconto(double valor) {
        return valor;
    }

    @Override
    public void setDesconto(double desconto) {

    }

    @Override
    public double getValorParaAplicarDesconto() {
        return 1;
    }

    @Override
    public void setValorParaAplicarDesconto(double valorParaAplicarDesconto) {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Silver silver = (Silver) o;
        return Double.compare(divisor, silver.divisor) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(divisor);
    }

    @Override
    public String toString() {
        return "Silver{" +
                "Divisor: " + divisor +
                '}';
    }
}

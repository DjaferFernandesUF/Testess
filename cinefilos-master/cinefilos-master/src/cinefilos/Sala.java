package cinefilos;

import java.io.Serializable;
import java.util.Objects;

public class Sala implements Serializable {
    private int quantidadePoltronas;
    private int numeroDaSala;
    private PrecoSalas tipo;
    private double preco;

    public Sala(int quantidadePoltronas, String tipo, int numero) {
        this.quantidadePoltronas = quantidadePoltronas;
        this.numeroDaSala = numero;

        if (tipo.equalsIgnoreCase(PrecoSalas.SalaBasica.getTipo())) {
            this.tipo = PrecoSalas.SalaBasica;
            this.preco = PrecoSalas.SalaBasica.getPreco();
        } else if (tipo.equalsIgnoreCase(PrecoSalas.Sala3D.getTipo())) {
            this.tipo = PrecoSalas.Sala3D;
            this.preco = PrecoSalas.Sala3D.getPreco();
        } else if (tipo.equalsIgnoreCase(PrecoSalas.SalaVIP.getTipo())) {
            this.tipo = PrecoSalas.SalaVIP;
            this.preco = PrecoSalas.SalaVIP.getPreco();
        }

    }

    public int getQuantidadePoltronas() {
        return quantidadePoltronas;
    }

    public void setQuantidadePoltronas(int quantidadePoltronas) {
        this.quantidadePoltronas = quantidadePoltronas;
    }

    public String getTipo() {
        return tipo.getTipo();
    }

    public double getPreco() {
        return preco;
    }

    public int getNumeroDaSala() {
        return numeroDaSala;
    }

    public void setNumeroDaSala(int numeroDaSala) {
        this.numeroDaSala = numeroDaSala;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sala sala = (Sala) o;
        return quantidadePoltronas == sala.quantidadePoltronas && numeroDaSala == sala.numeroDaSala && Double.compare(preco, sala.preco) == 0 && tipo == sala.tipo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(quantidadePoltronas, numeroDaSala, tipo, preco);
    }

    @Override
    public String toString() {
        return "Sala{" +
                "quantidadePoltronas=" + quantidadePoltronas +
                ", numeroDaSala=" + numeroDaSala +
                ", tipo=" + tipo +
                ", preco=" + preco +
                '}';
    }
}


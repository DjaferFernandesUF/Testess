package cinefilos;

public enum PrecoSalas {
    SalaBasica("Básica",10),
    Sala3D("3D",15),
    SalaVIP("VIP",35);

    private String tipo;
    private double preco;
    PrecoSalas(String tipo, double preco) {
        this.tipo = tipo;
        this.preco = preco;
    }

    public String getTipo() {
        return tipo;
    }

    public double getPreco() {
        return preco;
    }
}

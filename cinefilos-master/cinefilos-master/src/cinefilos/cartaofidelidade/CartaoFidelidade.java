package cinefilos.cartaofidelidade;

public abstract interface CartaoFidelidade {

    public abstract int verificarPontos(double valor);

    public double aplicarDesconto(double valor);

    public double getDivisor();

    public void setDivisor(double divisor);

    public void setDesconto(double desconto);

    public double getValorParaAplicarDesconto();

    public void setValorParaAplicarDesconto(double valorParaAplicarDesconto);

    public abstract int getPontosParaAtingir();

    public void setPontosParaAtingir(int pontosParaAtingir);
}

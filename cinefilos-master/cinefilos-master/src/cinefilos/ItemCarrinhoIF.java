package cinefilos;

public interface ItemCarrinhoIF {

    public String getData();

    public void setData(String data);

    public double getPreco();

    public void setPreco(double preco);

    public int getQuantidade();

    public void setQuantidade(int quantidade);

    public String vendeItem(int quantidade);
}

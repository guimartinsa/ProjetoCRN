package model;

public class Desconto {
    private final String descricao;
    private final double valor;

    public Desconto(String descricao, double valor) {
        this.descricao = descricao;
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getValor() {
        return valor;
    }
}

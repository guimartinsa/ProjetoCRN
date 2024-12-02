package src.model;

public class Item {
    private String nome;
    private String tipo; // Alimentação, Educação, Lazer
    private double preco;
    private int quantidade;

    public Item(String nome, String tipo, double preco, int quantidade) {
        this.nome = nome;
        this.tipo = tipo;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public double getValorTotal() {
        return preco * quantidade;
    }

    public String getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        return "Item{" +
                "nome='" + nome + '\'' +
                ", tipo='" + tipo + '\'' +
                ", preco=" + preco +
                ", quantidade=" + quantidade +
                '}';
    }
}

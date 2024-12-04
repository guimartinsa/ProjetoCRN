package model;

public class Item {
    private String nome;
    private String tipo; // Alimentação, Educação, Lazer
    private double preco;
    private int quantidade;

    public Item(String nome, String tipo, double preco, int quantidade) {
        if (preco <= 0) throw new IllegalArgumentException("O preço deve ser positivo.");
        if (quantidade <= 0) throw new IllegalArgumentException("A quantidade deve ser positiva.");
        this.nome = nome;
        this.tipo = tipo;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    // Métodos getter
    public String getNome() {
        return nome;
    }

    public String getTipo() {
        return tipo;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    // Método para calcular o valor total do item
    public double getValorTotal() {
        return preco * quantidade;
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

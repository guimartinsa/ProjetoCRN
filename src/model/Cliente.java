package model;

public class Cliente {
    private String nome;
    private String tipo; // Ouro, Prata, Bronze

    public Cliente(String nome, String tipo) {
        this.nome = nome;
        if (!tipo.equals("Ouro") && !tipo.equals("Prata") && !tipo.equals("Bronze")) {
            throw new IllegalArgumentException("Tipo de cliente inválido.");
        }
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public String getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}

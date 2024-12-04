package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private double taxaEntrega;
    private LocalDate dataPedido;
    private Cliente cliente;
    private String codigoDeCupom;
    private final List<Item> itens = new ArrayList<>();

    public Pedido(double taxaEntrega, LocalDate dataPedido, Cliente cliente) {
        this.taxaEntrega = taxaEntrega;
        this.dataPedido = dataPedido;
        this.cliente = cliente;
    }

    public void adicionarItem(Item item) {
        itens.add(item);
    }

    public List<Item> getItens() {
        return itens;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public String getCodigoDeCupom() {
        return codigoDeCupom;
    }

    public void setCodigoDeCupom(String codigoDeCupom) {
        this.codigoDeCupom = codigoDeCupom;
    }

    public double calcularValorTotal() {
        return itens.stream().mapToDouble(Item::getValorTotal).sum() + taxaEntrega;
    }

    public void validarCupom() {
        if (this.codigoDeCupom != null && !validarCodigoDeCupom(this.codigoDeCupom)) {
            throw new IllegalArgumentException("Cupom inválido.");
        }
    }
    
    private boolean validarCodigoDeCupom(String codigo) {
        // Lógica para validar o código do cupom (exemplo simples)
        return codigo.equals("DESC10"); // Substitua com a lógica real
    }
    

    public void exibirDetalhes() {
        System.out.println("Cliente: " + cliente.getNome());
        System.out.println("Itens do Pedido:");
        for (Item item : itens) {
            System.out.println("- " + item.getNome() + ": " + item.getQuantidade() + " x R$" + item.getPreco());
        }
        System.out.println("Taxa de Entrega: R$" + taxaEntrega);
        System.out.println("Valor Total: R$" + calcularValorTotal());
    }
}

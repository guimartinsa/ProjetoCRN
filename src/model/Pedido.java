package src.model;

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
}

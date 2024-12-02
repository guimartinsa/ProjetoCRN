package src.service;

import src.model.Pedido;

public class DescontoPorCategoriaCliente implements IDesconto {
    @Override
    public double calcular(Pedido pedido) {
        switch (pedido.getCliente().getTipo()) {
            case "Ouro":
                return pedido.calcularValorTotal() * 0.30;
            case "Prata":
                return pedido.calcularValorTotal() * 0.20;
            case "Bronze":
                return pedido.calcularValorTotal() * 0.10;
            default:
                return 0.0;
        }
    }

    @Override
    public boolean aplicar(Pedido pedido) {
        return pedido.getCliente() != null;
    }
}

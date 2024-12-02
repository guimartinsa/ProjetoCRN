package src.service;

import src.model.Item;
import src.model.Pedido;

public class DescontoPorTipoItem implements IDesconto {
    @Override
    public double calcular(Pedido pedido) {
        return pedido.getItens().stream()
                .mapToDouble(item -> {
                    switch (item.getTipo()) {
                        case "Alimentação": return item.getValorTotal() * 0.05;
                        case "Educação": return item.getValorTotal() * 0.20;
                        case "Lazer": return item.getValorTotal() * 0.15;
                        default: return 0.0;
                    }
                }).sum();
    }

    @Override
    public boolean aplicar(Pedido pedido) {
        return pedido.getCodigoDeCupom() == null && pedido.getCliente().getTipo() == null;
    }
}

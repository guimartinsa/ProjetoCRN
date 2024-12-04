package service;

import model.Item;
import model.Pedido;

import java.util.Map;

public class DescontoPorTipoItem implements IDesconto {
    private static final Map<String, Double> descontosPorTipo = Map.of(
            "Alimentação", 0.05,
            "Educação", 0.20,
            "Lazer", 0.15
    );

    @Override
    public double calcular(Pedido pedido) {
        return pedido.getItens().stream()
                .mapToDouble(item -> descontosPorTipo.getOrDefault(item.getTipo(), 0.0) * item.getValorTotal())
                .sum();
    }

    @Override
    public boolean aplicar(Pedido pedido) {
        return pedido.getCodigoDeCupom() == null && pedido.getCliente().getTipo() == null;
    }
}

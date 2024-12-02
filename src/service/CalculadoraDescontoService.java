package src.service;

import src.model.Pedido;

import java.util.ArrayList;
import java.util.List;

public class CalculadoraDescontoService {
    private final List<IDesconto> descontos = new ArrayList<>();

    public CalculadoraDescontoService() {
        descontos.add(new DescontoPorCodigoCupom());
        descontos.add(new DescontoPorCategoriaCliente());
        descontos.add(new DescontoPorTipoItem());
    }

    public double calcularDesconto(Pedido pedido) {
        for (IDesconto desconto : descontos) {
            if (desconto.aplicar(pedido)) {
                return desconto.calcular(pedido);
            }
        }
        return 0.0;
    }
}

package service;

import model.Pedido;

public class DescontoPorCodigoCupom implements IDesconto {
    @Override
    public double calcular(Pedido pedido) {
        if ("DESC10".equals(pedido.getCodigoDeCupom())) return pedido.calcularValorTotal() * 0.10;
        if ("DESC20".equals(pedido.getCodigoDeCupom())) return pedido.calcularValorTotal() * 0.20;
        if ("DESC30".equals(pedido.getCodigoDeCupom())) return pedido.calcularValorTotal() * 0.30;
        return 0.0;
    }

    @Override
    public boolean aplicar(Pedido pedido) {
        return pedido.getCodigoDeCupom() != null;
    }
}

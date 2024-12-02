package src.service;

import src.model.Pedido;

public interface IDesconto {
    double calcular(Pedido pedido);
    boolean aplicar(Pedido pedido);
}

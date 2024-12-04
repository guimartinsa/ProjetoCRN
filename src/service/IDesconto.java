package service;

import model.Pedido;

public interface IDesconto {
    double calcular(Pedido pedido);
    boolean aplicar(Pedido pedido);
}

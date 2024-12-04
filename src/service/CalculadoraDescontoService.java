package service;

import model.Pedido;

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
        double descontoAplicado = 0.0;
        for (IDesconto desconto : descontos) {
            if (desconto.aplicar(pedido)) {
                descontoAplicado = desconto.calcular(pedido);
                System.out.println("Desconto aplicado: R$" + descontoAplicado);
                break;
            }
        }
        return descontoAplicado;
    }
}

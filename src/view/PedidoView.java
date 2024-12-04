package view;

import model.Pedido;

public class PedidoView {
    public void exibirDetalhesPedido(Pedido pedido) {
        System.out.println("Detalhes do Pedido:");
        pedido.getItens().forEach(item -> {
            System.out.println("- " + item.getNome() + ": " + item.getQuantidade() + " x R$" + item.getPreco());
        });
        System.out.println("Taxa de Entrega: R$" + pedido.calcularValorTotal());  // Incluindo taxa de entrega
    }
}

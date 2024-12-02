package src.main;

import src.model.Cliente;
import src.model.Item;
import src.model.Pedido;
import src.service.CalculadoraDescontoService;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Cliente cliente = new Cliente("João", "Ouro");
        Pedido pedido = new Pedido(10.0, LocalDate.now(), cliente);
        pedido.adicionarItem(new Item("Livro", "Educação", 50.0, 2));
        pedido.adicionarItem(new Item("Pizza", "Alimentação", 40.0, 1));

        CalculadoraDescontoService calculadora = new CalculadoraDescontoService();
        double desconto = calculadora.calcularDesconto(pedido);

        System.out.println("Valor Total: " + pedido.calcularValorTotal());
        System.out.println("Desconto Aplicado: " + desconto);
        System.out.println("Valor Final: " + (pedido.calcularValorTotal() - desconto));
    }
}

package main;
import log.DBLog;
import log.PedidoLogger;
import model.Cliente;
import model.Item;
import model.Pedido;
import service.CalculadoraDescontoService;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        try {
            // Criação do cliente e pedido
            Cliente cliente = new Cliente("João", "Ouro");
            double taxaDeEntrega = 10.0;
            Pedido pedido = new Pedido(taxaDeEntrega, LocalDate.now(), cliente);
            pedido.adicionarItem(new Item("Livro", "Educação", 50.0, 2));
            pedido.adicionarItem(new Item("Pizza", "Alimentação", 40.0, 1));

            // Calcular valor total e aplicar desconto
            CalculadoraDescontoService calculadora = new CalculadoraDescontoService();
            double desconto = calculadora.calcularDesconto(pedido);
            double valorFinal = pedido.calcularValorTotal() - desconto;

            // Obter data e hora para o log
            String data = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            String hora = java.time.LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));

            // Registrar log (usando DBLog como exemplo)
            PedidoLogger pedidoLogger = new PedidoLogger(new DBLog());
            pedidoLogger.registrarLog(data, hora, 1234, "Calculo do valor total do pedido (calcularValorTotal)", cliente.getNome());

            // Exibir o valor final
            System.out.println("Valor Final: R$" + valorFinal);
        } catch (Exception e) {
            System.out.println("Ocorreu um erro: " + e.getMessage());
        }
    }
}

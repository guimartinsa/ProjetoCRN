// log/PedidoLogger.java
package log;

import ufes.br.util.UsuarioLogadoService;

public class PedidoLogger {
    private ILog log;

    public PedidoLogger(ILog log) {
        this.log = log;
    }

    public void registrarLog(String data, String hora, int codigoPedido, String nomeOperacao, String nomeCliente) {
        String nomeUsuario = UsuarioLogadoService.getNomeUsuario();
        log.registrarLog(nomeUsuario, data, hora, codigoPedido, nomeOperacao, nomeCliente);
    }
}

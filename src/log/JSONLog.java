import com.google.gson.Gson;

public class JSONLog implements ILog {
    @Override
    public void registrarLog(String nomeUsuario, String data, String hora, int codigoPedido, String nomeOperacao, String nomeCliente) {
        LogEntry entry = new LogEntry(nomeUsuario, data, hora, codigoPedido, nomeOperacao, nomeCliente);
        Gson gson = new Gson();
        String json = gson.toJson(entry);
        System.out.println("Log em JSON: " + json);
    }

    private static class LogEntry {
        String nomeUsuario;
        String data;
        String hora;
        int codigoPedido;
        String nomeOperacao;
        String nomeCliente;

        public LogEntry(String nomeUsuario, String data, String hora, int codigoPedido, String nomeOperacao, String nomeCliente) {
            this.nomeUsuario = nomeUsuario;
            this.data = data;
            this.hora = hora;
            this.codigoPedido = codigoPedido;
            this.nomeOperacao = nomeOperacao;
            this.nomeCliente = nomeCliente;
        }
    }
}

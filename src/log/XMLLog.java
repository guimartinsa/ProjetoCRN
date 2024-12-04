// src/log/XMLLog.java
package log;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import java.io.File;
import java.io.FileWriter;

public class XMLLog implements ILog {

    private static final String FILE_PATH = "log.xml";  // Caminho do arquivo XML

    @Override
    public void registrarLog(String nomeUsuario, String data, String hora, int codigoPedido, String nomeOperacao, String nomeCliente) {
        try {
            File xmlFile = new File(FILE_PATH);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.newDocument();

            Element rootElement = doc.createElement("logs");
            doc.appendChild(rootElement);

            Element logEntry = doc.createElement("logEntry");
            rootElement.appendChild(logEntry);

            addElement(doc, logEntry, "nomeUsuario", nomeUsuario);
            addElement(doc, logEntry, "data", data);
            addElement(doc, logEntry, "hora", hora);
            addElement(doc, logEntry, "codigoPedido", String.valueOf(codigoPedido));
            addElement(doc, logEntry, "nomeOperacao", nomeOperacao);
            addElement(doc, logEntry, "nomeCliente", nomeCliente);

            FileWriter writer = new FileWriter(xmlFile);
            writer.write(doc.toString());
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void addElement(Document doc, Element parent, String tagName, String textContent) {
        Element element = doc.createElement(tagName);
        element.appendChild(doc.createTextNode(textContent));
        parent.appendChild(element);
    }
}

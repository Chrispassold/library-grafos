import src.core.Grafo;
import src.core.Vertice;

import java.io.IOException;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        Grafo grafo = new Grafo("C:\\www\\FURB\\grafos\\library-grafos\\test.tmp");
        final Map<Vertice, Integer> grauVertices = grafo.getGrauVertices();

        grauVertices.forEach((vertice, integer) -> System.out.println(String.format("Vertice %s tem grau %d", vertice.getValor(), integer)));
    }
}

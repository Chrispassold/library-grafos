import src.core.Grafo;
import src.core.Vertice;
import src.output.InformationGrafoToFile;

import java.io.IOException;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        Grafo grafo = new Grafo("test.tmp");

        InformationGrafoToFile.toFile(grafo, "./grafo.out");
    }
}

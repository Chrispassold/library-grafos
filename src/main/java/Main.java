import src.core.Grafo;
import src.core.Vertice;
import src.output.InformationGrafoToFile;

import java.io.IOException;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        Grafo grafo = new Grafo("grafo.in");
        InformationGrafoToFile.toFile(grafo, "out/grafo.out");
    }
}

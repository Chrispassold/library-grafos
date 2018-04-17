import src.core.Grafo;
import src.core.GrauVertice;

import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        Grafo grafo = new Grafo("C:\\www\\FURB\\grafos\\library-grafos\\test.tmp");
        List<GrauVertice> grauVertices = grafo.getGrauVertices();

        grauVertices.forEach(grauVertice -> System.out.println(grauVertice.toString()));
    }
}

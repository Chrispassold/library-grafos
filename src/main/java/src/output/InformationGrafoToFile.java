package src.output;

import src.core.Grafo;
import src.core.Vertice;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.Map;
import java.util.Set;

public class InformationGrafoToFile {

    public static void toFile(Grafo grafo, String destination) throws IOException, InvalidParameterException {
        if (grafo == null) throw new InvalidParameterException("Grafo não pôde ser impresso");

        try (BufferedWriter out = new BufferedWriter(new FileWriter(destination))) {
            //Inicio da contagem das arestas
            int arestas = 0;

            //Escreve o grau dos vertices
            final Set<Map.Entry<Vertice, Integer>> entries = grafo.getGrauVertices().entrySet();
            for (Map.Entry<Vertice, Integer> verticeIntegerEntry : entries) {
                out.write(String.format("Vertice %s tem grau %d", verticeIntegerEntry.getKey().getValor(), verticeIntegerEntry.getValue()));
                arestas += verticeIntegerEntry.getValue();
                out.newLine();
            }

            //Escreve a quantidade de arestas
            out.write(String.format("Quantidade de arestas: %d", arestas));
            out.newLine();

            //Escreve a quantidade de vertices
            out.write(String.format("Quantidade de vértices: %d", grafo.getQuantidadeVertices()));

            System.out.printf("O arquivo de saída foi gerado em %s", destination);
        }
    }
}

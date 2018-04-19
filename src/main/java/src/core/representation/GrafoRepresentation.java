package src.core.representation;

import src.core.Vertice;

import java.io.IOException;
import java.util.Map;

public interface GrafoRepresentation {
    void mount(String arquivo) throws IOException;

    int getQuantidadeVertices();

    void inserirAresta(Vertice verticeOrigem, Vertice verticeDestino);

    void removerAresta(Vertice verticeOrigem, Vertice verticeDestino);

    boolean existeAresta(Vertice verticeOrigem, Vertice verticeDestino);

    Map<Vertice, Integer> getGrauVertices();
}

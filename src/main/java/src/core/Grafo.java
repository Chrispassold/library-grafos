package src.core;

import java.io.IOException;
import java.util.Map;

public class Grafo {

    private MatrizAdjacencia _matrizAdjacencia;

    /**
     * Cria um novo grafo baseado na leitura de arquivo.
     *
     * @param arquivo Arquivo para leitura.
     */
    public Grafo(String arquivo) throws IOException {
        _matrizAdjacencia = MatrizAdjacencia.mount(arquivo);
    }

    public int getQuantidadeVertices() {
        return _matrizAdjacencia.getQuantidadeVertices();
    }

    public Map<Vertice, Integer> getGrauVertices() {
        return _matrizAdjacencia.getGrauVertices();
    }
}

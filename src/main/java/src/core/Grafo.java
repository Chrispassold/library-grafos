package src.core;

import src.core.representation.GrafoRepresentation;
import src.core.representation.GrafoRepresentationFactory;

import java.io.IOException;
import java.util.Map;

public class Grafo {

    private GrafoRepresentation _representation;

    /**
     * Cria um novo grafo baseado na leitura de arquivo.
     *
     * @param arquivo Arquivo para leitura.
     */
    public Grafo(String arquivo) throws IOException {
        _representation = GrafoRepresentationFactory.create(GrafoRepresentationFactory.EGrafoRepresentation.MATRIZ_ADJACENCIA);
        _representation.mount(arquivo);
    }

    public int getQuantidadeVertices() {
        return _representation.getQuantidadeVertices();
    }

    public Map<Vertice, Integer> getGrauVertices() {
        return _representation.getGrauVertices();
    }
}
